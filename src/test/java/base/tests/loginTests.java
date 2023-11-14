package base.tests;

import GUI.EntryPointPage;
import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static GUI.EntryPointPage.errorMessage;
import static GUI.EntryPointPage.loginTitlePage;
import static GUI.homePage.productsTitle;

public class loginTests extends BaseTest  {



    private final JSONFileManager loginPageData = new JSONFileManager("src/test/resources/testDataFiles/loginTestData.json");
    private final JSONFileManager productsPageData = new JSONFileManager("src/test/resources/testDataFiles/homePage.json");

    String productsPageTitle;
    String userName;
    String password;

    String inValidUserName;
    String inValidPassword;
    String errorMessage;

    @BeforeClass
    public void setup(){
        productsPageTitle = productsPageData.getTestData("productsPageTitle");
        userName = loginPageData.getTestData("validCred.username");
        password = loginPageData.getTestData("validCred.password");

        inValidUserName = loginPageData.getTestData("InValidCred.username");
        inValidPassword = loginPageData.getTestData("InValidCred.password");
        errorMessage = loginPageData.getTestData("errorMessage");

    }

    @Test
    public void loginWithValidCredentials() {

        Validations.assertThat().element(loginTitlePage()).exists().perform();
        new EntryPointPage(driver).typeUserName(userName).typePassword(password).clickLogin();
        Validations.assertThat().element(productsTitle()).text().isEqualTo(productsPageTitle).perform();
    }

    @Test
    public void loginWithInValidCredentials() {

        Validations.assertThat().element(loginTitlePage()).exists().perform();
        new EntryPointPage(driver).typeUserName(inValidUserName).typePassword(inValidPassword).clickLogin();
        Validations.assertThat().element(errorMessage()).text().isEqualTo(errorMessage).perform();
    }
}


