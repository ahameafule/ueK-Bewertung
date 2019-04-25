/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.authority;

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
public class AuthorityServiceTest {

	@InjectMocks
	private AuthorityService authorityService;
	
	@Mock
	private AuthorityRepository authorityRepository;
	
	private DataHolder<Authority> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Authority.class).generate();
	}
	
	@Test
	public void findById_idExists_returnsAuthority() {
		
		Authority authority = dataHolder.first();
		when(authorityRepository.findById(authority.getId())).thenReturn(Optional.of(authority));
		
		assertThat(authorityService.findById(authority.getId()))
		.isPresent()
		.contains(authority);
	}
	
	@Test
	public void findById_idDoesNotExist_returnsAuthority() {
		
		assertThat(authorityService.findById(1312L)).isEmpty();
	}
}
