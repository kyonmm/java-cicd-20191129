package something;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PostSpec {
    @Test
    public void 投稿は文章がデフォルトは空(){
        Post newPost = new Post();
        Assertions.assertEquals(
                "",
                newPost.body);
    }
    @Test
    public void 投稿は文章をもてるが常に1つしかもてない(){
        Post newPost = new Post();
        newPost.updateBody("1st");
        Assertions.assertEquals(
                "1st",
                newPost.body);
        newPost.updateBody("2nd");
        Assertions.assertEquals(
                "2nd",
                newPost.body);
    }
    @Test
    public void 投稿はタグがデフォルトは空(){
        Post newPost = new Post();
        Assertions.assertIterableEquals(
                new ArrayList<String>(),
                newPost.tags);
    }
    @Test
    public void 投稿はタグを複数もてる(){
        Post newPost = new Post();
        newPost.addTags("美味しい", "旅行楽しい");
        Assertions.assertIterableEquals(
                Arrays.asList("美味しい", "旅行楽しい"),
                newPost.tags);
    }
}
