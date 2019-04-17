/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.authority.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uekbewertung.webContext.domain.authority.Authority;

/**
 * @author lohse
 *
 */
@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AuthorityMapper {

	Authority fromDTO(AuthorityDTO authorityDto);
	
	AuthorityDTO toDTO(Authority authority);
	
	List<Authority> fromDTOs(List<AuthorityDTO> authorityDtos);
	
	List<AuthorityDTO> toDTOs(List<Authority> authorities);
}
