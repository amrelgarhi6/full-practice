package stepDefinition.GUI;

import GUI.orderSubmissionPage;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static GUI.orderSubmissionPage.checkoutTitle;

public class orderSubmissionSteps {

    public static SHAFT.GUI.WebDriver driver = new SHAFT.GUI.WebDriver();
    private static final JSONFileManager orderSubmissionPageData = new JSONFileManager("src/test/resources/testDataFiles/orderSubmissionTestData.json");
    String orderSubmissionPageTitle = orderSubmissionPageData.getTestData("orderSubmissionPageTitle");
    String firstName = orderSubmissionPageData.getTestData("firstName");
    String lastName = orderSubmissionPageData.getTestData("lastName");
    String postalCode = orderSubmissionPageData.getTestData("code");



    @Then("validate the redirection and order submission page title")
    public void validate_the_redirection_and_order_submission_page_title() {
        Validations.assertThat().element(checkoutTitle()).text().isEqualTo(orderSubmissionPageTitle).perform();
    }
    @And("enter first name")
    public void enter_first_name() {
        new orderSubmissionPage(driver).typeFirstName(firstName);
    }
    @And("enter last name")
    public void nter_last_name() {
        new orderSubmissionPage(driver).typeLastName(lastName);
    }
    @And("enter postal code")
    public void enter_postal_code() {
        new orderSubmissionPage(driver).typePostalCode(postalCode);
    }
    @And("click on continue button")
    public void click_on_continue_button() {
        new orderSubmissionPage(driver).clickContinueBtn();
    }
}
