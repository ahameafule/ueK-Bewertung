/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.user;

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
public class UserServiceTest {

	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	private DataHolder<User> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(User.class).generate();
	}
	
	@Test
	public void findById_idExists_returnsUser() {
		
		User user = dataHolder.first();
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        
        assertThat(userService.findById(user.getId()))
        .isPresent()
        .contains(user);
	}
	
	@Test
	public void findById_idDoesNotExist_returnsUser() {
		
		assertThat(userService.findById(1312L)).isEmpty();
	}
}
