package ca.deos.store.config;
/**
 * Class For Securing  POST DELETE PUT methods from exposing
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableGlobalAuthentication
//public class ResourceSecurityConfig extends WebSecurityConfigurerAdapter{
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/api/admin/**").authenticated()
//                .and()
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .logout().permitAll();
//    }
//}
