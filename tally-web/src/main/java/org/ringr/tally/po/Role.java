/**
 * 
 */
package org.ringr.tally.po;

import org.springframework.data.annotation.Id;

/**
 * @author ptzhuf
 *
 */
public class Role {

	@Id
	private String id;

	private String rolename;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [rolename=");
		builder.append(rolename);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * @param rolename
	 *            the rolename to set
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
