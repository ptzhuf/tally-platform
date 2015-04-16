/**
 * 
 */
package org.ringr.tally.config;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * spring security 的认证提供者 .
 * 
 * @author ptzhuf
 *
 */
@SuppressWarnings("deprecation")
public class SSAuthenticationProvider extends DaoAuthenticationProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.authentication.dao.DaoAuthenticationProvider
	 * #
	 * additionalAuthenticationChecks(org.springframework.security.core.userdetails
	 * .UserDetails, org.springframework.security.authentication.
	 * UsernamePasswordAuthenticationToken)
	 */
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		Object salt = null;

		if (getSaltSource() != null) {
			salt = getSaltSource().getSalt(userDetails);
		}

		if (authentication.getCredentials() == null) {
			logger.debug("Authentication failed: no credentials provided");

			throw new BadCredentialsException(messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials",
					"认证信息不能为空"));
		}

		String presentedPassword = authentication.getCredentials().toString();

		PasswordEncoder passwordEncoder = getPasswordEncoder();
		if (!passwordEncoder.isPasswordValid(userDetails.getPassword(),
				presentedPassword, salt)) {
			logger.debug("Authentication failed: 对应用户名的密码不正确");

			throw new BadCredentialsException(messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials",
					"认证失败"));
		}
	}

}
