package API.ObjectModels;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static API.Endpoints.BasePath.GET_BOOKS;

public class getBooksApi {


    SHAFT.API apiObjectRequest;


    //constructor
    public getBooksApi(SHAFT.API request) {
        this.apiObjectRequest = request;
    }


    //Happy Scenarios
    public Response getAllBooks() {
        return apiObjectRequest.get(GET_BOOKS.getBasePath())
                .setContentType(ContentType.JSON)
                .setTargetStatusCode(200)
                .perform();
    }

}
