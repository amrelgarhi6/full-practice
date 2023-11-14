package GUI;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class shoppingCartPage {





    SHAFT.GUI.WebDriver driver;

    //constructor
    public shoppingCartPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }



    List<WebElement> productsName;
    List<WebElement> addedItemsQuantityInCart;
    String productItemName;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////// Cart Locators  ///////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static By badgeOfNumberOfItemInCrt() {return By.cssSelector(".shopping_cart_badge");}
    public static By cartQuantity() {return By.cssSelector("div.cart_quantity");}

    public static By shoppingCartTitle() {return By.xpath("//div[@class='header_secondary_container']//span[@class='title']");}
    private static By listOfProductPrices() {return By.cssSelector("inventory_item_price");}
    private static By listOfProductNames() {return By.cssSelector(".inventory_item_name");}
    public static By removeItemFromCartVCTA() {return By.xpath("//button[contains(@id,'remove')]");}
    public static By checkoutCTA() {return By.id("checkout");}




    public String getSelectedItemsNameFromShoppingCartPage (){

        int i;
        String productItemName = null;
        productsName = driver.getDriver().findElements(listOfProductNames());

        for (i=0 ; i< productsName.size() ;i++) {
            productItemName = productsName.get(i).getText();
            System.out.println("Here  >>> " + productItemName);
        }
        return productItemName;
    }

    public int getCartQuantityOfEachItem (){

        int quantityVal = 0;
        int i;
        addedItemsQuantityInCart = driver.getDriver().findElements(cartQuantity());

        for (i=0 ; i< addedItemsQuantityInCart.size() ;i++)
        {
            String addedItemsQuantityInCartValue = addedItemsQuantityInCart.get(i).getText();
            quantityVal = Integer.parseInt(addedItemsQuantityInCartValue);
        }
        if (quantityVal == 1)
        {
            System.out.println("The quantity of added items is  >> = " +quantityVal);
        }
        return quantityVal;
    }



    public shoppingCartPage clickOnCheckoutBtn (){
        driver.element().click(checkoutCTA());
        return this;
    }

}
