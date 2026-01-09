import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
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

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void forma_fillup() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-center")));
        System.out.println("Page opened ->>" + success);


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

        js.executeScript("window.scrollBy(0,100);");

        //DropDown
        /*WebElement subject_dd = driver.findElement(By.id("subjectsContainer"));
       // subject_dd.click();
       // Thread.sleep(1000);
        driver.findElement(By.xpath("")).sendKeys("Engl");
        subject_dd.sendKeys(Keys.ENTER);
*/

        //checkBox
     //  WebElement hobbies = driver.findElement(By.id("hobbies-checkbox-1"));
    //   hobbies.click();

        //Upload a file - simple
        WebElement up_element = driver.findElement(By.id("uploadPicture"));
        up_element.sendKeys("F:/Testing/File.txt");

        //Screeshot syntax
        TakesScreenshot ts = (TakesScreenshot)driver;
        File Src = ts.getScreenshotAs(OutputType.FILE);
        File des =new File("./ss.jpg");
        FileUtils.copyFile(Src,des);


        //dropdown funtionalities

        /*WebElement dd_state = driver.findElement(By.className("css-yk16xz-control"));
        Select dd_ele = new Select(dd_state);
        dd_ele.selectByIndex(1);

        WebElement dd_div = driver.findElement(By.className("css-1wa3eu0-placeholder"));
        Select dd_div_ele = new Select(dd_div);
        dd_div_ele.selectByIndex(2);*/

        Thread.sleep(1000);
        //driver.findElement(By.xpath("//button[@id='submit']")).click();








    }


    @After
    public void close_browser() throws InterruptedException {
        //Thread.sleep(1000);
        driver.quit();
    }
}