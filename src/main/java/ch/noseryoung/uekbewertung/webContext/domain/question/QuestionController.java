package ch.noseryoung.uekbewertung.webContext.domain.question;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


/**
 * This class holds all REST endpoints targeted towards the entity question.
 * 
 * @author Joel Ahameafule
 *
 */
@RestController
@RequestMapping("/questions")
public class QuestionController {

	private QuestionService questionService;
	
	@Autowired
	public QuestionController(QuestionService service) {
		this.questionService = service;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Question> getById(@PathVariable Long id) {
		Optional<Question> question = questionService.findById(id);
		
		HttpStatus status = (question.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(question.get(), status);
	}

	@GetMapping({ "", "/" })
	public ResponseEntity<List<Question>> getAll() {
		List<Question> authorities = questionService.findAll();

		return new ResponseEntity<>(authorities, HttpStatus.OK);
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Question> create(@Valid @RequestBody Question question) {
		questionService.save(question);

		return new ResponseEntity<>(question, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Question> updateById(@PathVariable Long id, @Valid @RequestBody Question question) {
		questionService.update(question, id);

		return new ResponseEntity<>(question, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		questionService.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
