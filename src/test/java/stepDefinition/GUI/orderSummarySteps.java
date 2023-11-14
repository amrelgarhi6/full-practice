package stepDefinition.GUI;

import GUI.orderSummaryPage;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static GUI.orderSummaryPage.*;

public class orderSummarySteps {

    public static SHAFT.GUI.WebDriver driver = new SHAFT.GUI.WebDriver();
    private final JSONFileManager orderSummaryPageData = new JSONFileManager("src/test/resources/testDataFiles/orderSummaryTestData.json");

    String orderSummaryPageTitle = orderSummaryPageData.getTestData("orderSummaryPageTitle");
    String overviewURL = orderSummaryPageData.getTestData("overviewURL");

    String successMessage = orderSummaryPageData.getTestData("successMessage");
    String successMessageDescription = orderSummaryPageData.getTestData("successMessageDescription");
    String completePageTitle = orderSummaryPageData.getTestData("completePageTitle");


    @Then("validate redirection to summary order page title and its page title")
    public void validate_redirection_to_summary_order_page_title_and_its_page_title() {
        Validations.assertThat().element(summaryPageTitle()).text().isEqualTo(orderSummaryPageTitle).perform();
    }


    @Then("validate on current URL to be overview page")
    public void validate_on_current_url_to_be_overview_page() {
        String overViewUrl = new orderSummaryPage(driver).getCurrentURL();
        Validations.assertThat().object(overViewUrl).isEqualTo(overviewURL).perform();
    }
    @Then("validate on calculation of subtotal")
    public void validate_on_calculation_of_subtotal() {
        new orderSummaryPage(driver).validateAndCalculateSummarySubTotal();
    }

    @When("click on submit order")
    public void click_on_submit_order() {
        new orderSummaryPage(driver).clickSubmitOrder();
    }
    @Then("validate on success message for complete the order")
    public void validate_on_success_message_for_complete_the_order() {
        Validations.assertThat().element(successMessage()).text().isEqualTo(successMessage).perform();
        Validations.assertThat().element(successMessageDescription()).text().isEqualTo(successMessageDescription).perform();
        Validations.assertThat().element(summaryPageTitle()).text().isEqualTo(completePageTitle).perform();

    }
    }
