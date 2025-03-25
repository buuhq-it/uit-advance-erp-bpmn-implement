package uit.advancecrm.group17.bpmn.config;

import lombok.extern.slf4j.Slf4j;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class ProcessEngineConfig {
    @Bean
    public SpringProcessEngineConfiguration processEngineConfiguration(
            DataSource dataSource,
            PlatformTransactionManager transactionManager) {
        SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();

        config.setDataSource(dataSource);
        config.setTransactionManager(transactionManager);

        config.setDatabaseSchemaUpdate("create");
        config.setHistory("audit");
        config.setJobExecutorActivate(true);
        config.setDatabaseSchemaUpdate("false");
        config.setAsyncExecutorActivate(true);
        config.setJobExecutorActivate(false);

        log.info("start SpringProcessEngineConfiguration BEAN SUCCESS!!!" + config);

        return config;
    }
}
