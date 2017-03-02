package ca.deos.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

//@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
@Import({JpaConfig.class})
public class Application {

    static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        log.info("Starting Application ...");

        SpringApplication.run(Application.class, args);
    }
}
