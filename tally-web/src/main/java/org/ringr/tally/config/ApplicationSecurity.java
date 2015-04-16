/**
 * 
 */
package org.ringr.tally.config;

import org.ringr.tally.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * @author ptzhuf
 *
 */
@EnableWebMvcSecurity
@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityProperties security;
	@Autowired
	private UserService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**").permitAll()
				.anyRequest().fullyAuthenticated().and().formLogin()
				.loginPage("/login").failureUrl("/login?error").permitAll();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		// auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		// 自定义 mongodb的user service
		auth.userDetailsService(userService);
		SSAuthenticationProvider authenticationProvider = new SSAuthenticationProvider();
		auth.authenticationProvider(authenticationProvider);
		authenticationProvider.setUserDetailsService(userService);
		authenticationProvider.setPasswordEncoder(new ShaPasswordEncoder());
	}

}