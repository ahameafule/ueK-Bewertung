package ch.noseryoung.uekbewertung.webContext.domain.role;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.webContext.domain.role.Role;
import ch.noseryoung.uekbewertung.webContext.domain.role.RoleRepository;

/**
 * This class implements all data access related methods targeted towards the
 * entity role.
 * 
 * @author Joel Ahameafule
 *
 */
@Service
public class RoleService {
	
	private RoleRepository roleRepository;

	/**
	 * @param roleRepository
	 */
	@Autowired
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	/**
	 * find role by the giving id
	 * @param id
	 * @return
	 */
	public Optional<Role> findById(Long id) {
		Optional<Role> role = roleRepository.findById(id);
		return role;
	}

	/**
	 * find all roles
	 * @return
	 */
	public List<Role> findAll() {
		List<Role> authorities = roleRepository.findAll();
		return authorities;
	}

	/**
	 * tells the repository where to create a role
	 * @param Role
	 */
	public void save(Role role) {
		roleRepository.save(role);
	}

	/**
	 * updates the givin role defined with id 
	 * @param newRole
	 * @param id
	 * @throws NoSuchElementException
	 */
	public void update(Role newRole, Long id) throws NoSuchElementException {
		Optional<Role> currentRole = roleRepository.findById(id);
		if (currentRole.isPresent()) {
			newRole.setId(id);
			roleRepository.save(newRole);
		} else {
			throw new NoSuchElementException(String.format("No role with given id '%d' found", id));
		}
	}

	/**
	 * Tells the repository where to delete the role
	 * @param id
	 */
	public void deleteById(Long id) {
		roleRepository.deleteById(id);
	}

}
