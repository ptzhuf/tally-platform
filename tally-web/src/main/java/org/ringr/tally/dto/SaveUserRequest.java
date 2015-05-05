/**
 * 
 */
package org.ringr.tally.dto;

import java.util.List;

import org.ringr.tally.po.Role;

/**
 * @author asus
 *
 */
public class SaveUserRequest {
	private String username;
	private String password;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SaveUserRequest [username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", roles=");
		builder.append(roles);
		builder.append("]");
		return builder.toString();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	private List<Role> roles;
}
