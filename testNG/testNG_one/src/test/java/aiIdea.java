import org.testng.Assert;
import org.testng.annotations.*;

public class aiIdea {

    // SCENARIO 1: Parameterization via XML (Environment Setup)
    @Parameters({"browser", "env"})
    @BeforeClass
    public void setup(String browser, String env) {
        System.out.println("Configuring Environment: " + env + " | Browser: " + browser);
    }

    // SCENARIO 2: Data Driven Testing (Multiple sets of data)
    @DataProvider(name = "loginData")
    public Object[][] authProvider() {
        return new Object[][] {
                {"validUser", "pass123"},
                {"invalidUser", "wrongPass"}
        };
    }

    @Test(priority = 1, dataProvider = "loginData", groups = {"smoke"})
    public void loginTest(String user, String pwd) {
        System.out.println("Running Login for: " + user);
        Assert.assertNotNull(user);
    }

    // SCENARIO 3: Dependency (Only runs if loginTest passes)
    // SCENARIO 4: Soft Assertion (Continues even if one check fails)
    @Test(priority = 2, dependsOnMethods = {"loginTest"}, groups = {"regression"})
    public void dashboardValidation() {
        org.testng.asserts.SoftAssert soft = new org.testng.asserts.SoftAssert();
        System.out.println("Validating Dashboard Widgets...");

        soft.assertEquals(10, 10, "Widget count mismatch!");
        soft.assertTrue(false, "Logo not displayed!"); // This won't stop the test

        System.out.println("Continuing execution after soft failure...");
        soft.assertAll(); // This marks the test as failed at the very end
    }

    // SCENARIO 5: Expected Exceptions (Handling intentional errors)
    @Test(priority = 3, expectedExceptions = ArithmeticException.class)
    public void testErrorReporting() {
        System.out.println("Verifying error handling...");
        int i = 1 / 0;
    }

    // SCENARIO 6: Timeout (Fails if execution exceeds time)
    // SCENARIO 7: Invocation Count (Stress testing a single method)
    @Test(priority = 4, timeOut = 2000, invocationCount = 2)
    public void performanceTest() throws InterruptedException {
        System.out.println("Running Performance Check...");
        Thread.sleep(1000);
    }

    // SCENARIO 8: Regular Expression Grouping
    @Test(groups = {"regression.payments"})
    public void creditCardPayment() {
        System.out.println("Processing Payment...");
    }

    // SCENARIO 9: Skipping a test
    @Test(enabled = false)
    public void retiredTest() {
        System.out.println("This test is disabled and won't show in reports.");
    }
}