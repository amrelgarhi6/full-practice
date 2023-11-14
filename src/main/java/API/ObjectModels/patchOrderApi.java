package API.ObjectModels;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static API.Endpoints.BasePath.PATCH_ORDER;
import static API.Endpoints.BasePath.POST_ORDER;
import static API.Utils.Body.PLACE_ORDER_BODY;
import static API.Utils.Body.UPDATE_PLACE_ORDER_BODY;
import static API.Utils.ConstantVariables.TOKEN;

public class patchOrderApi {



    SHAFT.API apiObjectRequest;



    //constructor
    public patchOrderApi(SHAFT.API request) {
        this.apiObjectRequest = request;
    }

    public Response PatchOrder(String orderID) {
        return   apiObjectRequest.patch(PATCH_ORDER.getBasePath()+orderID)
                .setRequestBody(UPDATE_PLACE_ORDER_BODY)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + TOKEN)
                .setTargetStatusCode(204)
                .perform();

    }

}
