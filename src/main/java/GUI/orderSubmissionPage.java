package GUI;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class orderSubmissionPage {





    private final SHAFT.GUI.WebDriver driver;

    //constructor
    public orderSubmissionPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }



    List<WebElement> productsName;
    String productItemName;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////// Cart Locators  ///////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static By checkoutTitle() {return By.xpath("//div[@class='header_secondary_container']//span[@class='title']");}
    public static By firstNameField() {return By.id("first-name");}
    public static By lastNameField() {return By.id("last-name");}

    public static By postalCodeField() {return By.id("postal-code");}
    public static By continueBtn() {return By.id("continue");}


    public orderSubmissionPage typeFirstName(String firstName){
        driver.element().type(firstNameField(),firstName);
        return this;
    }
    public orderSubmissionPage typeLastName(String lastName){
        driver.element().type(lastNameField(),lastName);
        return this;
    }
    public orderSubmissionPage typePostalCode(String postalCode){
        driver.element().type(postalCodeField(),postalCode);
        return this;
    }
    public orderSubmissionPage clickContinueBtn(){
        driver.element().click(continueBtn());
        return this;
    }


}
