package TestCases;
import Base.BaseTest;
import Utilities.ReadCSV;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class Registration extends BaseTest {
    @Test
    public static void WebLaunch () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(loc.getProperty("CreateNewAccount"))).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector(loc.getProperty("FirstName"))).sendKeys("Piyush");
    }
}