package API.ObjectModels;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static API.Endpoints.BasePath.GET_ORDER;
import static API.Utils.Body.PLACE_ORDER_BODY;
import static API.Utils.ConstantVariables.TOKEN;

public class getOrdersApi {


    SHAFT.API apiObjectRequest;


    //constructor
    public getOrdersApi(SHAFT.API request) {
        this.apiObjectRequest = request;
    }


    public Response GetOrder(String orderId) {
        return   apiObjectRequest.get(GET_ORDER.getBasePath()+orderId)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + TOKEN)
                .perform();

    }
}
