package TestCases;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class Registration extends BaseTest {
    @Test
    public static void SignupForm  () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector(loc.getProperty("CreateNewAccount"))).click();
        driver.findElement(By.cssSelector(loc.getProperty("FirstName"))).sendKeys("Piyush");
      //  driver.findElement(By.id(loc.getProperty("SurName"))).sendKeys("Ahlawat");

        WebElement Date = (driver.findElement(By.id(loc.getProperty("Day"))));
        Select DropDownvalue = new Select(Date);
        DropDownvalue.selectByIndex(5);
        WebElement day = DropDownvalue.getFirstSelectedOption();
        System.out.println("This is the selected Day : "+day.getText());

        WebElement Month = (driver.findElement(By.id(loc.getProperty("Month"))));
        Select dropdown = new Select(Month);
        dropdown.selectByVisibleText("Jan");
        WebElement m = dropdown.getFirstSelectedOption();
        System.out.println(m.getText());

        WebElement year = driver.findElement(By.id(loc.getProperty("Year")));
        Select yearDropdown = new Select(year);
        yearDropdown.selectByIndex(30);
        WebElement y = yearDropdown.getFirstSelectedOption();
        System.out.println(y.getText());

        WebElement sexElement = driver.findElement(By.cssSelector(loc.getProperty("Sex")));
        sexElement.click();
        Assert.assertTrue(sexElement.isSelected());
        WebElement EmailOrPhoneNumber = driver.findElement(By.xpath(loc.getProperty("Email")));
        EmailOrPhoneNumber.sendKeys("Piyush123456789@yopmail.com");
        WebElement pwd = driver.findElement(By.id(loc.getProperty("PassWord")));
        pwd.sendKeys("12345678@abc");

        driver.findElement(By.cssSelector(loc.getProperty("SignUpButton"))).click();
        driver.findElement(By.cssSelector(loc.getProperty("AlreadyHaveAnAccount"))).click();
        Thread.sleep(3000);
    }
    @Test
    public static void login() throws InterruptedException {
        WebElement Email = driver.findElement(By.id(loc.getProperty("EmailAtLogin")));
        Email.sendKeys("anas_djujleu_mirza@tfbnw.net");
        WebElement Paswd = driver.findElement(By.id(loc.getProperty("PassWordAtlogin")));
        Paswd.sendKeys("pando@123");
        WebElement button = driver.findElement(By.id(loc.getProperty("LoginButtonAtLogin")));
        button.click();

    }
}