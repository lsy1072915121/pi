package tool;

import org.apache.log4j.PropertyConfigurator;

public class Log4jConfig {
    private static boolean isReload = true;  
      

    public static void load() {  
        String path =/* Log4jConfig.class.getClass().getResource("/")
                .getPath()  
                + */"./log4j.properties";
        //String path="config/log4j.properties";  
        System.out.println("log4j configfile path=" + path);  
        PropertyConfigurator.configureAndWatch(path,1000);// 间隔特定时间，检测文件是否修改，自动重新读取配置
    }  
  
    private static void reload() {  
        if (isReload) {  
            load();  
        }  
        isReload = false;  
    }  
  
    public void setReload(boolean flag) {  
        isReload = flag;  
    }  
  
}  