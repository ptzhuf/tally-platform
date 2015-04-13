/**
 * 
 */
package org.ringr.tally.repository;

import org.ringr.tally.po.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ptzhuf
 *
 */
public interface UserRepository extends CrudRepository<User, String> {

	User findByName(String name);

}
