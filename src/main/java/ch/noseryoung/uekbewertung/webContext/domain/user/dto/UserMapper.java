/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.user.dto;

import java.util.List;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
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
	
	@Mappings({
		@Mapping(source = "user.firstName", target = "firstName"),
		@Mapping(source = "user.lastName", target = "lastName"),
		@Mapping(source = "user.email", target = "email"),
		@Mapping(source = "user.joinYear", target = "joinYear")
	})
	UserDTO userToUserDTO(User user);
	
	List<User> fromDTOs(List<UserDTO> userDtos);
	
	List<UserDTO> usersToUserDTOs(List<User> users);
}
