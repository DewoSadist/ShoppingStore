package ca.deos.store.config;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalAuthentication
public class JDBCSecurityConfig extends GlobalAuthenticationConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(JdbcTemplate jdbcTemplate) {
// username ,
// password ,
// enabled ,
// accountNonExpired ,
// credentialsNonExpired ,
// accountNonLocked
// authorities  collections as the constructor’s parameters.
        RowMapper <User> userRowMapper = (ResultSet rs, int i) ->
                 new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBoolean("ENABLED"),
                        rs.getBoolean("ENABLED"),
                        rs.getBoolean("ENABLED"),
                        rs.getBoolean("ENABLED"),
                         AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN"));

                    return username ->
                jdbcTemplate.queryForObject("SELECT * FROM users WHERE username = ?",
                                        userRowMapper, username);

    }



    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService);
    }
}
