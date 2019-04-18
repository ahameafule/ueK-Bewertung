package ch.noseryoung.uekbewertung.webContext.domain.question;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.noseryoung.uekbewertung.webContext.domain.question.Question;
import ch.noseryoung.uekbewertung.webContext.domain.question.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * This class holds all REST endpoints targeted towards the entity question.
 * 
 * @author Joel Ahameafule
 *
 */
@RestController
@RequestMapping("/questions")
@Api(
		value = "QuestionController"
	)
public class QuestionController {

	private QuestionService questionService;
	
	/**
	 * @param service
	 */
	@Autowired
	public QuestionController(QuestionService service) {
		this.questionService = service;
	}

	/**
	 * This method returns the requested question
	 * 
	 * @param id Id of the requested question
	 * @return ResponseEntity with the question that was requested
	 */
	@ApiOperation(
			value = "This endpoint returns the requested question",
			response = Question.class
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
					value = "Id of requested question",
					required = true
			) }
		)
	@GetMapping("/{id}")
	public ResponseEntity<Question> getById(@PathVariable Long id) {
		Optional<Question> question = questionService.findById(id);
		
		HttpStatus status = (question.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(question.get(), status);
	}

	/**
	 * This method returns all questions
	 * 
	 * @return
	 */
	@ApiOperation(
			value = "This endpoint returns all questions",
			response = Question.class
		)
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Question>> getAll() {
		List<Question> authorities = questionService.findAll();

		return new ResponseEntity<>(authorities, HttpStatus.OK);
	}

	/**
	 * This method creates a question
	 * 
	 * @return  ResponseEntity with the question that was created
	 */
	@ApiOperation(
			value = "This endpoint creates a question",
			response = Question.class 
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The question to be created",
				required = true
			) }
		)
	@PreAuthorize("hasAuthority('MANAGE')")
	@PostMapping({ "", "/" })
	public ResponseEntity<Question> create(@Valid @RequestBody Question question) {
		questionService.save(question);

		return new ResponseEntity<>(question, HttpStatus.CREATED);
	}

	/**
	 * This method updates the requested question
	 * 
	 * @param id Id of the question that should get updated
	 * @param question Question entity to which the requested question should get updated to
	 * @return ResponseEntity with the updated question
	 */
	@ApiOperation(
			value = "This endpoint updates the requested question",
			response = Question.class
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The logged in question",
				required = true
				) }
		)
	@PreAuthorize("hasAuthority('MANAGE')")
	@PutMapping("/{id}")
	public ResponseEntity<Question> updateById(@PathVariable Long id, @Valid @RequestBody Question question) {
		questionService.update(question, id);

		return new ResponseEntity<>(question, HttpStatus.OK);
	}

	/**
	 * This method deletes the requested question
	 * 
	 * @param id Id of the question that should be deleted
	 * @return ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
			value = "This endpoint deletes the requested question",
			response = Question.class
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
					value = "Id of requested question",
					required = true
			) }
		)
	@PreAuthorize("hasAuthority('MANAGE')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		questionService.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
