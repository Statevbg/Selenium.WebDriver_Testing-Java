package OnlineShoping_Testing.POM_Package.Pages;
import OnlineShoping_Testing.POM_Package.Base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.lang.Thread;
import java.time.Duration;


public class Cart_Page extends BasePage {


    public Cart_Page(WebDriver driver) {
        super(driver);
    }

    public WebElement firstName = driver.findElement(By.id("billing_first_name"));
    public WebElement lastName = driver.findElement(By.cssSelector("input#billing_last_name"));
    public By country = By.cssSelector("select#billing_country");
    public WebElement streetAddress = driver.findElement(By.cssSelector("input#billing_address_1"));
    public WebElement city = driver.findElement(By.cssSelector("input#billing_city"));
    public WebElement state = driver.findElement(By.cssSelector("select#billing_state"));
    public WebElement zipCode = driver.findElement(By.cssSelector("input#billing_postcode"));
    public WebElement email = driver.findElement(By.cssSelector("input#billing_email"));
    public By placeOrderButton = By.xpath("//*[@id=\"place_order\" and @class=\"button alt\"]");
    public By cashOnDelivery = By.xpath("//*[@id=\"payment_method_cod\" and @name=\"payment_method\"]");

    private WebElement WaitAndFindElement(By by)
    {
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void proceedToCheckOut() {
        firstName.sendKeys("Dimitar");
        lastName.sendKeys("Statev");
        Select select = new Select(driver.findElement(country)); // choose from dropdown menu
        select.selectByValue("BG");
        streetAddress.sendKeys("Izgrev, 1, 2, 3");
        city.sendKeys("Burgas");
        Select select2 = new Select(state); // choose from dropdown menu
        select2.selectByValue("BG-02");
        zipCode.sendKeys("8000");
        email.sendKeys("someRandomEmail@abv.bg");
        try {                           // hard coded wait for now explicit wait can't help me!
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(cashOnDelivery).click();
        driver.findElement(placeOrderButton).click();
    }
}

