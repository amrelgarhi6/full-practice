package GUI;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class EntryPointPage {
    SHAFT.GUI.WebDriver driver;
    //constructor
    public EntryPointPage(SHAFT.GUI.WebDriver driver){this.driver = driver;}
    //main url
    private final String mainUrl = System.getProperty("baseURL");



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////// Locators Open Portal  ////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static By loginTitlePage() {return By.className("login_logo");}
    public static By userNameField() {return By.id("user-name");}
    public static By passwordField() {return By.id("password");}
    public static By loginCTA() {return By.id("login-button");}
    public static By errorMessage() {return By.cssSelector("[data-test='error']");}





    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////// Open Portal Action //////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public EntryPointPage openPortal(){
        driver.browser().navigateToURL(mainUrl);
        return this;
    }

    public EntryPointPage typeUserName(String userName){
        driver.element().type(userNameField(),userName);
        return this;
    }
    public EntryPointPage typePassword(String password){
        driver.element().type(passwordField(),password);
        return this;
    }
    public EntryPointPage clickLogin(){
        driver.element().click(loginCTA());
        return this;
    }

}
