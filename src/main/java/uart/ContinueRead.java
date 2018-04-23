package uart;


import java.io.*;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import gnu.io.*;

public class ContinueRead extends Thread implements
    SerialPortEventListener { // SerialPortEventListener

  // 监听器,我的理解是独立开辟一个线程监听串口数据
  static CommPortIdentifier portId; // 串口通信管理类
  static Enumeration<?> portList; // 有效连接上的端口的枚举
  InputStream inputStream; // 从串口来的输入流
  static OutputStream outputStream;// 向串口输出的流
  static SerialPort serialPort; // 串口的引用
  // 堵塞队列用来存放读到的数据
  private BlockingQueue<String> msgQueue = new LinkedBlockingQueue<String>();

  @Override
  /**
   * SerialPort EventListene 的方法,持续监听端口上是否有数据流
   *
   *
   * 波特率计算
   * 距离经纬度计算距离算法
   * GPS数据解析
   * 过滤平均值算法
   *
   *
   * 由图4.1可知，系统开始运行时首先进行初始化操作，即UART1初始化、UART2初始化和HMI初始化。
   * 初始化完毕之后，会进入一个循环体，循环体中的主要任务是GPS数据的接收和解析，发送UI数据指令的操作。
   * 码表的数据更新是基于GPS模块传输数据驱动的，MUC接收数据后将源数据进行存储，解析。
   * 解析GPS数据时首先会检测GPS数据是否有效，之后只有当GPS数据有效才进行码表的数据更新,否则会将次数据丢弃，继续等待下一次有效的GPS数据的到来；
   * 解析过程中主要解析$GPRMC帧数据和$GPGGA帧数据，通过解析两帧的数据获取海拔高度、纬度、经度、地面速率和UTC日期等信息。
   * 成功解析之后，会对解析后的数据进行过滤，剔除异常数据。如通过“经纬度计算距离算法”计算出运动距离，
   * 数据处理完之后会在MCU中缓存轨迹信息，当用户需要存储该轨迹的时候才将缓存轨迹信息往EEPROM中写入，否则轨迹信息将不会写入EEPROM。
   *
   */
  public void serialEvent(SerialPortEvent event) {//

    switch (event.getEventType()) {
      case SerialPortEvent.BI:
      case SerialPortEvent.OE:
      case SerialPortEvent.FE:
      case SerialPortEvent.PE:
      case SerialPortEvent.CD:
      case SerialPortEvent.CTS:
      case SerialPortEvent.DSR:
      case SerialPortEvent.RI:
      case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
        break;
      case SerialPortEvent.DATA_AVAILABLE:// 当有可用数据时读取数据
        byte[] readBuffer = new byte[20];
        try {
          int numBytes = -1;
          while (inputStream.available() > 0) {
            numBytes = inputStream.read(readBuffer);

            if (numBytes > 0) {
              msgQueue.add(new Date() + "真实收到的数据为：-----"
                  + new String(readBuffer));
              readBuffer = new byte[20];// 重新构造缓冲对象，否则有可能会影响接下来接收的数据
            } else {
              msgQueue.add("没有读到数据");
            }
          }
        } catch (IOException e) {
        }
        break;
    }
  }

  /**
   * 通过程序打开COM4串口，设置监听器以及相关的参数
   *
   * @return 返回1 表示端口打开成功，返回 0表示端口打开失败
   */
  public int startComPort() {
    // 通过串口通信管理类获得当前连接上的串口列表
    portList = CommPortIdentifier.getPortIdentifiers();

    while (portList.hasMoreElements()) {

      // 获取相应串口对象
      portId = (CommPortIdentifier) portList.nextElement();

      System.out.println("设备类型：--->" + portId.getPortType());
      System.out.println("设备名称：---->" + portId.getName());
      // 判断端口类型是否为串口
      if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
        // 判断如果COM4串口存在，就打开该串口
        if (portId.getName().equals("COM2")) {
          try {
            // 打开串口名字为COM_4(名字任意),延迟为2毫秒
            serialPort = (SerialPort) portId.open("COM_2", 2000);

          } catch (PortInUseException e) {
            e.printStackTrace();
            return 0;
          }
          // 设置当前串口的输入输出流
          try {
            inputStream = serialPort.getInputStream();
            outputStream = serialPort.getOutputStream();
          } catch (IOException e) {
            e.printStackTrace();
            return 0;
          }
          // 给当前串口添加一个监听器
          try {
            serialPort.addEventListener(this);
          } catch (TooManyListenersException e) {
            e.printStackTrace();
            return 0;
          }
          // 设置监听器生效，即：当有数据时通知
          serialPort.notifyOnDataAvailable(true);

          // 设置串口的一些读写参数
          try {
            // 比特率、数据位、停止位、奇偶校验位
            serialPort.setSerialPortParams(9600,
                SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);
          } catch (UnsupportedCommOperationException e) {
            e.printStackTrace();
            return 0;
          }

          return 1;
        }
      }
    }
    return 0;
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub
    try {
      System.out.println("--------------任务处理线程运行了--------------");
      while (true) {
        // 如果堵塞队列中存在数据就将其输出
        if (msgQueue.size() > 0) {
          System.out.println(msgQueue.take());
        }
      }
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    ContinueRead cRead = new ContinueRead();
    int i = cRead.startComPort();
    if (i == 1) {
      // 启动线程来处理收到的数据
      cRead.start();
      try {
        String st = "UART Init";
        System.out.println("发出字节数：" + st.getBytes("gbk").length);
        outputStream.write(st.getBytes("gbk"), 0,
            st.getBytes("gbk").length);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else {
      return;
    }
  }
}