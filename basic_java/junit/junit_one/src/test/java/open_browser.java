import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class open_browser {

    WebDriver driver;


    @Before
    public void open_browser(){
        String driverPath = "F:\\Testing\\Junit\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
    }


    @Test
    public void getTitle(){
       String title=  driver.getTitle();
       System.out.println("Title : " + title);

       // File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(src, new File("screenshot.png"));

    }

    @After
    public void close_Browser() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

}
