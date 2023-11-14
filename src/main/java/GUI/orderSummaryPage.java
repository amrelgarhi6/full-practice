package GUI;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static GUI.homePage.listOfProductPrices;

public class orderSummaryPage {





    private final SHAFT.GUI.WebDriver driver;

    //constructor
    public orderSummaryPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }



    List<WebElement> productsName;
    String productItemName;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////// Cart Locators  ///////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static By summaryPageTitle() {return By.xpath("//div[@class='header_secondary_container']//span[@class='title']");}
    public static By summary_subtotal_label() {return By.cssSelector(".summary_subtotal_label");}
    public static By submitOrderBtn() {return By.id("finish");}
    public static By successMessage() {return By.cssSelector(".complete-header");}
    public static By successMessageDescription() {return By.cssSelector(".complete-text");}

    public static By backToProductsPageBn() {return By.id("back-to-products");}

    public orderSummaryPage validateAndCalculateSummarySubTotal(){

        ArrayList<Integer> list = new ArrayList<>();
        int price;
        List<WebElement> listOfPrices = driver.getDriver().findElements(listOfProductPrices());
        for (WebElement listOfPrice : listOfPrices) {

            price = Integer.parseInt(listOfPrice.getText().substring(1).replaceAll("\\.", ""));
            list.add(price);
        }
        int total = list.get(0) + list.get(1) ;

        String subTotalBeforeEditing = driver.element().getText(summary_subtotal_label()).substring(13).replace(".","");
        int subTotal = Integer.parseInt(subTotalBeforeEditing);


        if (total == subTotal)

        {
            System.out.println("Submission of items prices is >> " + total);
            System.out.println("SubTotal amount  >> " + subTotal);
            Validations.assertThat().object(total).isEqualTo(subTotal).withCustomReportMessage("<<<<<<< Calculation is correct >>>>").perform();
        }
        return this;
    }
    public String getCurrentURL(){
        return  driver.browser().getCurrentURL();
    }

    public homePage navigateToProductsHomePage(){
         driver.element().click(backToProductsPageBn());
        return new homePage(driver);
    }
    public orderSummaryPage clickSubmitOrder()
    {
        driver.element().click(submitOrderBtn());
        return this;
    }

}
