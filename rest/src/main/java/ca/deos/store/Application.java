package ca.deos.store;

import ca.deos.store.config.AppConfig;
import ca.deos.store.config.JpaConfig;
import ca.deos.store.config.JDBCSecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
@Import({AppConfig.class, JpaConfig.class, JDBCSecurityConfig.class})
@ComponentScan({
        "ca.deos.store.controller",
        "ca.deos.store.service",
        "ca.deos.store.controller",
        "ca.deos.store.dao",
        "ca.deos.store.config",
        "ca.deos.store.entity",
        "ca.deos.store.exceptions"
})
public class Application {

    static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        log.info("Starting Application ...");

        SpringApplication.run(Application.class, args);
    }
}
