package ge.tbc.testautomation.hackathon.api;

import ge.tbc.testautomation.hackathon.models.requests.LoginRequest;
import ge.tbc.testautomation.hackathon.utils.Constants;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class AuthHelper {

    private AuthHelper() {}

    public static LoginRequest credentials(String email, String password) {
        return new LoginRequest(email, password);
    }

    public static String fetchAuthToken(RequestSpecification requestSpec) {
        Response response = given()
                .spec(requestSpec)
                .body(credentials(Constants.TEST_USERNAME, Constants.TEST_PASSWORD))
                .when()
                .post(Constants.ENDPOINT_LOGIN);

        Assert.assertEquals(response.statusCode(), 200,
                "Login pre-condition failed — cannot run API tests without a valid token");

        return response.jsonPath().getString("token");
    }
}
