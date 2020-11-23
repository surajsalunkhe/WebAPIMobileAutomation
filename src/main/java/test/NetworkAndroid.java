package test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class NetworkAndroid {
    public static AndroidDriver driver;
    public static String nbfpackage = "com.mastercard.mobile.wallet.ae.consumer.nbf";
    public static String nbfActivity = "com.mastercard.mobile.wallet.ae.consumer.launch.LaunchActivity";
    public static void main(String args[]) {
        HashMap<String, Object> param = new HashMap<>();
        //param.put(MobileCapabilityType.PLATFORM, "Android");
        //param.put(MobileCapabilityType.PLATFORM_VERSION, "10");
        param.put(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        //param.put(MobileCapabilityType.DEVICE_NAME, "Galaxy S10");
        param.put(MobileCapabilityType.DEVICE_NAME, "Moto G4 Plus");
        param.put(AndroidMobileCapabilityType.APP_PACKAGE, nbfpackage);
        param.put(AndroidMobileCapabilityType.APP_ACTIVITY, nbfActivity);
        param.put(MobileCapabilityType.LANGUAGE, "ar");
        param.put(MobileCapabilityType.LOCALE, "");
        param.put(MobileCapabilityType.NO_RESET, true);
        DesiredCapabilities capabilities = new DesiredCapabilities(param);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled()
                .build());

    }
}
