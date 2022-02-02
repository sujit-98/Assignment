package psqa.efinanceplus.shared.pages.IIFLInsurance;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementNotFound;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import psqa.efinanceplus.shared.helper.EFPWaitHelper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class IIFLInsurancePage {
    private static final By GET_PROTECTED = By.className("get-protected");
    private static final By RISING_HEALTH_COST = By.xpath("//div[@class='cardHeight']//p[contains(text(),'Rising Health Costs')and @id='1_heading']");
    private static final By NEXT_BUTTON = By.className("nextBtn");
    private static final By SELF_AGE = By.xpath("//div[@id='0_border']/span[2]/p");
    private static final By SELECT_AGE = By.xpath(" //div[@class='mat-menu-content']//input[@formcontrolname='input_age']");
    private static final By FLOATING_MESSAGE = By.cssSelector(".mat-simple-snackbar.ng-star-inserted > span");

    WebDriver driver;

    public IIFLInsurancePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickGetProtected() {
        WebDriverWait Wait = new WebDriverWait(driver,5);
        WebElement ele1= Wait.until(ExpectedConditions.visibilityOfElementLocated(GET_PROTECTED));
        ele1.click();
    }

    public void clickRisingHealthCost() {
        WebDriverWait Wait = new WebDriverWait(driver,5);
        WebElement ele2= Wait.until(ExpectedConditions.visibilityOfElementLocated(RISING_HEALTH_COST));
        ele2.click();
    }

    public void clickNextButton() {
        driver.findElement(NEXT_BUTTON).click();
    }

    public void selectSelfAge() {
        driver.findElement(SELF_AGE).click();
        WebDriverWait Wait = new WebDriverWait(driver,5);
        WebElement ele3= Wait.until(ExpectedConditions.visibilityOfElementLocated(SELECT_AGE));
        ele3.sendKeys("200");
    }

    public String getFlashMessage() {
        //driver.switchTo().frame(1);//_hjRemoteVarsFrame

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement element2 = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {
                WebElement element1= driver.findElement(FLOATING_MESSAGE);
                return element1;
            }
        });
        String message = element2.getText();
        return message;
    }



}
