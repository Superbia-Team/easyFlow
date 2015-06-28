package com.superbia.documentflow.config;

import com.superbia.documentflow.service.impl.DomainUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by dmorozov on 6/23/15.
 */
@Configuration
public class SecurityModule extends WebSecurityConfigurerAdapter {

  @Autowired
  private DomainUserDetailsService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers(
        "/resources/**",
        "/webjars/**"
    );
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .formLogin().and()
        .logout().and()
        .rememberMe().and()
        .authorizeRequests()
        .antMatchers("/", "/login", "/logout").permitAll()
        .anyRequest().authenticated();
  }
}
