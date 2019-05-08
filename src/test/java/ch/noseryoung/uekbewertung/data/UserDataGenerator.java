package ch.noseryoung.uekbewertung.data;

import java.util.Date;

import ch.noseryoung.uekbewertung.webContext.domain.user.User;

/**
 * This class puts data in the entity User
 * @author lohse
 *
 */
class UserDataGenerator implements DataGenerator<User> {

/*
 * Generates testdata in the entity Question
 */
	@SuppressWarnings("deprecation")
	@Override
	public DataHolder<User> generate() {
		
		return DataHolder.of(
				
				new User("james", "jone", new Date(1, 3, 2019), null),
				new User("charlie", "vietnamese", new Date(2, 4, 2019), null),
				new User("marlisa", "mouse", new Date(5,2,2019), null)
			);
	}
}
