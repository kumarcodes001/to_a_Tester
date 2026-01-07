import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class table_operations {
    WebDriver driver;

    @Before
    public void open_browser(){
        String driverPath = "F:\\Testing\\Junit\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");

        //implicity wait
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
    }

    @Test
    public void table_ops(){

        //Find the xpath of the coloumn value which have alphapet "e" and "i"
        List<WebElement> Ele = driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr/td[2][contains(text(),'e') and contains(text(),'i')]"));
        //print the elements
        for(WebElement word : Ele){
            System.out.println("Word ===>" + word.getText());
        }
    }
    @After
    public void close() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
    }
}
