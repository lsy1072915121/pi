package pojo.gps;

//当前时间信息
//$GPZDA,082710.00,16,09,2002,00,00*64
public class GPZDA {

  private String utcTime;
  private String day;
  private String month;
  private String year;
  private String hour;
  private String min;

  public String getUtcTime() {
    return utcTime;
  }

  public void setUtcTime(String utcTime) {
    this.utcTime = utcTime;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getHour() {
    return hour;
  }

  public void setHour(String hour) {
    this.hour = hour;
  }

  public String getMin() {
    return min;
  }

  public void setMin(String min) {
    this.min = min;
  }
}
