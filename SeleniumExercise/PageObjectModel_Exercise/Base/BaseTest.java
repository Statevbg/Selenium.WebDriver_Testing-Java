package SeleniumExercise.PageObjectModel_Exercise.Base;

import SeleniumExercise.PageObjectModel_Exercise.Factory.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void startDriver(){
        driver = new WebDriverManager().initializeDriver();
    }
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}
