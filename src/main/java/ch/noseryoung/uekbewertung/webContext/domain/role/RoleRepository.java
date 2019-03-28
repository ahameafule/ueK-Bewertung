package ch.noseryoung.uekbewertung.webContext.domain.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity role.
 * 
 * @author Joel Ahameafule
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
