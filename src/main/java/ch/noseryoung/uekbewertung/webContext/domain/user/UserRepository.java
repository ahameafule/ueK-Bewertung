package ch.noseryoung.uekbewertung.webContext.domain.user;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ch.noseryoung.uekbewertung.webContext.domain.role.Role;

/**
 * This interface holds all data access related methods targeted towards the
 * entity user.
 *
 * @author lohse
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	/**
	 * This method finds a User with a given name
	 *
	 * @param  name Descriptive name of User
	 * @return      Returns requested User with given descriptive name of User
	 */
	User findByLastName(String name);
	
	/**
	 * This method deletes the requested User with a given name
	 *
	 * @param name Descriptive name of User
	 */
	void deleteByLastName(String name);
	
	List<User> findAllByOrderByJoinYearDesc();
	
	List<User> findAllByRoles(Set<Role> roles);
}
