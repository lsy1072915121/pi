package pojo.gps;

//定位地理信息
//$GPGLL,2308.28715,N,11322.09875,E,023543.00,A,A*6A
public class GPGLL {

  private String lat;
  private String latHem;
  private String lon;
  private String lonHem;
  private String utcTime;
  private String posiStat;  //A=有效定位，V=无效定位
  private String modeTip;   //（A=自主定位，D=差分，E=估算，N=数据无效

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getLatHem() {
    return latHem;
  }

  public void setLatHem(String latHem) {
    this.latHem = latHem;
  }

  public String getLon() {
    return lon;
  }

  public void setLon(String lon) {
    this.lon = lon;
  }

  public String getLonHem() {
    return lonHem;
  }

  public void setLonHem(String lonHem) {
    this.lonHem = lonHem;
  }

  public String getUtcTime() {
    return utcTime;
  }

  public void setUtcTime(String utcTime) {
    this.utcTime = utcTime;
  }

  public String getPosiStat() {
    return posiStat;
  }

  public void setPosiStat(String posiStat) {
    this.posiStat = posiStat;
  }

  public String getModeTip() {
    return modeTip;
  }

  public void setModeTip(String modeTip) {
    this.modeTip = modeTip;
  }
}
