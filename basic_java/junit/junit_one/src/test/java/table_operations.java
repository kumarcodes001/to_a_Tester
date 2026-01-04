import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class table_operations {
    WebDriver driver;

    @Before
    public void open_browser(){
        String driverPath = "F:\\Testing\\Junit\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
    }

    @Test
    public void table_ops(){
        
    }
}
