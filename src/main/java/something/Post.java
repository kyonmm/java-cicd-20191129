package something;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Post {
    public List<String> tags = new ArrayList<>();
    public String body = "";

    public void addTags(String... tags) {
        this.tags.addAll(Arrays.asList(tags));
    }

    public void updateBody(String body) {
        this.body = body;
    }
}
