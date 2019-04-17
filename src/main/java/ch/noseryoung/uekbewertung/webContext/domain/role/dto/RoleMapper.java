/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.role.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uekbewertung.webContext.domain.role.Role;

/**
 * @author lohse
 *
 */
@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface RoleMapper {

	Role fromDTO(RoleDTO roleDto);
	
	RoleDTO toDTO(Role role);
	
	List<Role> fromDTOs(List<RoleDTO> roleDtos);
	
	List<RoleDTO> toDTOs(List<Role> roles);
}
