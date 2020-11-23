package Base;

import enums.BrowserToRun;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import webtesting.browser.BrowserConfiguration;
import webtesting.browser.CustomChromeDriver;
import webtesting.browser.CustomFirefoxDriver;
import webtesting.helper.*;
import webtesting.utils.IReader;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory implements Closeable {

    private  WebDriver driver;
    private BrowserConfiguration browserConfiguration;
    private CustomChromeDriver chromeDriver;
    private BrowserHelper browserHelper;
    private ButtonHelper buttonHelper;
    private WindowHelper windowHelper;
    private AlertHelper alertHelper;
    private TextBoxHelper textBoxHelper;
    private DropdownHelper dropDownHelper;
    private GenericHelper genericHelper;
    private IReader reader;

    public WebDriver getDriver() { return driver; }
    public BrowserConfiguration getBrowserConfiguration() {
        return browserConfiguration;
    }
    public CustomChromeDriver getChromeDriver() {
        return chromeDriver;
    }
    public BrowserHelper getBrowserHelper() {
        return browserHelper;
    }
    public ButtonHelper getButtonHelper() {
        return buttonHelper;
    }
    public WindowHelper getWindowHelper() {
        return windowHelper;
    }
    public AlertHelper getAlertHelper() {
        return alertHelper;
    }
    public GenericHelper getGenericHelper() {
        return genericHelper;
    }
    public DropdownHelper getDropDownHelper() {
        return dropDownHelper;
    }
    public TextBoxHelper getTextBoxHelper() {
        return textBoxHelper;
    }

    public void launchBrowser(){
        //chromeDriver = new CustomChromeDriver();
       // reader = new ReadConfigProperties();

        //driver = chromeDriver.getChromeDriver();
        driver = getBrowserDriver();
        WebDriverManager.setWebDriver(driver);
        browserHelper = BrowserHelper.getInstance(driver);
        buttonHelper = ButtonHelper.getInstance(driver);
        windowHelper = WindowHelper.getInstance(driver);
        alertHelper = AlertHelper.getInstance(driver);
        textBoxHelper = TextBoxHelper.getInstance(driver);
        dropDownHelper = DropdownHelper.getInstance(driver);
        genericHelper = GenericHelper.getInstance(driver);
        WebDriverManager.getInstance().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); //Page load time out
        browserHelper.maximize();
    }
    public static String getBrowserToRun(){
        String browser=System.getProperty("browser");
        return browser;
    }
    private WebDriver getBrowserDriver() {
        String browser=System.getProperty("browser");
        if(browser==null){
            browserConfiguration = new CustomChromeDriver();
            return browserConfiguration.getBrowserDriver();
        }
        BrowserToRun browserToRun=BrowserToRun.valueOf(getBrowserToRun());
		System.out.println(" ============== > " + getBrowserToRun());
        switch (browserToRun) {
            case CHROME:
			/*CustomChromeDriver chromeDriver = new CustomChromeDriver();
			return chromeDriver.getChromeDriver();*/
                browserConfiguration = new CustomChromeDriver();
                return browserConfiguration.getBrowserDriver();

            case FIREFOX:
			/*CustomFirefoxDriver firefoxDriver = new CustomFirefoxDriver();
			return firefoxDriver.getFirefoxDriver();*/
                browserConfiguration = new CustomFirefoxDriver();
                return browserConfiguration.getBrowserDriver();
            case SAFARI:
                System.out.println("SAFARI");
            case INTERNETEXPLORER:
                System.out.println("INTERNETEXPLORER");
            case PHANTOMJS:
                System.out.println("PHANTOMJS");
            default:
                throw new RuntimeException("Invalid Browser Type : " + getBrowserToRun());
        }
    }
    public WebDriverFactory(){
        launchBrowser();
    }

    public void quit(){
        WebDriverManager.getInstance().quit();

    }

    @Override
    public void close() throws IOException {

    }
}
