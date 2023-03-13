package space.xnet.repotest;

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter


@Configuration
@EnableWebSecurity
class CustomWebSecurityConfigurerAdapter : WebSecurityConfigurerAdapter() {


  override fun configure(auth: AuthenticationManagerBuilder) {
    auth.inMemoryAuthentication()
        .withUser("admin")
        .password(passwordEncoder().encode("pass"))
        .roles("USER", "ADMIN")
        .and()
        .withUser("user")
        .password(passwordEncoder().encode("pass"))
        .roles("USER")
  }

  @Throws(Exception::class)
  override fun configure(http: HttpSecurity) {
    http.httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
        .and()
        .csrf().disable()
        .formLogin().disable()

    http.addFilterAfter(CustomFilter(), BasicAuthenticationFilter::class.java)
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return BCryptPasswordEncoder()
  }
}
