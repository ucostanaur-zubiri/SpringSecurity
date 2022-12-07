package eus.hekuntza.zubiri.filters;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;

public class AuthenticationLogginFilter implements Filter {

  private final Logger logger = Logger.getLogger(AuthenticationLogginFilter.class.getName());

  @Autowired
  SecurityContext securityContext;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    if (securityContext != null) {
      logger.info("Successfully authenticated request with username " + securityContext.getAuthentication().getName());
    }
    chain.doFilter(request, response);
  }

}
