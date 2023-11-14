package stepDefinition.Mobile;

import GUI.EntryPointPage;
import Mobile.homeScreen;
import com.shaft.driver.DriverFactory;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static GUI.EntryPointPage.errorMessage;
import static GUI.EntryPointPage.loginTitlePage;
import static GUI.homePage.appHeader;
import static GUI.homePage.productsTitle;

public class loginSteps {

    public static SHAFT.GUI.WebDriver driver;


    private static final JSONFileManager loginPageData = new JSONFileManager("src/test/resources/testDataFiles/loginTestData.json");
    private static final JSONFileManager productsPageData = new JSONFileManager("src/test/resources/testDataFiles/homePage.json");

    protected static String productsPageTitle;
    static String userName;
    static String password;

    static String inValidUserName;
    static String inValidPassword;
    static String errorMessage;







    @BeforeAll
    public static void before_all()
    {
        driver = new SHAFT.GUI.WebDriver();

        productsPageTitle = productsPageData.getTestData("productsPageTitle");
        userName = loginPageData.getTestData("validCred.username");
        password = loginPageData.getTestData("validCred.password");

        inValidUserName = loginPageData.getTestData("InValidCred.username");
        inValidPassword = loginPageData.getTestData("InValidCred.password");
        errorMessage = loginPageData.getTestData("errorMessage");
    }

    @AfterAll()
    public static void after_all(){
        driver.quit();
    }


    @Given("open swag app and landed on login page")
    public void open_swag_app_and_landed_on_login_page() throws MalformedURLException {
        driver = new SHAFT.GUI.WebDriver();

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformVersion", "10.0");
        dc.setCapability("deviceName", "Pixel4");
        dc.setCapability("appPackage", "com.swaglabsmobileapp");
        dc.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
        driver = new SHAFT.GUI.WebDriver(DriverFactory.DriverType.APPIUM_MOBILE_NATIVE);
//


    }

    @And("enter my user name for mobile")
    public void enter_my_user_name_for_mobile() {
        new homeScreen((WebDriver) driver).typeUserName(userName);
    }

    @And("enter my password for mobile")
    public void enter_my_password_for_mobile() {
        new homeScreen((WebDriver) driver).typePassword(password);
    }
    @And("click on login button for mobile")
    public void click_on_login_button_for_mobile() {
        new homeScreen((WebDriver) driver).clickLoginCTA();
    }
    @Then("validate land on the home page successfully for mobile")
    public void validate_land_on_the_home_page_successfully_for_mobile() {
        Validations.assertThat().element(appHeader()).exists().perform();
        Validations.assertThat().element(productsTitle()).text().isEqualTo(productsPageTitle).perform();
    }

    @And("enter invalid user name for mobile")
    public void enter_invalid_user_name_for_mobile() {
        Validations.assertThat().element(loginTitlePage()).exists().perform();
        new homeScreen((WebDriver) driver).typeUserName(inValidUserName);
    }

    @And("enter invalid password for mobile")
    public void enter_invalid_password() {
        new EntryPointPage(driver).typePassword(inValidPassword);
    }
    @And("click on login button")
    @Then("validate error message displayed successfully for mobile")
    public void validate_error_message_displayed_successfully_for_mobile() {
        Validations.assertThat().element(errorMessage()).text().isEqualTo(errorMessage).perform();
    }
}


