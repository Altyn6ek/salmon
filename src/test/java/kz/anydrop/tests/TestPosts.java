package kz.anydrop.tests;

import io.qameta.allure.Allure;
import kz.anydrop.pojos.Post;
import kz.anydrop.steps.PostSteps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestPosts {

    @Test
    public void testAllPosts() {
        StringBuilder log = new StringBuilder();
        PostSteps postSteps = new PostSteps();
        Post[] posts = postSteps.getPosts()
                .then().statusCode(200).extract().as(Post[].class);
        Map<String, Integer> wordCount = new HashMap<>();

        for (Post data : posts) {
            String body = data.getBody().toLowerCase();
            String[] words = body.split("\\W+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> sortedWords = wordCount.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .toList();

        System.out.println("Top 10 most common words:");
        for (int i = 0; i < Math.min(10, sortedWords.size()); i++) {
            Map.Entry<String, Integer> entry = sortedWords.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue() + " times");
            log.append((i + 1)).append(". ").append(entry.getKey()).append(" - ")
                    .append(entry.getValue()).append(" times \n");
        }

        Allure.addAttachment("Log", "text/plain", "Top 10 most common words: \n" + log,
                "txt");

    }
}
