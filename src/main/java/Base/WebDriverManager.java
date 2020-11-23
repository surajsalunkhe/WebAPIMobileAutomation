package Base;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

    public static WebDriver getInstance() {

        return dr.get();

    }

    public static void setWebDriver(WebDriver driver) {

        dr.set(driver);
    }
}
