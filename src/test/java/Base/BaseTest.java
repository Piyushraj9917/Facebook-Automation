package Base;
import Utilities.ReadCSV;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.w3c.dom.Text;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static Properties prop = new Properties();
    public static  Properties loc = new Properties();

    public static FileReader fr;
    public static FileReader fr1;

    @BeforeSuite
    public void setup() throws IOException {
        if (driver==null)
        {
            FileReader fr = new FileReader("/Users/ahlawat/IdeaProjects/FaceBookAutomation/src/test/resources/ConfigFiles/config.properties");
            FileReader fr1 = new FileReader("/Users/ahlawat/IdeaProjects/FaceBookAutomation/src/test/resources/ConfigFiles/Locators.properties")
                    ;
            prop.load(fr);
            loc.load(fr1);
        }
        if (prop.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("testurl"));
            driver.manage().window().maximize();
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("testurl"));
            driver.manage().window().maximize();
        }
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        ReadCSV rc = new ReadCSV();
        rc.ReadData(0);


    }
    //@AfterSuite
    public void TearDown()
    {
        driver.quit();
    }
}
