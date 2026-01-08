import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class alerts {

    WebDriver driver;

    @Before
    public void open_browser(){
        String driverPath = "F:\\Testing\\Junit\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");

        //implicity wait
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        //maximaize screen
        driver.manage().window().maximize();
    }

    @Test
    public void alerts(){


        //Scroll 500 down using java executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");

        //ALERT - CLICK SENDkEYS AND ACCEPT.
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        System.out.println("On button click, prompt box will appear ===>> clicked " +
                "//button[@id='promtButton']");
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Thalapathy !");
        alert.accept();
        String Typed = driver.findElement(By.xpath("//span[@id='promptResult']")).getText();
        System.out.println("ALERT WORKED? == ? -> " + Typed);
    }


    @After
    public void close(){
        driver.close();
    }
}
