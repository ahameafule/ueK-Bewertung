package ch.noseryoung.uekbewertung.webContext.domain;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.webContext.domain.user.UserService;

/**
 * This class is responsible for deleting users after one year
 * @author lohse
 *
 */
@Service
public class BackgroundService {

	private UserService userService;
	
	@Autowired
	public BackgroundService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * the hole function is for deleting all users which are older than a year
	 */
	@Scheduled(fixedRate = 120_000)
	public void deleteOldUser() {
		/**
		 * Gives conditions when to delete a user
		 */
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR, -2);
		
		/**
		 * Has a list of all Users and check their creation date with the current date
		 * Deletes user if the conditions are so
		 */
		userService.deleteOldUsers(cal.getTime());
	}
}
