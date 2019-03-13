package com.devheaven.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This class configures the security for the application.
 *
 * @author tomdewildt
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Configures the JWT Token Configurator.
     *
     * @param http the security object.
     * @throws Exception if an error occurred.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Disable CSRF (cross site request forgery)
        http.csrf().disable();

        // Disable sessions
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Entry points
        http.authorizeRequests()//
                .antMatchers("/api/v1/auth/login").permitAll()
                .antMatchers("/api/v1/auth/register").permitAll()
                .antMatchers("/api/v1").authenticated();

        // Apply JWT
        // TODO: apply JWT token filter
    }

    /**
     * Configures the allowed routes for the security filter.
     *
     * @param web the web security object.
     */
    @Override
    public void configure(WebSecurity web) {
        // Allow swagger to be accessed without authentication
        web.ignoring().antMatchers("/swagger-docs")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/swagger-ui.html")
                .antMatchers("/configuration/**")
                .antMatchers("/webjars/**");
    }

    /**
     * Configures a password encoder to encrypt and decrypt passwords.
     *
     * @return An instance of a password encoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    /**
     * Configures a authentication manager to handle authentication.
     *
     * @return An instance of the authentication manager.
     * @throws Exception if an error occurred.
     */
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}

