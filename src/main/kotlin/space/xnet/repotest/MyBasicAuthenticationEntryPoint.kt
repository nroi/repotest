package space.xnet.repotest

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.io.PrintWriter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class MyBasicAuthenticationEntryPoint : BasicAuthenticationEntryPoint() {

  override fun commence(
      request: HttpServletRequest,
      response: HttpServletResponse,
      authException: AuthenticationException
  ) {
    response.addHeader("WWW-Authenticate", "Basic realm=\"$realmName\"")
    response.status = HttpServletResponse.SC_UNAUTHORIZED
    val writer: PrintWriter = response.writer
    writer.println("HTTP Status " + HttpServletResponse.SC_UNAUTHORIZED + " - " + authException.message)
  }

  override fun afterPropertiesSet() {
    realmName = "My Realm"
    super.afterPropertiesSet()
  }

}

