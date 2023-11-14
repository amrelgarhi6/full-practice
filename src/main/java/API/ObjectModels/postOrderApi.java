package API.ObjectModels;

import API.Pojo.Response.postOrdersRes;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

import static API.Endpoints.BasePath.GET_BOOKS;
import static API.Endpoints.BasePath.POST_ORDER;
import static API.Utils.Body.PLACE_ORDER_BODY;
import static API.Utils.ConstantVariables.TOKEN;

public class postOrderApi {




    SHAFT.API apiObjectRequest;




    //constructor
    public postOrderApi(SHAFT.API request) {
        this.apiObjectRequest = request;
    }

    public Response PostNewOrder() {
        return   apiObjectRequest.post(POST_ORDER.getBasePath())
                .setRequestBody(PLACE_ORDER_BODY)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + TOKEN)
                .setTargetStatusCode(201)
                .perform();

    }
}
