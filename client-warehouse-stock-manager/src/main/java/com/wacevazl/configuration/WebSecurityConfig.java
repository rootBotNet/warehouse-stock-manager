package com.wacevazl.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${application.usernameadmin}")
    private String usernameAdmin;

    @Value("${application.encodedpasswordadmin}")
    private String encodedPasswordAdmin;

    @Value("${application.usernameuser}")
    private String usernameUser;

    @Value("${application.encodedpassworduser}")
    private String encodedPasswordUser;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser(usernameAdmin).password(encodedPasswordAdmin).roles("USER", "ADMIN")
                .and()
                .withUser(usernameUser).password(encodedPasswordUser).roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
