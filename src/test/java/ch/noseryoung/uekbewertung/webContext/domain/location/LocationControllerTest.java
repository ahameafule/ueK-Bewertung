/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.location;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.noseryoung.uekbewertung.data.DataGenerators;
import ch.noseryoung.uekbewertung.data.DataHolder;
import ch.noseryoung.uekbewertung.webContext.domain.location.dto.LocationMapper;

/**
 * @author lohse
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = LocationController.class, includeFilters = {})
public class LocationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private LocationService locationService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private LocationMapper locationMapper;
	
	private DataHolder<Location> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Location.class).generate();
	}
	
	@Test
	public void test() throws Exception {
		
		when(locationService.findAll()).thenReturn(dataHolder.asList());
		
		var expectedJson = objectMapper.writeValueAsString(
				locationMapper.toDTOs(dataHolder.asList())
		);
		
        mockMvc.perform(get("/locations"))
        .andExpect(status().isOk())
        .andExpect(content().json(expectedJson));
	}
}
