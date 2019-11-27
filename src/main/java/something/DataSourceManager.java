package something;

import com.zaxxer.hikari.HikariDataSource;
import io.micronaut.context.annotation.Value;

import javax.inject.Singleton;

//@Singleton
public class DataSourceManager {
    @Value("${myapp.jdbcurl}")
    String jdbcUrl;

    public final HikariDataSource dataSource = new HikariDataSource();

    public HikariDataSource getDataSource() {
        System.out.println(jdbcUrl);
        dataSource.setJdbcUrl(jdbcUrl);
        return dataSource;
    }
}
