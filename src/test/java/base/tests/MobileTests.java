package base.tests;

import Mobile.homeScreen;
import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileTests {

    private final JSONFileManager loginPageData = new JSONFileManager("src/test/resources/testDataFiles/loginTestData.json");
    private final JSONFileManager productsPageData = new JSONFileManager("src/test/resources/testDataFiles/homePage.json");


    String userName;
    String password;

    String inValidUserName;
    String inValidPassword;
    String errorMessage;
    AndroidDriver driver;
    DesiredCapabilities dc = new DesiredCapabilities();


    @BeforeMethod
    public void setUp() throws MalformedURLException {
        userName = loginPageData.getTestData("validCred.username");
        password = loginPageData.getTestData("validCred.password");

        inValidUserName = loginPageData.getTestData("InValidCred.username");
        inValidPassword = loginPageData.getTestData("InValidCred.password");
        errorMessage = loginPageData.getTestData("errorMessage");

        dc.setCapability("platformVersion", "10.0");
        dc.setCapability("deviceName", "Pixel4");
        dc.setCapability("appPackage", "com.swaglabsmobileapp");
        dc.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
//    }
    }


    @Test(description = "test get all available books")
    public void typeUserName() {
        new homeScreen(driver).typeUserName(userName);
    }
    @Test(description = "test get all available books",dependsOnMethods = "typeUserName")
    public void typePassword() {
        new homeScreen(driver).typePassword(password);
    }










}
