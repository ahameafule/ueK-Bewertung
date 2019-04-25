/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.role;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ch.noseryoung.uekbewertung.data.DataGenerators;
import ch.noseryoung.uekbewertung.data.DataHolder;

/**
 * @author lohse
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RoleServiceTest {

	@InjectMocks
	private RoleService roleService;
	
	@Mock
	private RoleRepository roleRepository;
	
	private DataHolder<Role> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Role.class).generate();
	}
	
	@Test
	public void findById_idExists_returnsRole() {
		
		Role role = dataHolder.first();
		when(roleRepository.findById(role.getId())).thenReturn(Optional.of(role));
		
		assertThat(roleService.findById(role.getId()))
		.isPresent()
		.contains(role);
	}
	
	@Test
	public void findById_idDoesNotExist_returnsRole() {
		
		assertThat(roleService.findById(1312L)).isEmpty();
	}
}
