package kz.anydrop.tests;

import kz.anydrop.steps.PostSteps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;


public class TestJsonPlaceholder {

    @Test
    public void testGetPost() {
        PostSteps postSteps = new PostSteps();
        postSteps.getPostById(1)
                .then().statusCode(200)
                .body("userId", equalTo(1), "id", equalTo(1),
                        "title", hasToString("sunt aut facere repellat provident occaecati excepturi " +
                                "optio reprehenderit"),
                                "body", containsString("quia et suscipit\n"));
    }

    @Test
    public void testCreatePost() {
        Map<String, Object> postData = new HashMap<>();
        String title = "testing title";
        String body = "testing body";
        int userId = 1;
        postData.put("title", title);
        postData.put("body", body);
        postData.put("userId", userId);
        PostSteps postSteps = new PostSteps();
        postSteps.createPost(postData)
                .then().statusCode(201)
                .body("id", equalTo(101),
                        "title", equalTo(title),
                        "body", equalTo(body),
                        "userId", equalTo(userId));

    }
}
