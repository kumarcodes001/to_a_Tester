import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class aForm {
    WebDriver driver;

    @Before
    public void open_site() {

        String driverPath = "F:\\Testing\\Junit\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
    }

    @Test
    public void forma_fillup() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");
        //locator - by.id
        driver.findElement(By.id("firstName")).sendKeys("Ilayathapathy");
        //locator - by.class
        driver.findElement(By.id("lastName")).sendKeys("Vijay");
        //locator - xpath [relative]
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("janayagan20@gmail.com");

        //RadioButton
        driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")).click();
        driver.findElement(By.id("userNumber")).sendKeys("9876543369");

        //DropDown - DATE_PICKER
        driver.findElement(By.id("dateOfBirthInput")).click();

        WebElement Year_All = driver.findElement(By.className("react-datepicker__year-select"));
        Select year_s = new Select(Year_All);
        year_s.selectByValue("1999");

        WebElement month_All = driver.findElement(By.className("react-datepicker__month-select"));
        Select month_s = new Select(month_All);
        month_s.selectByIndex(9);

        WebElement date = driver.findElement(By.xpath("//div[@class = 'react-datepicker__day react-datepicker__day--004']"));
        date.click();

        js.executeScript("window.scrollBy(0,300);");

        //DropDown
        WebElement subject_dd = driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]"));
        subject_dd.click();
        subject_dd.sendKeys("English");
        subject_dd.sendKeys(Keys.ENTER);













    }


    @After
    public void close_browser() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}