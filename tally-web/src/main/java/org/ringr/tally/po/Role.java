/**
 * 
 */
package org.ringr.tally.po;

/**
 * @author ptzhuf
 *
 */
public class Role {

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
