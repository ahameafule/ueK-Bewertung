package ch.noseryoung.uekbewertung.webContext.domain.answer;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * This class holds all REST endpoints targeted towards the entity answer.
 * 
 * @author Joel Ahameafule
 *
 */
@RestController
@RequestMapping("/answers")
public class AnswerController {

	private AnswerService answerService;
	
	@Autowired
	public AnswerController(AnswerService service) {
		this.answerService = service;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Answer> getById(@PathVariable Long id) {
		Optional<Answer> answer = answerService.findById(id);
		
		HttpStatus status = (answer.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(answer.get(), status);
	}

	@GetMapping({ "", "/" })
	public ResponseEntity<List<Answer>> getAll() {
		List<Answer> authorities = answerService.findAll();

		return new ResponseEntity<>(authorities, HttpStatus.OK);
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Answer> create(@Valid @RequestBody Answer answer) {
		answerService.save(answer);

		return new ResponseEntity<>(answer, HttpStatus.CREATED);
	}
/*
	@PutMapping("/{id}")
	public ResponseEntity<Answer> updateById(@PathVariable Long id, @Valid @RequestBody Answer answer) {
		answerService.update(answer, id);

		return new ResponseEntity<>(answer, HttpStatus.OK);
	}*/

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		answerService.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
