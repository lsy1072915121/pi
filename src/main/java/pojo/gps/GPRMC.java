package pojo.gps;

//推荐定位信息
//$GPRMC,023543.00,A,2308.28715,N,11322.09875,E,0.195,,240213,,,A*78
public class GPRMC {

  private String utcTime;
  private String posiStat;
  private String lat;
  private String latHem;
  private String lon;
  private String lonHem;
  private String rate;    //地面速率（000.0~999.9节）
  private String heading; // 地面航向（000.0~359.9度，以真北方为参考基准）
  private String utcDate; //ddmmyy（日月年）
  private String declination;    //磁偏角（000.0~180.0度，前导位数不足则补0）
  private String declAngular;   // 磁偏角方向，E（东）或W（西）
  private String modeTip;

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

  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public String getHeading() {
    return heading;
  }

  public void setHeading(String heading) {
    this.heading = heading;
  }

  public String getUtcDate() {
    return utcDate;
  }

  public void setUtcDate(String utcDate) {
    this.utcDate = utcDate;
  }

  public String getDeclination() {
    return declination;
  }

  public void setDeclination(String declination) {
    this.declination = declination;
  }

  public String getDeclAngular() {
    return declAngular;
  }

  public void setDeclAngular(String declAngular) {
    this.declAngular = declAngular;
  }

  public String getModeTip() {
    return modeTip;
  }

  public void setModeTip(String modeTip) {
    this.modeTip = modeTip;
  }
}
