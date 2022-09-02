package OnlineShoping_Testing.POM_Package.Pages;

import OnlineShoping_Testing.POM_Package.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccount_Page extends BasePage {

    public CreateAccount_Page(WebDriver driver) {
        super(driver);
    }
    public WebElement userName = driver.findElement(By.id("reg_username"));
    public WebElement email = driver.findElement(By.id("reg_email"));
    public WebElement password = driver.findElement(By.id("reg_password"));
    public WebElement registerButton = driver.findElement(By.name("register"));

    public void newRegistration(){
        userName.sendKeys("someRandomName");
        email.sendKeys("someRandomEmail@abv.bg");
        password.sendKeys("someRandomNumbers");
        registerButton.click();
    }

}

