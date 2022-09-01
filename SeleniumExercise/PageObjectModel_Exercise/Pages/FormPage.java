package SeleniumExercise.PageObjectModel_Exercise.Pages;

import SeleniumExercise.PageObjectModel_Exercise.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.List;

public class FormPage extends BasePage {

    private WebElement firstName = driver.findElement(By.id("first-name"));
    private WebElement lastName = driver.findElement(By.id("last-name"));
    private WebElement jobTitle = driver.findElement(By.id("job-title"));
    private WebElement date = driver.findElement(By.id("datepicker"));
    private List<WebElement> radioButtonsEducation = driver.findElements(By.cssSelector("input[type=radio]"));
    private List<WebElement> checkBoxButtonSex = driver.findElements(By.cssSelector("input[type=checkbox]"));
    private By yearsOfExperience = By.cssSelector("select.form-control");
    private WebElement submitButton = driver.findElement(By.cssSelector("a.btn.btn-lg.btn-primary"));

    public String text = "The form was successfully submitted!";
    public FormPage (WebDriver driver) {
        super(driver);
    }
    public void fillInForm(){
        firstName.sendKeys("Dimitar");
        lastName.sendKeys("Statev");
        jobTitle.sendKeys("Electrical Mechanic");
        radioButtonsEducation.get(2).click();
        checkBoxButtonSex.get(1).click();
        Select select = new Select(driver.findElement(yearsOfExperience)); // choose from dropdown menu
        select.selectByValue("1");
        date.sendKeys(LocalDate.now().toString());
        submitButton.click();
//
    }
}
