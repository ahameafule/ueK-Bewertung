/**
 * 
 */
package ch.noseryoung.uekbewertung.data;

import ch.noseryoung.uekbewertung.webContext.domain.role.Role;

/**
 * This class puts data in the entity Role
 * @author lohse
 *
 */
public class RoleDataGenerator implements DataGenerator<Role>{

/*
 * Generates testdata in the entity Role
 */
	@Override
	public DataHolder<Role> generate() {
		
		return DataHolder.of(
				
				new Role("trainer"),
				new Role("trainer"),
				new Role(null)
			);
	}
}
