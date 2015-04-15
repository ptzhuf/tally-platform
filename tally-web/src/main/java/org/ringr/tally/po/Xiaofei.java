/**
 * 
 */
package org.ringr.tally.po;

import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * @author ptzhuf
 *
 */
public class Xiaofei {

	private String id;
	private Double amount;
	private String addr;
	private String desc;
	@DBRef
	private User user;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr
	 *            the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the time
	 */
	public Long getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Long time) {
		this.time = time;
	}

	private Long time;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Xiaofei [id=");
		builder.append(id);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", addr=");
		builder.append(addr);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", user=");
		builder.append(user);
		builder.append(", time=");
		builder.append(time);
		builder.append("]");
		return builder.toString();
	}
}
