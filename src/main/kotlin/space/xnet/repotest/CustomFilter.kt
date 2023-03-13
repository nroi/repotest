package space.xnet.repotest;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

class CustomFilter : GenericFilterBean() {

  override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
    chain.doFilter(request, response);
  }

}
