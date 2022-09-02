
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
}
