package com.example.demo.authentication;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    private UserDetailsServiceImpl userDetailsService;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();
       http.authorizeRequests()
               .antMatchers( HttpMethod.GET,"/user/**").hasAnyAuthority("ROLE_ADMIN")
               .antMatchers( HttpMethod.POST,"/user/update").hasAnyAuthority("ROLE_USER")
               .antMatchers( HttpMethod.DELETE,"/user/**").hasAnyAuthority("ROLE_ADMIN")
               .antMatchers( HttpMethod.GET,"/cat/**").hasAnyAuthority("ROLE_USER")
               .antMatchers( HttpMethod.POST,"/cat/**").hasAnyAuthority("ROLE_USER")
               .antMatchers(HttpMethod.DELETE, "/user/**").hasAnyAuthority("ROLE_USER")
               .antMatchers(HttpMethod.POST,"/user/register").permitAll()
               .and().httpBasic()
               .and().cors().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
