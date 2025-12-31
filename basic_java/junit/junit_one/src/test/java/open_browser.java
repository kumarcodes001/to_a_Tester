import org.junit.Before;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class open_browser {

    WebDriver driver;


    @Test
    public void open_browser(){
        String driverPath = "F:\\Testing\\Junit\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");



    }
}
