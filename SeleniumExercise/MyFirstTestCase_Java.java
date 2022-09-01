package SeleniumExercise;

import SeleniumExercise.PageObjectModel_Exercise.Base.BaseTest;
import SeleniumExercise.PageObjectModel_Exercise.Pages.FormPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestCase_Java extends BaseTest {

    @Test
    public void dummyTest(){
        //Arrange
        driver.get("https://formy-project.herokuapp.com/form");
        FormPage formPage = new FormPage(driver);
        //Act
        formPage.fillInForm();
        var result = driver.findElement(By.cssSelector("div.alert.alert-success")).getText();
        //Assert
        Assert.assertEquals(formPage.text, result);
        System.out.println(formPage.text);
        System.out.println(result);
    }
}
