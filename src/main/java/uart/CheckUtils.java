package uart;

//校验GPS数据的正确性
//$GPRMC,045131.00,A,2304.28232,N,11312.65884,E,0.389,,210418,,,A*75
public class CheckUtils {


  public static void main(String[] a) {

    String data = "$GPGGA,045337.00,2304.28192,N,11312.66022,E,1,08,0.89,2.9,M,-5.8,M,,*4D";
    System.out.println(checked(data));

  }

  /**
   *
   * @param data  待检测的字符串
   * @return  检测结果
   * 校验值 = $ 和 * 之间的字符异或值
   */
  public static boolean checked(String data) {
    String checkedArr[] = data.split("\\*");
    try{
      int num = checkedArr[0].charAt(1);
      for (int i = 2; i < checkedArr[0].length(); i++) {
        num ^= checkedArr[0].charAt(i);
      }
      return Integer.toString(num, 16).toUpperCase().equals(checkedArr[1]) ? true : false;
    }catch(Exception e){
      System.out.println(e);
      return false;
    }
  }
  

    
    
    



}
