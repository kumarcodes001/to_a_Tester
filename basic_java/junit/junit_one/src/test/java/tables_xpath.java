import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

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

           //Print the words that contains 'e' and 'i' in a particular coloumn xpath finding
            String containEandI = "//table[@class='ws-table-all']//td[2][contains(.,'e') and contains(.,'i')]";
            System.out.println("XPath used to find e and i contain words in column 2: " + containEandI);


            List<WebElement> texts = driver.findElements(By.xpath(containEandI));
            for(WebElement ele : texts){
                System.out.println(ele.getText());
            }
        }

        @After
        public void close() throws InterruptedException {
            Thread.sleep(10000);
            driver.quit();
        }
    }

