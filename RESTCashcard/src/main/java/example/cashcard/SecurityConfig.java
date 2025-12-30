package example.cashcard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Use this class to configure Spring and Spring Boot
class SecurityConfig {

    // Resources for CSRF
    // https://docs.spring.io/spring-security/reference/servlet/test/mockmvc/csrf.html
    // https://docs.spring.io/spring-security/site/docs/5.2.0.RELEASE/reference/html/test-webflux.html#csrf-support
    // https://cheatsheetseries.owasp.org/cheatsheets/Cross-Site_Request_Forgery_Prevention_Cheat_Sheet.html#double-submit-cookie

    @Bean
    // filterChain checks every HTTP request before reaching application
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                // all HTTP requests to cashcards need to be authenticated
                request -> request
                        .requestMatchers("/cashcards/**")
                        .hasRole("CARD-OWNER"))
                .httpBasic(Customizer.withDefaults())
                // Spring Security recommends to use CSRF for any requests
                // that could be processed by a browser by normal users
                // If creating a service used by non-browser clients, disable
                .csrf(csrf -> csrf.disable())
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService testOnlyUsers(PasswordEncoder passwordEncoder) {
        User.UserBuilder users = User.builder();

        UserDetails sarah = users
                .username("sarah1")
                .password(passwordEncoder.encode("abc123"))
                .roles("CARD-OWNER")
                .build();


        UserDetails hankOwnsNoCards = users
                .username("hank-owns-no-cards")
                .password(passwordEncoder.encode("qrs456"))
                .roles("NON-OWNER")
                .build();

        return new InMemoryUserDetailsManager(sarah, hankOwnsNoCards);
    }
}
