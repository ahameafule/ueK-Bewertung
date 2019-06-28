/**
 * 
 */
package ch.noseryoung.uekbewertung.data;

import ch.noseryoung.uekbewertung.webContext.domain.answer.Answer;
import ch.noseryoung.uekbewertung.webContext.domain.authority.Authority;
import ch.noseryoung.uekbewertung.webContext.domain.course.Course;
import ch.noseryoung.uekbewertung.webContext.domain.location.Location;
import ch.noseryoung.uekbewertung.webContext.domain.question.Question;
import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;
import ch.noseryoung.uekbewertung.webContext.domain.role.Role;
import ch.noseryoung.uekbewertung.webContext.domain.user.User;

/**
 * This class collects generators from all entities
 * @author lohse
 *
 */
public class DataGenerators {

	/**
	 * 
	 * @param clazz
	 * @return
	 */
    public static <T> DataGenerator<T> forClass(Class<T> clazz) {
        return new DataGenerators().build(clazz);
    }

    /**
     * 
     * @param clazz
     * @return DataGenerator<T> gen
     */
    public <T> DataGenerator<T> build(Class<T> clazz) {
        DataGenerator<?> gen;

        if (User.class.isAssignableFrom(clazz)) {
            gen = userGen();
        } else if(Role.class.isAssignableFrom(clazz)) {
        	gen = roleGen();
        } else if(Rating.class.isAssignableFrom(clazz)) {
        	gen = ratingGen();
        } else if(Question.class.isAssignableFrom(clazz)) {
        	gen = questionGen();
        } else if(Location.class.isAssignableFrom(clazz)) {
        	gen = locationGen();
        } else if(Course.class.isAssignableFrom(clazz)) {
        	gen = courseGen();
        } else if(Authority.class.isAssignableFrom(clazz)) {
        	gen = authorityGen();
        } else if(Answer.class.isAssignableFrom(clazz)) {
        	gen = answerGen();
        } else {
        		throw new RuntimeException();
        	}

        return (DataGenerator<T>) gen;
    }
/**
 * 
 * @return UserDataGenerator
 */
    private UserDataGenerator userGen() {
    	
    	return new UserDataGenerator();
    }
    
/**
 * 
 * @return RoleDataGenerator
 */
    private RoleDataGenerator roleGen() {
    	
    	return new RoleDataGenerator();
    }
    
	 /**
	  * 
	  * @return RatingDataGenerator + method userGen
	  */
    private RatingDataGenerator ratingGen() {
    	
    	return new RatingDataGenerator(userGen());
    }
    /**
     * 
     * @return QuestionDataGenerator
     */
    private QuestionDataGenerator questionGen() {
    	
    	return new QuestionDataGenerator();
    }
    /**
     * 
     * @return LocationDataGenerator
     */
    private LocationDataGenerator locationGen() {
    	
    	return new LocationDataGenerator();
    }
    /**
     * 
     * @return CourseDataGenerator + method locationGen + method userGen
     */
    private CourseDataGenerator courseGen() {
    	
    	return new CourseDataGenerator(locationGen(), userGen());
    }
    /**
     * 
     * @return AuthorityDataGenerator
     */
    private AuthorityDataGenerator authorityGen() {
    	
    	return new AuthorityDataGenerator();
    }
    /**
     * 
     * @return AnswerDataGenerator + method ratingGen + questionGen
     */
    private AnswerDataGenerator answerGen() {
    	
    	return new AnswerDataGenerator(ratingGen(), questionGen());
    }
}
