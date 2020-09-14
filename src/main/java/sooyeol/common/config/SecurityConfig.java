package sooyeol.common.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/actuator/shutdown")
                .access("hasIpAddress('127.0.0.1') or hasIpAddress('0:0:0:0:0:0:0:1')")
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

}