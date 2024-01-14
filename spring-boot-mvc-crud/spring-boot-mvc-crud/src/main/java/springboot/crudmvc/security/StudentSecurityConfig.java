package springboot.crudmvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

/**
 * Configuration class for Spring Security in the context of Student entities.
 * Provides configuration for JDBC-based user details manager and HTTP security settings.
 */
@Configuration
public class StudentSecurityConfig {


    /**
     * Configures a JDBC-based user details manager.
     *
     * @param dataSource The DataSource for accessing user details from the database.
     * @return The configured UserDetailsManager.
     */
   @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    /**
     * Configures the security filter chain with specific rules for different endpoints.
     *
     * @param http The HttpSecurity instance to configure.
     * @return The configured SecurityFilterChain.
     * @throws Exception If there is an issue with the configuration.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

       http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/students/list").hasRole("STUDENT")
                                .requestMatchers("/students/showAddForm").hasRole("STUDENT")
                                .requestMatchers("/students/save").hasRole("STUDENT")
                                .requestMatchers("/students/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                );

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general it's not required for stateless REST APIs that use POST, PUT, DELETE
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
