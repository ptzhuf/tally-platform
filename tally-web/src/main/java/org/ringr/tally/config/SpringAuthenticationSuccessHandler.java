/**
 * 
 */
package org.ringr.tally.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ringr.tally.po.User;
import org.ringr.tally.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author asus
 *
 */
@Component
public class SpringAuthenticationSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {

	@Autowired
	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.web.authentication.AuthenticationSuccessHandler
	 * #onAuthenticationSuccess(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// 保存当前用户到seesion中
		String username = authentication.getName();
		HttpSession session = request.getSession();
		// 从数据库查询用户. 理论上在 loadUserByName的时候已经查询过了....
		User user = userRepository.findByName(username);
		session.setAttribute("user", user);

		// 调用super的动作.
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
