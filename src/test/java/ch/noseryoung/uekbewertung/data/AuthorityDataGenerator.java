/**
 * 
 */
package ch.noseryoung.uekbewertung.data;

import ch.noseryoung.uekbewertung.webContext.domain.authority.Authority;

/**
 * This class puts data in the entity Authority
 * @author lohse
 *
 */
public class AuthorityDataGenerator implements DataGenerator<Authority> {

/*
 * Generates testdata in the entity Authority
 */
	@Override
	public DataHolder<Authority> generate() {
		
		return DataHolder.of(
				
				new Authority("Authority one"),
				new Authority("Authority two"),
				new Authority("Authority three")
			);
	}	
}
