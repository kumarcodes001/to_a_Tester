import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTest {

    //TestNg Basics

    // | Before Suite | BeforeTest | BeforeClass | BeforeMethod |
    // | Test |
    // | AfterMethod | AfterClass | AfterTest | AfterSuite |


    // priority = 1                     -> Give Priority to the annotation
    // dependsOnMethods= aru            -> Run if the given method is true
    // invocationCount = 2              -> Single annotation run many times as given
    // enable = true/false              -> Default value is true if given false that particular
    //                                     annotation not work.
    // group = smoke                    -> Set in a group name an if required that only
    //                                     can run using xml file.
    //







    //Basic run
    public class BasicTest {
        // Runs once before any test in this class
        @BeforeClass
        public void setup() {
            System.out.println("Initializing resources (e.g., Database connection)");
        }
        // Runs before every @Test method
        @BeforeMethod
        public void launchBrowser() {
            System.out.println("Launching browser...");
        }
        @Test
        public void verifyTitle() {
            String expectedTitle = "Google";
            String actualTitle = "Google";
            System.out.println("Executing Test: Verify Title");
            Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
        }
        @Test
        public void verifyLogin() {
            System.out.println("Executing Test: Verify Login");
            boolean isLoggedIn = true;
            Assert.assertTrue(isLoggedIn);
        }
        // Runs after every @Test method
        @AfterMethod
        public void closeBrowser() {
            System.out.println("Closing browser...");
        }
        // Runs once after all tests in this class are done
        @AfterClass
        public void cleanup() {
            System.out.println("Cleaning up resources.");
        }
    }}