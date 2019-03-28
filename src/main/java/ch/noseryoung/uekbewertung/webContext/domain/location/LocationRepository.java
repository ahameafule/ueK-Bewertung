/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * This interface holds all data access related methods targeted toward 
 * the entity location
 * 
 * @author lohse
 *
 */
@Repository 
public interface LocationRepository extends JpaRepository<Location, Long> {

}
