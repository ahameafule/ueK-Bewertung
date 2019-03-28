package ch.noseryoung.uekbewertung.config.generic;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface that extends JPARepository and implements all methods which
 * are common among the domain repositories
 *
 * @author Yves Kaufmann
 * @param T Entity to be used. Childclass of ExtendedEntity
 */
public interface ExtendedJpaRepository<T extends ExtendedEntity> extends JpaRepository<T, Long> {
	
}
