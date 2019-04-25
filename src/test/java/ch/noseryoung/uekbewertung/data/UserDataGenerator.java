package ch.noseryoung.uekbewertung.data;

import java.util.Date;

import ch.noseryoung.uekbewertung.webContext.domain.user.User;

class UserDataGenerator implements DataGenerator<User> {

	
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
