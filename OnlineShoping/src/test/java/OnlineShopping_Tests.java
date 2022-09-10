
import OnlineShoping_Testing.POM_Package.Base.BaseTest;
import OnlineShoping_Testing.POM_Package.Pages.CreateAccount_Page;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlineShopping_Tests extends BaseTest {
    @Test
    public void Test_NewRegistration(){
        // Arrange
        driver.get("https://askomdch.com/account/");
        CreateAccount_Page account_page = new CreateAccount_Page(driver);
        // Act
        account_page.newRegistration();
        var result = driver.findElement(By.cssSelector("h1.has-text-align-center")).getText();
        // Assert
        Assert.assertEquals(result, "Account");
        System.out.println(result);
    }
    @Test
    public void Test_MenFashion_SortByPrice() {
        // Arrange
        driver.get("https://askomdch.com/product-category/men/");
        MenFashion_Page menFashion_page = new MenFashion_Page(driver);
        // Act
        menFashion_page.sortByPrice();
        var firsItem = driver.findElements(By.cssSelector("span.price:nth-of-type(2)")).get(0).getText();
        var lastItem = driver.findElements(By.cssSelector("span.price:nth-of-type(2)")).get(menFashion_page.itemPrice.size()-1).getText();
        // Assert
        Assert.assertEquals(firsItem,"$20.00");
        Assert.assertEquals(lastItem,"$145.00");
    }
     @Test
    public void Test_AddToCart_OnlyJeans() {
        // Arrange
        driver.get("https://askomdch.com/product-category/men/");
        MenFashion_Page menFashion_page = new MenFashion_Page(driver);
        // Act
        menFashion_page.addToCart_Jeans();
        var result = driver.findElement(By.cssSelector("span.count")).getText();
        // Assert
        Assert.assertEquals(result,Integer.toString(menFashion_page.numberJeans));
    }
    @Test
    public void Test_AddToCart_AndProceedToCheckout() {
        // Arrange
        driver.get("https://askomdch.com/product-category/men/");
        MenFashion_Page menFashion_page = new MenFashion_Page(driver);
        // Act
        menFashion_page.addToCart_Jeans();
        driver.findElement(By.xpath("//*[@id=\"post-1220\"]/div/div/div/div/div[2]/div/div/a")).click();
        Cart_Page cart_page = new Cart_Page(driver);
        cart_page.proceedToCheckOut();
        var result = driver.findElement(By.xpath("//*[@id=\"post-1221\"]/div/div/div/div/div/p[1]")).getText();
        // Assert
        Assert.assertEquals(result,"Thank you. Your order has been received.");
        Assert.assertTrue(driver.getCurrentUrl().contains("order-received"));
    }
}
