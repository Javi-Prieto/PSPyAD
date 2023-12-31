package com.salesianos.dam.Example_for_Security.Security;

import com.salesianos.dam.Example_for_Security.Security.errorhandling.JwtAccessDeniedHandler;
import com.salesianos.dam.Example_for_Security.Security.errorhandling.JwtAuthenticationEntryPoint;
import com.salesianos.dam.Example_for_Security.Security.jwt.access.JwtAuthenticationFilter;
import com.salesianos.dam.Example_for_Security.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsService service;
    private final PasswordEncoder encoder;

    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws  Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        return authenticationManagerBuilder.authenticationProvider(authenticationProvider()).build();
    }
    @Bean
    public DaoAuthenticationProvider  authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(service);
        authenticationProvider.setPasswordEncoder(encoder);
        authenticationProvider.setHideUserNotFoundExceptions(false);

        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .cors(Customizer.withDefaults())
                .csrf((csrf)-> csrf
                        .ignoringRequestMatchers(antMatcher("/**")))
                        .exceptionHandling((e) -> { e
                                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                                .accessDeniedHandler(jwtAccessDeniedHandler);
                        })
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests((auth) -> auth
                            .requestMatchers(antMatcher("/empleados/**")).hasRole("USER")
                            .requestMatchers(antMatcher("/user/register/admin")).hasRole("ADMIN")
                            .anyRequest().authenticated()
                    );
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        http.headers(h -> h.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web -> web.ignoring().requestMatchers(
                antMatcher("/h2-console/**"),
                antMatcher("/user/register")));
    }
}
