package something;

import io.micronaut.context.annotation.Value;
import io.micronaut.runtime.Micronaut;

import javax.sql.DataSource;

public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}