package kz.anydrop.tests;

import kz.anydrop.steps.PostSteps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testUpdatePost() {
        Map<String, Object> postData = new HashMap<>();
        String title = "testing title";
        String body = "testing body";
        int postId = 1;
        int userId = 1;
        postData.put("title", title);
        postData.put("body", body);
        postData.put("userId", userId);
        PostSteps postSteps = new PostSteps();
        postSteps.updatePost(postData, postId)
                .then().statusCode(200)
                .body("id", equalTo(1),
                        "title", equalTo(title),
                        "body", equalTo(body),
                        "userId", equalTo(userId));

    }

    @Test
    public void testPatchPost() {
        Map<String, Object> postData = new HashMap<>();
        String title = "testing title";
        String body = "testing body";
        int postId = 1;
        int userId = 1;
        postData.put("title", title);
        postData.put("body", body);
        postData.put("userId", userId);
        PostSteps postSteps = new PostSteps();
        postSteps.patchPost(postData, postId)
                .then().statusCode(200)
                .body("id", equalTo(1),
                        "title", equalTo(title),
                        "body", equalTo(body),
                        "userId", equalTo(userId));

    }

    @Test
    public void testDeletePost() {
        PostSteps postSteps = new PostSteps();
        int postId = 1;
        postSteps.deletePost(postId)
                .then().statusCode(200);
    }

    @Test
    public void testGetPosts() {

    }
}
