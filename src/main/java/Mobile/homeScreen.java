package Mobile;

import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homeScreen {

    WebDriver driver;




    public homeScreen( WebDriver driver){this.driver = driver;}


    public static By loginPageIcon() {return  By.xpath("//android.widget.ScrollView[@content-desc=\"test-Login\"]//android.widget.ImageView[1]");}
    public static By userNameField() {return By.id("test-Username");}
    public static By passwordField() {return By.id("test-Password");}
    public static By loginBtn()      {return AppiumBy.accessibilityId("test-LOGIN");}





    public homeScreen typeUserName(String userName){
        new TouchActions(driver).element().type(userNameField(),userName);
        return this;
    }
    public homeScreen typePassword(String password){
        new TouchActions(driver).element().type(passwordField(),password);
        return this;
    }
    public homeScreen clickLoginCTA(){
        new TouchActions(driver).element().click(loginBtn());
        return this;
    }

}
