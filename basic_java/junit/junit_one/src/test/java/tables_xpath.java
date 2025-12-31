import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tables_xpath {

        WebDriver driver;

        @Before
        public void open_browser(){
            String driverPath = "F:\\Testing\\Junit\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            driver.get("https://www.w3schools.com/html/html_tables.asp");
        }

        @Test
        public void xpath(){
            String text = driver.findElement(By.xpath("//table[@class='ws-table-all']//td[2][contains(.,'e')and contains(.,'i')]")).getText();
        System.out.println(text);
        }

        @After
        public void close() throws InterruptedException {
            Thread.sleep(10000);
            driver.quit();
        }
    }

