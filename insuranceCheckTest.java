package psqa.efinanceplus.testsuite.ui.insurancecheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import psqa.efinanceplus.shared.pages.IIFLInsurance.IIFLInsurancePage;
import psqa.testfw.testng.SeleniumTestNGTest;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;



public class insuranceCheckTest extends SeleniumTestNGTest {

    private static final String EXPECTED_MESSAGE = "Maximum limit for adult's age is 99";
    private IIFLInsurancePage iiflInsurancePage;

    WebDriver driver;
    @BeforeClass
    public void setUp() {
         driver = new ChromeDriver();
        driver.get("https://iifl-diy.demo.riskcovry.com/user/home");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        iiflInsurancePage = new IIFLInsurancePage(driver);
    }
        @Test
        public void validateAge()
        {
            iiflInsurancePage.clickGetProtected();
            iiflInsurancePage.clickRisingHealthCost();
            iiflInsurancePage.clickNextButton();
            iiflInsurancePage.selectSelfAge();
            assertEquals(EXPECTED_MESSAGE, iiflInsurancePage.getFlashMessage());
        }

        @AfterClass
    public void browserClose()
        {
            driver.close();
        }

}


