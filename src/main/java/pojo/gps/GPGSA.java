package pojo.gps;

//当前卫星信息
//正在用于定位的卫星号（01~32）
public class GPGSA {

  private String mode;      //M = 手动，A = 自动
  private String posiType;  //定位类型 1=未定位，2=2D定位，3=3D定位
  private String sateIndex; //正在用于定位的卫星号（01~32）
  private String pdop;    //PDOP综合位置精度因子（0.5-99.9）
  private String hdop;    //HDOP水平精度因子1（0.5-99.9）
  private String vdop;    //VDOP垂直精度因子（0.5-99.9）

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public String getPosiType() {
    return posiType;
  }

  public void setPosiType(String posiType) {
    this.posiType = posiType;
  }

  public String getSateIndex() {
    return sateIndex;
  }

  public void setSateIndex(String sateIndex) {
    this.sateIndex = sateIndex;
  }

  public String getPdop() {
    return pdop;
  }

  public void setPdop(String pdop) {
    this.pdop = pdop;
  }

  public String getHdop() {
    return hdop;
  }

  public void setHdop(String hdop) {
    this.hdop = hdop;
  }

  public String getVdop() {
    return vdop;
  }

  public void setVdop(String vdop) {
    this.vdop = vdop;
  }
}
