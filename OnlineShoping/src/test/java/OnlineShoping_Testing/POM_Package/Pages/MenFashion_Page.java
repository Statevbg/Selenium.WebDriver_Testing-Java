package OnlineShoping_Testing.POM_Package.Pages;

import OnlineShoping_Testing.POM_Package.Base.BasePage;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class MenFashion_Page extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
    //private WebDriver ;

    public MenFashion_Page(WebDriver driver) {
        super(driver);
    }
    public List<WebElement> elementsTitle = driver.findElements(By.cssSelector("h2.woocommerce-loop-product__title"));
    public List<WebElement> addToCart = driver.findElements(By.cssSelector(".button.product_type_simple.add_to_cart_button.ajax_add_to_cart"));
    public List<WebElement> itemPrice = driver.findElements(By.cssSelector("span.price:nth-of-type(2)"));
    public By productsInCart = By.cssSelector("span.count");
    public By sortingOptions = By.cssSelector("select.orderby");
    public WebElement cartButton = driver.findElement(By.xpath("//body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]"));

    public int numberJeans = 0;
    public void sortByPrice() {

        Select select = new Select(driver.findElement(sortingOptions)); // choose from dropdown menu
        select.selectByValue("price");
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("span.price:nth-of-type(2)"))));
    }

    public void addToCart_Jeans() {

        for (int i = 0; i < (elementsTitle.size()); i++) {
            if (elementsTitle.get(i).getText().contains("Jeans")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button.product_type_simple.add_to_cart_button.ajax_add_to_cart")));
                addToCart.get(i).click();
                numberJeans++;
             }
            wait.until(ExpectedConditions.textToBe(productsInCart,Integer.toString(numberJeans)));
         }
    }

}



