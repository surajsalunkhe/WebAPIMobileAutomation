package steps.Web;

import utility.TestEnvironmentUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testWebdriver {
    private WebDriver driver;
    private String WebdriverPath=System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver";
    TestEnvironmentUtility testEnvironmentUtility;
    @BeforeClass
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", WebdriverPath);
       // driver = new ChromeDriver();
        testEnvironmentUtility=new TestEnvironmentUtility();
    }

    @Test
    public void Seleniumtest1() {
        System.out.println("In test 1");
        testEnvironmentUtility.getComputerName();
        testEnvironmentUtility.getUserName();
        testEnvironmentUtility.getOSPlatform();

//        driver.get("http://google.com");
//        String expectedPageTitle = "Google";
//        Assert.assertTrue(driver.getTitle().contains(expectedPageTitle), "Test Failed");
    }
    @AfterClass
    public void tearDown() {
        if(driver!=null){
            driver.quit();
        }

    }
}
