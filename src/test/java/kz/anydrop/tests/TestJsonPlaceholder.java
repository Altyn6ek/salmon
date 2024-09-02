package kz.anydrop.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import kz.anydrop.steps.PostSteps;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.restassured.RestAssured.*;


public class TestJsonPlaceholder {

    @Test
    public void testGetPost() {
        PostSteps postSteps = new PostSteps();
        postSteps.getPost(1)
                .then().statusCode(200)
                .body("userId", equalTo(1));;
    }

}
