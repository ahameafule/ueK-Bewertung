package ch.noseryoung.uekbewertung.webContext.domain.rating;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.webContext.domain.mailsending.MailSender;

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
	private MailSender sender;

	/**
	 * @param ratingRepository
	 */
	@Autowired
	public RatingService(RatingRepository ratingRepository, MailSender sender) {
		this.ratingRepository = ratingRepository;
		this.sender = sender;
	}

	/**
	 * find course by the giving id
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
		List<Rating> authorities = ratingRepository.findAll();
		return authorities;
	}

	/**
	 * tells mr. repository where to create a rating
	 * @param Course 
	 */
	public void save(Rating rating) {
		ratingRepository.save(rating);
		
		try {
			sender.sendEmail(rating.getUser().getEmail());
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * updates the givin rating defined with id 
	 * @param new Rating
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

	public void deleteById(Long id) {
		ratingRepository.deleteById(id);
	}
}
