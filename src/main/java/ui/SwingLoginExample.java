package ui;

import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.junit.Test;

public class SwingLoginExample {


    private static JTextArea lalText;
    private static JTextField nameText;
    private static JButton parseButton;

    private static String data = "";
    private static String name = "";
    private final static String path = "D:\\Users\\10729\\data.txt";



    public static void main(String[] args) {    
        // 创建 JFrame 实例
        JFrame frame = new JFrame("GPS数据解析");
        // Setting the width and height of frame
        frame.setSize(370, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /* 
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建 JLabel
        JLabel userLabel = new JLabel("原始数据:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(0,0,80,25);
        panel.add(userLabel);

        JLabel nameLabel = new JLabel("轨迹命名:");
        nameLabel.setBounds(0,130,80,25);
        panel.add(nameLabel);

        /* 
         * 创建文本域用于用户输入
         */
        lalText = new JTextArea();
        lalText.setBounds(25,25,300,100);
        lalText.setLineWrap(true);
        panel.add(lalText);

        nameText = new JTextField();
        nameText.setBounds(60,130,100,25);
        panel.add(nameText);
        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */

        parseButton = new JButton("解析");
        parseButton.setBounds(243, 130, 80, 25);
        parseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(lalText.getText());
                name = nameText.getText();
                data = parse(lalText.getText());
                try {
                    writeFile(path);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        panel.add(parseButton);
    }

    public static void writeFile(String s) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(s));
        bufferedWriter.write(data);
        bufferedWriter.flush();
        bufferedWriter.close();

    }

    public static String parse(String data){

        Route route = new Route();
        ArrayList<double[]> list = new ArrayList<double[]>();
        String []arrStr = data.split(";");
        System.out.println(arrStr.toString());
        for (int i = 0; i < arrStr.length; i++) {
            String  temp [] = arrStr[i].split(",");
            double [] arrDouble = new double[]{0.0,0.0};
            arrDouble[0] = angleToRad(Double.valueOf(temp[0]));
            arrDouble[1] = angleToRad(Double.valueOf(temp[1]));
            list.add(arrDouble);
        }
        route.setName(name);
        route.setPath(list);
        String json = new Gson().toJson(route);
        return json;
    }
    @Test
    public void Test(){

        String string = parse("116.405289,39.904987;116.406265,39.905014;116.406441,39.905018;116.406647,39.905018;116.407013,39.905045;116.406944,39.906036;116.406937,39.9063;116.406807,39.907856;116.406807,39.907856;116.407486,39.907875;");
        System.out.println(string);
        System.out.println(angleToRad(11312.10102));
    }



    public static double angleToRad(double num){
        int angle = 0;
        int min = 0;
        double  sec = 0.0;
        angle = (int) (num / 100);
        min = (int) (num % 100);
        sec = num / 60;
        double temp =  0.0;
        temp = angle + min/60.0 + sec/3600.0;
        temp = (double) Math.round(temp * 100000) / 100000;
        return temp;
    }

}