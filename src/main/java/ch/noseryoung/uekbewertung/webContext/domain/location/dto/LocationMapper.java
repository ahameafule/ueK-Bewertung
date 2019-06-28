/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.location.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uekbewertung.webContext.domain.location.Location;

/**
 * @author lohse
 *
 */
@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface LocationMapper {

	Location fromDTO(LocationDTO locationDto);
	
	LocationDTO toDTO(Location location);
	
	List<Location> fromDTOs(List<LocationDTO> locationDtos);
	
	List<LocationDTO> toDTOs(List<Location> locations);
}
