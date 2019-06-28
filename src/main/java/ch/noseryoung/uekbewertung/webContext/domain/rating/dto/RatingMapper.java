/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.rating.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;

/**
 * @author lohse
 *
 */
@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface RatingMapper {

	Rating fromDTO(RatingDTO ratingDto);
	
	RatingDTO toDTO(Rating rating);
	
	List<Rating> fromDTOs(List<RatingDTO> ratingDtos);
	
	List<RatingDTO> toDTOs(List<Rating> rating);
}
