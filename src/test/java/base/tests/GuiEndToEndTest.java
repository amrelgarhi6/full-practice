package base.tests;

import GUI.*;
import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GUI.EntryPointPage.loginTitlePage;
import static GUI.homePage.productsTitle;
import static GUI.orderSubmissionPage.checkoutTitle;
import static GUI.orderSummaryPage.*;
import static GUI.shoppingCartPage.shoppingCartTitle;

public class GuiEndToEndTest extends BaseTest {



    private final JSONFileManager loginPageData = new JSONFileManager("src/test/resources/testDataFiles/loginTestData.json");
    private final JSONFileManager productsPageData = new JSONFileManager("src/test/resources/testDataFiles/homePage.json");
    private final JSONFileManager shoppingCartPageData = new JSONFileManager("src/test/resources/testDataFiles/shoppingCartTestData.json");
    private final JSONFileManager orderSubmissionPageData = new JSONFileManager("src/test/resources/testDataFiles/orderSubmissionTestData.json");
    private static final JSONFileManager orderSummaryPageData = new JSONFileManager("src/test/resources/testDataFiles/orderSummaryTestData.json");

    String productsPageTitle;
    String userName;
    String password;

    String inValidUserName;
    String inValidPassword;
    String errorMessage;


    private String shoppingCartPageTitle;
    private String orderSubmissionPageTitle;
    private String orderSummaryPageTitle;
    private String firstName;
    private String lastName;

    private String postalCode;
    private String overviewURL;
    private String successMessage;

    private String successMessageDescription;
    private String completePageTitle;



    @BeforeClass
    public void setup(){
        productsPageTitle = productsPageData.getTestData("productsPageTitle");
        userName = loginPageData.getTestData("validCred.username");
        password = loginPageData.getTestData("validCred.password");

        inValidUserName = loginPageData.getTestData("InValidCred.username");
        inValidPassword = loginPageData.getTestData("InValidCred.password");
        errorMessage = loginPageData.getTestData("errorMessage");
        shoppingCartPageTitle = shoppingCartPageData.getTestData("shoppingCartPageTitle");
        orderSubmissionPageTitle = orderSubmissionPageData.getTestData("orderSubmissionPageTitle");
        firstName = orderSubmissionPageData.getTestData("firstName");
        lastName = orderSubmissionPageData.getTestData("lastName");
        postalCode = orderSubmissionPageData.getTestData("code");
        orderSummaryPageTitle = orderSummaryPageData.getTestData("orderSummaryPageTitle");
        overviewURL = orderSummaryPageData.getTestData("overviewURL");

        successMessage = orderSummaryPageData.getTestData("successMessage");
        successMessageDescription = orderSummaryPageData.getTestData("successMessageDescription");
        completePageTitle = orderSummaryPageData.getTestData("completePageTitle");
    }
    @BeforeMethod
    public void runPrecondition_LoginWithValidCredentials() {

        Validations.assertThat().element(loginTitlePage()).exists().perform();
        new EntryPointPage(driver).typeUserName(userName).typePassword(password).clickLogin();
        Validations.assertThat().element(productsTitle()).text().isEqualTo(productsPageTitle).perform();
    }


    @Test
    public void addHighestTwoProductsPriceToCart()
    {
        new homePage(driver).addProductToCart()
                .getSelectedItemsNameFromHomePage()
                .navigateToCartPage(2);
        Validations.assertThat().element(shoppingCartTitle()).text().isEqualTo(shoppingCartPageTitle).perform();

        int actualQuantity = new shoppingCartPage(driver).getCartQuantityOfEachItem();
        Validations.assertThat().object(actualQuantity).isEqualTo(1).perform();

        new shoppingCartPage(driver).clickOnCheckoutBtn();
        Validations.assertThat().element(checkoutTitle()).text().isEqualTo(orderSubmissionPageTitle).perform();

        new orderSubmissionPage(driver).typeFirstName(firstName)
                .typeLastName(lastName)
                .typePostalCode(postalCode);

        new orderSubmissionPage(driver).clickContinueBtn();
        Validations.assertThat().element(summaryPageTitle()).text().isEqualTo(orderSummaryPageTitle).perform();
        String overViewUrl = new orderSummaryPage(driver).getCurrentURL();
        Validations.assertThat().object(overViewUrl).isEqualTo(overviewURL).perform();

        new orderSummaryPage(driver).validateAndCalculateSummarySubTotal();

        new orderSummaryPage(driver).clickSubmitOrder();
        Validations.assertThat().element(successMessage()).text().isEqualTo(successMessage).perform();
        Validations.assertThat().element(successMessageDescription()).text().isEqualTo(successMessageDescription).perform();
        Validations.assertThat().element(summaryPageTitle()).text().isEqualTo(completePageTitle).perform();

    }






}
