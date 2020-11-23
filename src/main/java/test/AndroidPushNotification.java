package test;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class AndroidPushNotification {
    public static AndroidDriver driver;
    public static String nbfpackage = "com.mastercard.mobile.wallet.ae.consumer.nbf";
    public static String nbfActivity = "com.mastercard.mobile.wallet.ae.consumer.launch.LaunchActivity";

    public static void main(String[] args) throws Exception {
        HashMap<String, Object> param = new HashMap<>();
        param.put(MobileCapabilityType.PLATFORM, "Android");
        param.put(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        param.put(MobileCapabilityType.DEVICE_NAME, "Galaxy S10");
        param.put(AndroidMobileCapabilityType.APP_PACKAGE, nbfpackage);
        param.put(AndroidMobileCapabilityType.APP_ACTIVITY, nbfActivity);
        param.put(MobileCapabilityType.LANGUAGE, "us");
        param.put(MobileCapabilityType.LOCALE, "en");
        param.put(MobileCapabilityType.NO_RESET, true);
        DesiredCapabilities capabilities = new DesiredCapabilities(param);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.openNotifications();


        Thread.sleep(2000);
        List<MobileElement> allnotifications = driver.findElements(By.id("android:id/title"));
        List<MobileElement> allnotificationstext = driver.findElements(By.id("android:id/text"));


        System.out.println("no of notifications " + allnotifications.size());
       // driver.pressKey(new KeyEvent(AndroidKey.BACK));
//        int i=0;
//        for(i=0;i<allnotifications.size();i++){
//            WebElement element=allnotifications.get(i).findElement(By.id("android:id/text"));
//            String txt=element.getText();
//            System.out.println(txt);
//        }

//      for (MobileElement webElement : allnotifications) {
//           System.out.println(webElement.getText());
//        }
        for (MobileElement webElement : allnotificationstext) {
            System.out.println(webElement.getText());
        }
        //HashMap<String, Object> map = new HashMap<>();
        param.put(MobileCapabilityType.LANGUAGE, "ar");
        param.put(MobileCapabilityType.LOCALE, "ae");
        capabilities = new DesiredCapabilities(param);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.launchApp();
        //map.put("bundleId", nbfpackage);
        //map.put("package",nbfpackage );
        //map.put("activity",nbfActivity );
        //driver.executeScript("mobile:activity:open", map);
        //driver.executeScript("mobile: launchApp", map);
        //driver.executeScript("mobile: activateApp", map);


//        List <WebElement> notificationTitles = driver.findElements(By.id("android:id/title"));
//        for (WebElement title: notificationTitles) {
//            String extractTitle = title.getText();
//            if (extractTitle.contains("Watch now: 'Upload - Season 1'")) {
//                driver.findElement(By.id("com.android.systemui: id/clear_notification")).click();
//            }
//        }
        // driver.pressKeyCode(AndroidKeyCode.BACK);

//        for (MobileElement webElement : allnotifications) {
//            System.out.println(webElement.getText());
//            if (webElement.getText().contains("Watch now: 'Upload - Season 1'")) {
//                System.out.println("Notification found");
//                break;
//            }
//
 //       }
            driver.quit();
        }
    }

