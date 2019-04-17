/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.question.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uekbewertung.webContext.domain.question.Question;

/**
 * @author lohse
 *
 */
@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface QuestionMapper {

	Question fromDTO(QuestionDTO questionDto);
	
	QuestionDTO toDTO(Question question);
	
	List<Question> fromDTOs(List<QuestionDTO> questionDtos);
	
	List<QuestionDTO> toDTOs(List<Question> questions);
}
