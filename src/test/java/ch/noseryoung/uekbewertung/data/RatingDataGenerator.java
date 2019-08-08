/**
 * 
 */
package ch.noseryoung.uekbewertung.data;

import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;

/**
 * This class puts data in the entity Rating
 * @author lohse
 *
 */
public class RatingDataGenerator implements DataGenerator<Rating>{

	private UserDataGenerator userGenerator;
	
	/**
	 * @param userGenerator
	 */
	public RatingDataGenerator(UserDataGenerator userGenerator) {
		this.userGenerator = userGenerator;
	}
	
/*
 * Generates testdata in the entity Question
 */
	@Override 
	public DataHolder<Rating> generate() {
		
		var user = userGenerator.generate();
		
		return DataHolder.of(
					
					new Rating("none", user.first(), "0A13AE725B99C8B54EFA46CA5C277C139371BF664F44A2AA9D8141110D18846F"),
					new Rating("something", user.second(), "0A13AE725B99C8B54EFA46CA5C277C139371BF664F44A2BA9D8141180D18846F"),
					new Rating("cool work", user.third(), "0A13AE725B99C8B54EFA46CA5C277C139371BF664F44A2AA9D8141180D18846G")
				);
	}
}
