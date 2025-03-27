package uit.advancecrm.group17.bpmn.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {
    @Bean(name = "flywaySecondary")
    public Flyway flywaySecondary(@Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(secondaryDataSource)
                .locations("classpath:db/migration/secondary")  // Set migration locations
                .baselineOnMigrate(true)  // Optional: To handle versioning issues
                .load();
        flyway.migrate();
        return flyway;
    }
}
