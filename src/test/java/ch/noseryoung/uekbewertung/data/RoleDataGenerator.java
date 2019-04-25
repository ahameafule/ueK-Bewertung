/**
 * 
 */
package ch.noseryoung.uekbewertung.data;

import ch.noseryoung.uekbewertung.webContext.domain.role.Role;

/**
 * @author lohse
 *
 */
public class RoleDataGenerator implements DataGenerator<Role>{

	@Override
	public DataHolder<Role> generate() {
		
		return DataHolder.of(
				
				new Role("trainer"),
				new Role("trainer"),
				new Role(null)
			);
	}
}
