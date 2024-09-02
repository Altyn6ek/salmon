package kz.anydrop.steps;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static kz.anydrop.interfaces.BaseComponentTest.config;
import static org.hamcrest.Matchers.equalTo;

public class PostSteps {

    public static RequestSpecification REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .setBaseUri(config.get("jsonplaceholder.url"))
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new RequestLoggingFilter())
            .addFilter(new AllureRestAssured())
            .build();

    public Response getPost(int i) {
        return given().spec(REQUEST_SPECIFICATION)
                .get("https://jsonplaceholder.typicode.com/posts/1");
    }
}
