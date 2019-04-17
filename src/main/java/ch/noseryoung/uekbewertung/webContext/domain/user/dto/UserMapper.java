/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.user.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uekbewertung.webContext.domain.user.User;

/**
 * @author lohse
 *
 */
@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

	User fromDTO(UserDTO userDto);
	
	UserDTO toDTO(User user);
	
	List<User> fromDTOs(List<UserDTO> userDtos);
	
	List<UserDTO> toDTOs(List<User> users);
}
