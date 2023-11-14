package stepDefinition.Api;

import API.ObjectModels.*;
import API.Pojo.Response.getBooks;
import API.Pojo.Response.getOrders;
import API.Pojo.Response.postOrdersRes;
import API.Utils.StatusCodes;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import java.util.List;

public class ApiEndToEndTests {








    String orderID;
    private SHAFT.API apiObject;
    private getOrdersApi getOrdersReq;
    private getBooksApi getBooksApiReq;
    Response postOrder;
    postOrdersRes ordersPojo;
    private postOrderApi postOrderReq;
    private patchOrderApi patchOrderReq;
    private deleteOrderApi deleteOrderReq;

    @Given ("run precondition and prepare testData")
    public void run_precondition_and_prepare_test_data()
    {
        apiObject = new SHAFT.API(System.getProperty("BASE_API_URL"));
        getBooksApiReq = new getBooksApi(apiObject);
        getOrdersReq = new getOrdersApi(apiObject);
        postOrderReq = new postOrderApi(apiObject);
        patchOrderReq = new patchOrderApi(apiObject);
        deleteOrderReq = new deleteOrderApi(apiObject);
    }


    @Given("I get all available books")
    public void i_get_all_available_books() {
        Response getAllBooksRes = getBooksApiReq.getAllBooks();
        System.out.println(getAllBooksRes.asPrettyString());

        //Deserialize the response to java object class
        List<getBooks> listOfBooks = getAllBooksRes.as(new TypeRef<>() {});

        Validations.assertThat().number(getAllBooksRes.statusCode()).isEqualTo(StatusCodes.SUCCESS).perform();
        Validations.assertThat().object(getAllBooksRes.contentType()).contains("application/json").perform();
        Validations.assertThat().object(listOfBooks.get(0).getName()).contains("The Russian").perform();
    }

    @Then("I get my orders and check the order is placed successfully")
    public void i_get_my_orders_and_check_the_order_is_placed_successfully() {
        Response getOrder = getOrdersReq.GetOrder(orderID);
        System.out.println(getOrder.asPrettyString());

        //Deserialize the response to java object class
        getOrders getOrdersPojo;
        getOrdersPojo = getOrder.as(getOrders.class);
        Validations.assertThat().number(getOrder.getStatusCode()).isEqualTo(StatusCodes.SUCCESS).perform();
        Validations.assertThat().object(getOrdersPojo.getId()).isEqualTo(orderID).perform();
        Validations.assertThat().object(getOrdersPojo.getQuantity()).isEqualTo(1).perform();
        Validations.assertThat().object(getOrdersPojo.getCustomerName()).isEqualTo("John").perform();
        Validations.assertThat().object(getOrdersPojo.getTimestamp()).isNotNull().perform();
    }

    @Then("I check the order updated with new customer name")
    public void i_check_the_order_updated_with_new_customer_name() {
        Response getOrder = getOrdersReq.GetOrder(orderID);
        System.out.println(getOrder.asPrettyString());

        //Deserialize the response to java object class
        getOrders getOrdersPojo;
        getOrdersPojo = getOrder.as(getOrders.class);

        Validations.assertThat().number(getOrder.getStatusCode()).isEqualTo(StatusCodes.SUCCESS).perform();
        Validations.assertThat().object(getOrdersPojo.getCustomerName()).isEqualTo("ANTONY").perform();
        Validations.assertThat().object(getOrdersPojo.getId()).isEqualTo(orderID).perform();
        Validations.assertThat().object(getOrdersPojo.getQuantity()).isEqualTo(1).perform();
        Validations.assertThat().object(getOrdersPojo.getTimestamp()).isNotNull().perform();
    }
    @Then("I check the order id has been deleted successfully")
    public void i_check_the_order_id_has_been_deleted_successfully() {
        Response getOrder = getOrdersReq.GetOrder(orderID);
        System.out.println(getOrder.asPrettyString());

        Validations.assertThat().number(getOrder.getStatusCode()).isEqualTo(StatusCodes.NOT_FOUND).perform();
        Validations.assertThat().object(getOrder.jsonPath().get("error")).contains("No order with id "+orderID).perform();
        Validations.assertThat().object(getOrder).isNotNull().perform();
    }

    @When("I place an order with a specific book")
    public void i_place_an_order_with_a_specific_book() {
        postOrder = postOrderReq.PostNewOrder();
        System.out.println(postOrder.asPrettyString());

        //Deserialize the response to java object class
        ordersPojo = postOrder.as(postOrdersRes.class);
        //Get order ID
        orderID = ordersPojo.getOrderId();
    }

    @Then("I validate that post request happened successfully with same customer name")
    public void i_validate_that_post_request_happened_successfully_with_same_customer_name() {
        Validations.assertThat().number(postOrder.getStatusCode()).isEqualTo(StatusCodes.CREATED).perform();
        Validations.assertThat().object(ordersPojo.isCreated()).isTrue().perform();
        Validations.assertThat().object(ordersPojo.getOrderId()).isNotNull().perform();
    }
    @When("I replace the order with new customer name")
    public void i_replace_the_order_with_new_customer_name() {
        Response patchOrder = patchOrderReq.PatchOrder(orderID);
        System.out.println(patchOrder.asPrettyString());

        Validations.assertThat().number(patchOrder.getStatusCode()).isEqualTo(StatusCodes.NO_CONTENT).perform();
        Validations.assertThat().object(patchOrder).isNotNull().perform();
    }
    @When("I cancel my last order")
    public void i_cancel_my_last_order() {
        Response deleteOrder = deleteOrderReq.DeleteOrder(orderID);
        System.out.println(deleteOrder.asPrettyString());

        Validations.assertThat().number(deleteOrder.getStatusCode()).isEqualTo(StatusCodes.NO_CONTENT).perform();
        Validations.assertThat().object(deleteOrder).isNotNull().perform();
    }


}
