package API.ObjectModels;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static API.Endpoints.BasePath.DELETE_ORDER;
import static API.Endpoints.BasePath.PATCH_ORDER;
import static API.Utils.Body.UPDATE_PLACE_ORDER_BODY;
import static API.Utils.ConstantVariables.TOKEN;

public class deleteOrderApi {


    SHAFT.API apiObjectRequest;



    //constructor
    public deleteOrderApi(SHAFT.API request) {
        this.apiObjectRequest = request;
    }

    public Response DeleteOrder(String orderID) {
        return   apiObjectRequest.delete(DELETE_ORDER.getBasePath()+orderID)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + TOKEN)
                .setTargetStatusCode(204)
                .perform();

    }

}
