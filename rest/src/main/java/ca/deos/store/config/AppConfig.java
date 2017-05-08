package ca.deos.store.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.CorsFilter;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import util.MyLogger;

import javax.annotation.PostConstruct;

@Configuration
public class AppConfig {


    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PATCH");
        config.addAllowedMethod("OPTIONS");
        source.registerCorsConfiguration("/**",config);
        return new CorsFilter(source);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Value("${spring.profiles.active}")
    String profile;

    @PostConstruct
    public void setLogs() {
        if (profile != null && profile.equals("dev")) {
            System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
            System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
            System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
            System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        }
    }

    @Bean
    public MyLogger myLogger(){
        return new MyLogger();
    }

}
