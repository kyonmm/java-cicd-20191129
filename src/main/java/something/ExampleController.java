package something;

import io.micronaut.context.annotation.Context;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;

@Controller("/examples")
public class ExampleController {
    @View("examples")
    @Get("/")
    public HttpResponse index() {
        return HttpResponse.ok(CollectionUtils.mapOf("loggedIn", true, "username", "sdelamo"));
    }
}
