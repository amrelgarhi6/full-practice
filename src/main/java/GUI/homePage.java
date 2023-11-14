package GUI;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static GUI.shoppingCartPage.badgeOfNumberOfItemInCrt;

public class homePage {

    SHAFT.GUI.WebDriver driver;

    //constructor
    public homePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }



    List<WebElement> productsName;
    List<WebElement> listOfPrices;
    List<WebElement> addProductBtn;
    public String productItemName;
    int price;
    int firstMaxIdx ;
    int secondMaxIdx;
    int firstMaxPriceValue;
    int secondMaxPriceValue;
    public int total;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////  Locators  ///////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static By appHeader() {return By.cssSelector(".app_logo");}
    private static By cartBtn() {return By.id("shopping_cart_container");}
    public static By productsTitle() {return By.xpath("//div[@class='header_secondary_container']//span[@class='title']");}
    public static By listOfProductPrices() {return By.className("inventory_item_price");}
    private static By listOfProductNames() {return By.className("inventory_item_name");}

    private static By addToCartBtn(int indexOfItem) {return By.xpath("(//button[contains(@id,'add-to-cart')])["+indexOfItem+"]");}
    private static By removeItemFromCartVCTA() {return By.xpath("//button[contains(@id,'remove')]");}




    public shoppingCartPage clickOnCartBtn(){
        driver.element().click(cartBtn());
        return new shoppingCartPage(driver);
    }

    public homePage getListOfPrices(){
        driver.element().click(cartBtn());
        return this;
    }
    public homePage addProductToCart() {
        listOfPrices = driver.getDriver().findElements(listOfProductPrices());

        List<Integer> myList;
        myList = new ArrayList<>();
        int i;
        for (i = 0; i < listOfPrices.size(); i++) {

            price = Integer.parseInt(listOfPrices.get(i).getText().substring(1).replaceAll("\\.", ""));
            System.out.println("The price after editing  >>> " + price);
            myList.add(price);
        }
        System.out.println("This my list  >>>> " + myList);

        firstMaxPriceValue = Integer.MIN_VALUE;
        secondMaxPriceValue = Integer.MIN_VALUE;
        for (int number : myList) {
            if (number > firstMaxPriceValue) {
                secondMaxPriceValue = firstMaxPriceValue;
                firstMaxPriceValue = number;
            } else if (number > secondMaxPriceValue && number!=firstMaxPriceValue) {
                secondMaxPriceValue = number;
            }
        }
        System.out.println("First maximum number is : " + firstMaxPriceValue);
        System.out.println("Second maximum number is : " + secondMaxPriceValue);

        int firstMaxVal = Collections.max(Collections.singleton(firstMaxPriceValue));
        int secondMaxVal = Collections.max(Collections.singleton(secondMaxPriceValue));

        firstMaxIdx = myList.indexOf(firstMaxVal);
        secondMaxIdx = myList.indexOf(secondMaxVal);

        System.out.println("Max index >>> "+firstMaxIdx );
        System.out.println("Max index >>> "+secondMaxIdx );

        total = firstMaxPriceValue + secondMaxPriceValue ;
        System.out.println("Total Amount >>> "+total );
        if (firstMaxIdx == 0 || secondMaxIdx==0)
        {
            firstMaxIdx = firstMaxIdx+1;
            secondMaxIdx= secondMaxIdx+1;
        }
        driver.element().click(addToCartBtn(firstMaxIdx));
        driver.element().click(addToCartBtn(secondMaxIdx));
//        int maximum = myList.get(0);
//        for (int k = 1; k < myList.size(); k++) {
//            if (maximum < myList.get(k))
//                maximum = myList.get(k);
//        }
//        System.out.println("Maximum Element in ArrayList = "
//                + maximum);
        return this;
        }

    public homePage clickRemoveItemFromCartBtn(){
        driver.element().click(removeItemFromCartVCTA());
        return this;
    }
    public shoppingCartPage navigateToCartPage(int numberOfAddedItemsToCart){

        List<WebElement> addedProductsToCart = driver.getDriver().findElements(removeItemFromCartVCTA());
        int numberOfProductsInCart = Integer.parseInt(driver.element().getText(badgeOfNumberOfItemInCrt()));
        for (int i=0 ; i<= addedProductsToCart.size() ;i++)
        {
            if (addedProductsToCart.size() == numberOfAddedItemsToCart && numberOfProductsInCart == numberOfAddedItemsToCart)
            {
                driver.element().click(cartBtn());
            }
        }
        return new shoppingCartPage(driver);
    }


    public homePage getSelectedItemsNameFromHomePage (){
        productsName = driver.getDriver().findElements(listOfProductNames());
            productItemName = productsName.get(firstMaxIdx).getText();
            productItemName = productsName.get(secondMaxIdx).getText();
        return this;
    }





}
