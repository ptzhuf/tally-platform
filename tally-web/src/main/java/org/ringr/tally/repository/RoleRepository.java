/**
 * 
 */
package org.ringr.tally.repository;

import org.ringr.tally.po.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ptzhuf
 *
 */
public interface RoleRepository extends CrudRepository<Role, String> {

	Role findByRolename(String rolename);

}
