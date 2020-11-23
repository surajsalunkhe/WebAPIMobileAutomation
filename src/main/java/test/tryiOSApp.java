package test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.HashMap;

public class tryiOSApp {

        public static IOSDriver driver;
        public static int expectedAirplaneStatus;
        public static By airplaneBtn = MobileBy.xpath("//XCUIElementTypeSwitch[@name='Airplane Mode']");
        public static By Allow = MobileBy.xpath("//XCUIElementTypeButton[@name='Allow']");
        public static String settingsMenu = "com.apple.Preferences";
        //public static String stock = "com.apple.stocks";
        public static String nbfbundle="com.mastercard.mobile.wallet.ae.consumer.nbf";
         public static String stock="/Users/e075110/Repo/gazelle_qa/Automation/UI/src/main/resources/config/EN/SILO/PERF/NBF_MSQ/CWLA/local_ios/NBF_Stage2_v030_PI7_17_04_2020_otp_bp.ipa";

        public static void main(String[] args) throws Exception {
            HashMap<String, Object> param = new HashMap<>();
            param.put(MobileCapabilityType.PLATFORM, "ios");
            param.put(MobileCapabilityType.PLATFORM_VERSION, "13.4");
            param.put(MobileCapabilityType.DEVICE_NAME, "iPhone");
            param.put(MobileCapabilityType.UDID, "9469f9ac7658192864f34e33cab2815919982721");
            param.put(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            param.put(IOSMobileCapabilityType.BUNDLE_ID,nbfbundle);
            param.put(MobileCapabilityType.APP, stock);
            //param.put(MobileCapabilityType.LANGUAGE, "ar");
            //param.put(MobileCapabilityType.LOCALE, "ae");
            param.put(MobileCapabilityType.NO_RESET,true);
            param.put("useNewWDA", false);
            //param.put(IOSMobileCapabilityType.BUNDLE_ID, settingsMenu);

            DesiredCapabilities capabilities = new DesiredCapabilities(param);
        /*capabilities.setCapability(MobileCapabilityType.PLATFORM, "ios");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.4");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
        capabilities.setCapability(MobileCapabilityType.UDID, "c005122e0ba2c01ed7b6ecb45a4b1be5926b0111");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, settingsMenu);
        //capabilities.setCapability(MobileCapabilityType.APP, "[PATH_TO_YOUR_.APP_FILE_THAT_YOU_COMPILED]");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("useNewWDA", false);*/
            driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        }
}
