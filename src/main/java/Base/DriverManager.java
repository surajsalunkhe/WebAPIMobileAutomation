package Base;

import enums.PlatformToRun;
import io.appium.java_client.AppiumDriver;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private WebDriver webDriver;
    private AppiumDriver appiumDriver;
    private RestAssured restAssured;
    private static String lplatform;
    private static String lenviornment;
    private static boolean isRemote;


    public static String getPlatformToRun() {
        lplatform=System.getProperty("platform");
        return lplatform;
    }

    public static String getEnviornmentToRun() {
        lenviornment=System.getProperty("env");
        return lenviornment;
    }

    public void SetUpDriver(){
    PlatformToRun platform=PlatformToRun.valueOf(getPlatformToRun());
    if(platform.equals(null)){

    }
    switch (platform){
        case WEB:
            System.out.println("WEB");
            break;
        case WEB_ANGULAR:System.out.println("WEB_ANGULAR");
            break;
        case API:
            System.out.println("API");
            break;
        case MOBILE:
            System.out.println("WEB");
            break;
    }

    }

}
