package io.security.basicsecurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.anyRequest().authenticated();

		http
				.formLogin();

		SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);


		// http
		// 		.logout()
		// 		.logoutUrl("/logout") // 원칙적으로 post 방식으로만 가능
		// 		.logoutSuccessUrl("/login")


				// .addLogoutHandler(new LogoutHandler() {
				// 	@Override
				// 	public void logout(HttpServletRequest request, HttpServletResponse response,
				// 					   Authentication authentication) {
				// 		HttpSession session = request.getSession();
				// 		session.invalidate();
				// 	}
				// })
				// .logoutSuccessHandler(new LogoutSuccessHandler() {
				// 	@Override
				// 	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
				// 								Authentication authentication) throws IOException, ServletException {
				// 		response.sendRedirect("/login");
				// 	}
				// })
				//.deleteCookies("remember-me"); // 삭제할 쿠키명
				//  .and()
				//  .rememberMe()
				// .rememberMeParameter("remember")
				// .tokenValiditySeconds(3600)
				// .userDetailsService(userDetailsService());


				//.loginPage("/loginPage") // 인증 받지 않아도 접근 가능
				// .defaultSuccessUrl("/")
				// .failureUrl("/login")
				// .usernameParameter("userId") //default: user name값 변경
				// .passwordParameter("passwd") // default: password name값 변경
				// .loginProcessingUrl("/login_proc")
				// .successHandler(new AuthenticationSuccessHandler() {
				// 	@Override
				// 	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
				// 										Authentication authentication) throws
				// 			IOException,
				// 			ServletException {
				// 		System.out.println("authentication" + authentication.getName());
				// 		response.sendRedirect("/");
				//
				// 	}
				// })
				// .failureHandler(new AuthenticationFailureHandler() {
				// 	@Override
				// 	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				// 										AuthenticationException exception) throws
				// 			IOException,
				// 			ServletException {
				// 		System.out.println("exception" + exception.getMessage());
				// 		response.sendRedirect("/login");
				// 	}
				// })
				// .permitAll();
		return http.build();
	}
}
