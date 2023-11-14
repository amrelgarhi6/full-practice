package stepDefinition.GUI;

import GUI.homePage;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static GUI.shoppingCartPage.shoppingCartTitle;

public class homePageSteps {

    public static SHAFT.GUI.WebDriver driver = new SHAFT.GUI.WebDriver();
    private static final JSONFileManager shoppingCartPageData = new JSONFileManager("src/test/resources/testDataFiles/shoppingCartTestData.json");
    String shoppingCartPageTitle = shoppingCartPageData.getTestData("shoppingCartPageTitle");

//    @When("add most expensive two products to cart")
//    public void add_most_expensive_two_products_to_cart()
//    {
//        new homePage(driver)
//                .addProductToCart()
//                .getSelectedItemsNameFromHomePage()
//                .navigateToCartPage(2);
//    }


    }


