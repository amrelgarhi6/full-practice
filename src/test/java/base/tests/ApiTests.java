package base.tests;

import Mobile.homeScreen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class ApiTests {





//
//
//
//    @Test(description = "validate place a new order with a specific book",dependsOnMethods = "invokeGetAllBooks")
//    public void testInvokePostRequestToPlaceNewBookOrder() {
//        Response postOrder = postOrderReq.PostNewOrder();
//        System.out.println(postOrder.asPrettyString());
//
//        //Deserialize the response to java object class
//        postOrdersRes ordersPojo;
//        ordersPojo = postOrder.as(postOrdersRes.class);
//        //Get order ID
//        orderID = ordersPojo.getOrderId();
//
//        Validations.assertThat().number(postOrder.getStatusCode()).isEqualTo(StatusCodes.CREATED).perform();
//        Validations.assertThat().object(ordersPojo.isCreated()).isTrue().perform();
//        Validations.assertThat().object(ordersPojo.getOrderId()).isNotNull().perform();
//    }
//
//    @Test(description = "validate get a specific order details",dependsOnMethods = "testInvokePostRequestToPlaceNewBookOrder")
//    public void testInvokeGetRequestToGetSpecificOrder() {
//        Response getOrder = getOrdersReq.GetOrder(orderID);
//        System.out.println(getOrder.asPrettyString());
//
//        //Deserialize the response to java object class
//        getOrders getOrdersPojo;
//        getOrdersPojo = getOrder.as(getOrders.class);
//
////        Validations.assertThat().number(postOrder.getStatusCode()).isEqualTo(StatusCodes.CREATED).perform();
////        Validations.assertThat().object(ordersPojo.isCreated()).isTrue().perform();
////        Validations.assertThat().object(ordersPojo.getOrderId()).isNotNull().perform();
//    }
//    @Test(description = "validate get a specific order details",dependsOnMethods = "testInvokeGetRequestToGetSpecificOrder")
//    public void testInvokePatchRequestToReplaceSpecificOrder() {
//        Response patchOrder = patchOrderReq.PatchOrder(orderID);
//        System.out.println(patchOrder.asPrettyString());
//
//
//        Validations.assertThat().number(patchOrder.getStatusCode()).isEqualTo(StatusCodes.NO_CONTENT).perform();
//        Validations.assertThat().object(patchOrder).isNotNull().perform();
//    }
//    @Test(description = "validate get a specific order details to check the reflection of editing order info correctly",dependsOnMethods = "testInvokePatchRequestToReplaceSpecificOrder")
//    public void testInvokeGetRequestToValidateEditingSpecificOrderInfo() {
//        Response getOrder = getOrdersReq.GetOrder(orderID);
//        System.out.println(getOrder.asPrettyString());
//
//        //Deserialize the response to java object class
//        getOrders getOrdersPojo;
//        getOrdersPojo = getOrder.as(getOrders.class);
//
////        Validations.assertThat().number(postOrder.getStatusCode()).isEqualTo(StatusCodes.CREATED).perform();
//        Validations.assertThat().object(getOrdersPojo.getCustomerName()).isEqualTo("ANTONY").perform();
////        Validations.assertThat().object(ordersPojo.getOrderId()).isNotNull().perform();
//    }
//
//
//    @Test(description = "validate get a specific order details",dependsOnMethods = "testInvokeGetRequestToValidateEditingSpecificOrderInfo")
//    public void testInvokeDeleteRequestToCancelSpecificOrder() {
//        Response deleteOrder = deleteOrderReq.DeleteOrder(orderID);
//        System.out.println(deleteOrder.asPrettyString());
//
//        Validations.assertThat().number(deleteOrder.getStatusCode()).isEqualTo(StatusCodes.NO_CONTENT).perform();
//        Validations.assertThat().object(deleteOrder).isNotNull().perform();
//    }
}



