/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.location;

import org.springframework.stereotype.Repository;

import ch.noseryoung.uekbewertung.config.generic.ExtendedJpaRepository;

/**
 * This interface holds all data access related methods targeted toward 
 * the entity location
 * 
 * @author lohse
 *
 */
@Repository 
public interface LocationRepository extends ExtendedJpaRepository<Location> {

}
