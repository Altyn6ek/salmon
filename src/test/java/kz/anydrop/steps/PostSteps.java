package kz.anydrop.steps;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Java6BDDSoftAssertionsProvider;
import org.hamcrest.Condition;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static kz.anydrop.interfaces.BaseComponentTest.config;

public class PostSteps {

    public static RequestSpecification REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .setBaseUri(config.get("jsonplaceholder.url"))
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new RequestLoggingFilter())
            .addFilter(new AllureRestAssured())
            .build();

    public Response getPostById(int post_id) {
        return given().spec(REQUEST_SPECIFICATION)
                .get("posts/" + post_id);
    }

    public Response createPost(Map<String, Object> postData) {
        return given().spec(REQUEST_SPECIFICATION)
                .body(postData)
                .post("posts/");
    }

    public Response updatePost(Map<String, Object> postData, int postId) {
        postData.put("id", postId);
        return given().spec(REQUEST_SPECIFICATION)
                .body(postData)
                .put("posts/" + postId);
    }

    public Response patchPost(Map<String, Object> postData, int postId) {
        postData.put("id", postId);
        return given().spec(REQUEST_SPECIFICATION)
                .body(postData)
                .patch("posts/" + postId);
    }
}
