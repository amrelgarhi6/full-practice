package stepDefinition.GUI;

import GUI.EntryPointPage;
import GUI.homePage;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static GUI.EntryPointPage.errorMessage;
import static GUI.EntryPointPage.loginTitlePage;
import static GUI.homePage.appHeader;
import static GUI.homePage.productsTitle;
import static GUI.shoppingCartPage.shoppingCartTitle;

public class loginSteps {

    static SHAFT.GUI.WebDriver driver = new SHAFT.GUI.WebDriver();;


    private static final JSONFileManager loginPageData = new JSONFileManager("src/test/resources/testDataFiles/loginTestData.json");
    private static final JSONFileManager productsPageData = new JSONFileManager("src/test/resources/testDataFiles/homePage.json");

    private static final JSONFileManager shoppingCartPageData = new JSONFileManager("src/test/resources/testDataFiles/shoppingCartTestData.json");
    String shoppingCartPageTitle = shoppingCartPageData.getTestData("shoppingCartPageTitle");


    String productsPageTitle = productsPageData.getTestData("productsPageTitle");
    String userName = loginPageData.getTestData("validCred.username");
    String password = loginPageData.getTestData("validCred.password");

    String inValidUserName = loginPageData.getTestData("InValidCred.username");
    String inValidPassword = loginPageData.getTestData("InValidCred.password");
    String  errorMessage = loginPageData.getTestData("errorMessage");


    @After()
    public static void after_all(){
        driver.quit();
    }


    @Given("open swag app and landed on login page")
    public void open_swag_app_and_landed_on_login_page() {
        new EntryPointPage(driver).openPortal();
    }

    @And("enter my user name")
    public void enter_my_user_name() {
        new EntryPointPage(driver).typeUserName(userName);
    }

    @And("enter my password")
    public void enter_my_password() {
        new EntryPointPage(driver).typePassword(password);
    }
    @And("click on login button")
    public void click_on_login_button() {
        new EntryPointPage(driver).clickLogin();
        Validations.assertThat().element(appHeader()).exists().perform();
        Validations.assertThat().element(productsTitle()).text().isEqualTo(productsPageTitle).perform();
    }

    @When("add most expensive two products to cart")
    public void validate_land_on_the_home_page_successfully() {
        new homePage(driver)
                .addProductToCart()
                .getSelectedItemsNameFromHomePage()
                .navigateToCartPage(2);
        Validations.assertThat().element(shoppingCartTitle()).text().isEqualTo(shoppingCartPageTitle).perform();
    }

    @And("enter invalid user name")
    public void enter_invalid_user_name() {
        Validations.assertThat().element(loginTitlePage()).exists().perform();
        new EntryPointPage(driver).typeUserName(inValidUserName);
    }

    @And("enter invalid password")
    public void enter_invalid_password() {
        new EntryPointPage(driver).typePassword(inValidPassword);
    }
    @Then("validate error message displayed successfully")
    public void validate_error_message_displayed_successfully() {
        Validations.assertThat().element(errorMessage()).text().isEqualTo(errorMessage).perform();
    }
}


