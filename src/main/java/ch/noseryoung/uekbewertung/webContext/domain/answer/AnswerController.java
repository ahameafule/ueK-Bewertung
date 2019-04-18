package ch.noseryoung.uekbewertung.webContext.domain.answer;

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

import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * This class holds all REST endpoints targeted towards the entity answer.
 * 
 * @author Joel Ahameafule
 *
 */
@RestController
@RequestMapping("/answers")
@Api(
		value = "AnswerController"
	)
public class AnswerController {

	private AnswerService answerService;
	
	@Autowired
	public AnswerController(AnswerService service) {
		this.answerService = service;
	}

	/**
	 * This method returns the requested answer
	 *
	 * @param  id Id of the requested answer
	 * @return    ResponseEntity with the answer that was requested
	 */
	@ApiOperation(
			value = "This endpoint returns the requested answer",
			response = Answer.class
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
					value = "Id of requested answer",
					required = true
			) }
		)
	@PreAuthorize("hasAuthority('MANAGE')")
	@GetMapping("/{id}")
	public ResponseEntity<Answer> getById(@PathVariable Long id) {
		Optional<Answer> answer = answerService.findById(id);
		
		HttpStatus status = (answer.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(answer.get(), status);
	}
	
	@GetMapping("/getByRating")
	public ResponseEntity<List<Answer>> getByRating(@Valid @RequestBody Rating rating) {
		List<Answer> answers = answerService.findByRating(rating);

		return new ResponseEntity<>(answers, HttpStatus.OK);
	}

	/**
	 * This method returns all answers
	 *
	 * @return ResponseEntity with all existing answers
	 */
	@ApiOperation(
			value = "This endpoint returns all answers",
			response = Answer.class
		)
	@PreAuthorize("hasAuthority('MANAGE')")
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Answer>> getAll() {
		List<Answer> authorities = answerService.findAll();

		return new ResponseEntity<>(authorities, HttpStatus.OK);
	}

	@ApiOperation(
			value = "This endpoint creates a answer",
			response = Answer.class 
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The answer to be created",
				required = true
			) }
		)

	/**
	 * This method creates a answer
	 *
	 * @return ResponseEntity with the answer that was created
	 */
	@PostMapping({ "", "/" })
	public ResponseEntity<Answer> create(@Valid @RequestBody Answer answer) {
		answerService.save(answer);

		return new ResponseEntity<>(answer, HttpStatus.CREATED);
	}

	@PutMapping({ "", "/" })
	public ResponseEntity<Answer> update(@Valid @RequestBody Answer answer) {
		answerService.update(answer);

		return new ResponseEntity<>(answer, HttpStatus.OK);
	}

	/**
	 * This method deletes the requested answer
	 *
	 * @param  id Id of the answer that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
			value = "This endpoint deletes the requested answer",
			response = Answer.class
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
					value = "Id of requested answer",
					required = true
			) }
		)
	@PreAuthorize("hasAuthority('MANAGE')")
	@DeleteMapping({"", "/"})
	public ResponseEntity<Void> delete(@Valid @RequestBody Answer answer) {
		answerService.delete(answer);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
