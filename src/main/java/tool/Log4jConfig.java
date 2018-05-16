package tool;

import org.apache.log4j.PropertyConfigurator;

public class Log4jConfig {
    private static boolean isReload = true;  
      

    public static void load() {  
        String path =Thread.currentThread().getContextClassLoader().getResource("./log4j.properties").getPath();
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