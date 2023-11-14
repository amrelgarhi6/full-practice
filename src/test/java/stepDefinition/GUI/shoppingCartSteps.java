package stepDefinition.GUI;

import GUI.shoppingCartPage;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.cucumber.java.en.Then;

import static GUI.shoppingCartPage.shoppingCartTitle;

public class shoppingCartSteps {

    public static SHAFT.GUI.WebDriver driver = new SHAFT.GUI.WebDriver();
    private static final JSONFileManager shoppingCartPageData = new JSONFileManager("src/test/resources/testDataFiles/shoppingCartTestData.json");

    String shoppingCartPageTitle = shoppingCartPageData.getTestData("shoppingCartPageTitle");

    @Then("validate shopping cart open successfully")
    public void validate_shopping_cart_open_successfully() {
        Validations.assertThat().element(shoppingCartTitle()).text().isEqualTo(shoppingCartPageTitle).perform();
    }

    @Then("validate on cart quantity for each item")
    public void validate_on_cart_quantity_for_each_item() {
        int actualQuantity = new shoppingCartPage(driver).getCartQuantityOfEachItem();
        Validations.assertThat().object(actualQuantity).isEqualTo(1).perform();
    }
    @Then("click on checkout button to navigate to order submission page")
    public void click_on_checkout_button_to_navigate_to_order_submission_page() {
        new shoppingCartPage(driver).clickOnCheckoutBtn();
    }
}