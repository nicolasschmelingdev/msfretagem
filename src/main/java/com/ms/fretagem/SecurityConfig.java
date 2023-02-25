package com.ms.fretagem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v1/cep/**").permitAll()
                .antMatchers("/h2-console/**").permitAll() // permite acesso ao console H2
                .antMatchers("/swagger-ui/**").permitAll() // permite acesso ao swagger
                .antMatchers("/swagger-resources/**").permitAll()
                .anyRequest().authenticated() // exige autenticação para outras requisições
                .and()
                .headers().frameOptions().sameOrigin() // permite que o console H2 seja renderizado em um iframe
                .and()
                .formLogin().and().csrf().disable(); // habilita autenticação baseada em formulário
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("nicolas")
                .password(passwordEncoder().encode("12345678"))
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

