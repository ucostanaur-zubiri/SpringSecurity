package eus.hekuntza.zubiri.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(1)
public class SecurityPassEncoderConfig {
  
  @Bean
  public PasswordEncoder bCryptPasswordEncoder() {
      return new BCryptPasswordEncoder();
  }


}
