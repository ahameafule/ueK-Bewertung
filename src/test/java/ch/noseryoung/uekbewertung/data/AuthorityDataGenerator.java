/**
 * 
 */
package ch.noseryoung.uekbewertung.data;

import ch.noseryoung.uekbewertung.webContext.domain.authority.Authority;

/**
 * @author lohse
 *
 */
public class AuthorityDataGenerator implements DataGenerator<Authority> {

	@Override
	public DataHolder<Authority> generate() {
		
		return DataHolder.of(
				
				new Authority("Authority one"),
				new Authority("Authority two"),
				new Authority("Authority three")
			);
	}	
}
