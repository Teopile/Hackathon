package ge.tbc.testautomation.hackathon.api;

import ge.tbc.testautomation.hackathon.utils.Constants;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiClient {

    private ApiClient() {}

    public static RequestSpecification buildBaseSpec() {
        RestAssured.baseURI = Constants.LOCAL_API_URL;
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public static RequestSpecification withAuth(RequestSpecification base, String token) {
        return new RequestSpecBuilder()
                .addRequestSpecification(base)
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }
}
