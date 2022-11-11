package eus.hekuntza.zubiri.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import eus.hekuntza.zubiri.security.services.AuthenticationProviderService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AuthenticationProviderService authenticationProvider;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) {
      auth.authenticationProvider(authenticationProvider);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
      
      /*
      http.formLogin().defaultSuccessUrl("/main", true);
      http.authorizeRequests()
        .mvcMatchers("/hello").permitAll()
        .mvcMatchers("/register").permitAll()
        .anyRequest().authenticated();
       */

      http.csrf().disable();
      http.authorizeRequests().anyRequest().permitAll()
        .and()
        .formLogin(
                form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/main")
                        .permitAll()
        ).logout(
                logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll()
  
        );
      
  }

}
