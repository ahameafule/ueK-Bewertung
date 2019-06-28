/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.answer.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uekbewertung.webContext.domain.answer.Answer;

/**
 * @author lohse
 *
 */
@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AnswerMapper {

	Answer fromDTO(AnswerDTO answerDto);
	
	AnswerDTO toDTO(Answer answer);
	
	List<Answer> fromDTOs(List<AnswerDTO> answerDtos);
	
	List<AnswerDTO> toDTOs(List<Answer> answers);
}
