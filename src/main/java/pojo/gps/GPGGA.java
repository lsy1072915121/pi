package pojo.gps;
//GPS定位信息
//$GPGGA,023543.00,2308.28715,N,11322.09875,E,1,06,1.49,41.6,M,-5.3,M,,*7D
public class GPGGA {

  private String utcTime;   //格式为hhmmss.ss；
  private String lat;
  private String lon;
  private String latHem;     //纬度半球
  private String lonHem;    //经度半球
  private String gpsStat;     //GPS状态 0=未定位，1=非差分定位，2=差分定位；
  private String sateNum;     //用于定位卫星数量（00~12）
  private String hdop;        //hdop水平精确度因子（0.5~99.9）
  private String height;      //海拔高度（-9999.9~9999.9米）
  private String geoHeight;   //大地水准面高度（-9999.9~9999.9米）
  private String diffTime;    //差分时间从最近一次接收到差分信号开始的秒数，非差分定位，此项为空
  private String diffFlag;    //差分参考基站标号（0000到1023，首位0也将传送，非差分定位，此项为空)


  public String getUtcTime() {
    return utcTime;
  }

  public void setUtcTime(String utcTime) {
    this.utcTime = utcTime;
  }

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getLon() {
    return lon;
  }

  public void setLon(String lon) {
    this.lon = lon;
  }

  public String getLatHem() {
    return latHem;
  }

  public void setLatHem(String latHem) {
    this.latHem = latHem;
  }

  public String getLonHem() {
    return lonHem;
  }

  public void setLonHem(String lonHem) {
    this.lonHem = lonHem;
  }

  public String getGpsStat() {
    return gpsStat;
  }

  public void setGpsStat(String gpsStat) {
    this.gpsStat = gpsStat;
  }

  public String getSateNum() {
    return sateNum;
  }

  public void setSateNum(String sateNum) {
    this.sateNum = sateNum;
  }

  public String getHdop() {
    return hdop;
  }

  public void setHdop(String hdop) {
    this.hdop = hdop;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public String getGeoHeight() {
    return geoHeight;
  }

  public void setGeoHeight(String geoHeight) {
    this.geoHeight = geoHeight;
  }

  public String getDiffTime() {
    return diffTime;
  }

  public void setDiffTime(String diffTime) {
    this.diffTime = diffTime;
  }

  public String getDiffFlag() {
    return diffFlag;
  }

  public void setDiffFlag(String diffFlag) {
    this.diffFlag = diffFlag;
  }
}
