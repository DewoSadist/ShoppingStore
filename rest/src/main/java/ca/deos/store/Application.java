package ca.deos.store;

import ca.deos.store.config.AppConfig;
import ca.deos.store.config.JpaConfig;
import ca.deos.store.config.JDBCSecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
@Import({AppConfig.class, JpaConfig.class, JDBCSecurityConfig.class})
public class Application {

    static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        log.info("Starting Application ...");

        SpringApplication.run(Application.class, args);
    }
}
