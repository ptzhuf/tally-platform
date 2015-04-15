/**
 * 
 */
package org.ringr.tally.service;

import org.ringr.tally.po.User;
import org.ringr.tally.po.Xiaofei;
import org.ringr.tally.repository.XiaofeiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消费.
 * 
 * @author ptzhuf
 *
 */
@Service
public class XiaofeiService {

	@Autowired
	private XiaofeiRepository xiaofeiRepository;

	/**
	 * 记录消费.
	 * 
	 * @param amount
	 *            金额
	 * @param addr
	 *            地点
	 * @param desc
	 *            消费内容
	 * @param time
	 *            时间
	 * @param user
	 *            用户
	 */
	public void save(Double amount, String addr, String desc, Long time,
			User user) {
		Xiaofei xiaofei = new Xiaofei();
		xiaofei.setAmount(amount);
		xiaofei.setAddr(addr);
		xiaofei.setDesc(desc);
		xiaofei.setTime(time);
		xiaofei.setUser(user);
		xiaofeiRepository.save(xiaofei);

	}

}
