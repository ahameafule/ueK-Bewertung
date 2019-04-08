package ch.noseryoung.uekbewertung.webContext.domain.rating;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.config.UUIDGenerator;
import ch.noseryoung.uekbewertung.webContext.domain.mailsending.MailSender;
import ch.noseryoung.uekbewertung.webContext.domain.user.User;
import ch.noseryoung.uekbewertung.webContext.domain.user.UserRepository;

/**
 * This class implements all data access related methods targeted towards the
 * entity rating.
 * 
 * @author Joel Ahameafule
 *
 */
@Service
public class RatingService {

	private RatingRepository ratingRepository;
	private UserRepository userRepository;
	private MailSender sender;

	/**
	 * @param ratingRepository
	 * @param sender
	 * @param userRepository
	 */
	@Autowired
	public RatingService(RatingRepository ratingRepository, MailSender sender, UserRepository userRepository) {
		this.ratingRepository = ratingRepository;
		this.userRepository = userRepository;
		this.sender = sender;
	}

	/**
	 * find rating by the giving id
	 * @param id
	 * @return
	 */
	public Optional<Rating> findById(Long id) {
		Optional<Rating> rating = ratingRepository.findById(id);
		return rating;
	}

	/**
	 * find all ratings
	 * @return
	 */
	public List<Rating> findAll() {
		List<Rating> ratings = ratingRepository.findAll();
		return ratings;
	}

	/**
	 * tells the repository where to create a rating
	 * @param Rating
	 * @param User
	 */
	public void save(Rating rating) {
		List<Rating> currentRating = ratingRepository.findByCourseAndUser(rating.getCourse(), rating.getUser());
	
		//Checks UUID
		if (currentRating.isEmpty()) {
			try {
				rating.setUUID(UUIDGenerator.generateUUID());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			ratingRepository.saveAndFlush(rating);
			
			//Checks email
			User userAdded = userRepository.findById(rating.getUser().getId()).get();
			
			try {
				sender.sendEmail(userAdded.getEmail());
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			throw new IllegalArgumentException("This rating already exists");
		}
	}

	/**
	 * updates the givin rating defined with id 
	 * @param newRating
	 * @param id
	 * @throws NoSuchElementException
	 */
	public void update(Rating newRating, Long id) throws NoSuchElementException {
		Optional<Rating> currentRating = ratingRepository.findById(id);
		if (currentRating.isPresent()) {
			newRating.setId(id);
			ratingRepository.save(newRating);
		} else {
			throw new NoSuchElementException(String.format("No rating with given id '%d' found", id));
		}
	}

	/**
	 * Tells the repository where to delete the rating
	 * @param id
	 */
	public void deleteById(Long id) {
		ratingRepository.deleteById(id);
	}
}
