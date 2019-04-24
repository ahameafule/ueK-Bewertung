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
 * @author lohse
 *
 */
public class DataGenerators {

    public static <T> DataGenerator<T> forClass(Class<T> clazz) {
        return new DataGenerators().build(clazz);
    }

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

    private UserDataGenerator userGen() {
    	
    	return new UserDataGenerator();
    }
    
    private RoleDataGenerator roleGen() {
    	
    	return new RoleDataGenerator();
    }
    
    private RatingDataGenerator ratingGen() {
    	
    	return new RatingDataGenerator(userGen());
    }
    
    private QuestionDataGenerator questionGen() {
    	
    	return new QuestionDataGenerator();
    }
    
    private LocationDataGenerator locationGen() {
    	
    	return new LocationDataGenerator();
    }
    
    private CourseDataGenerator courseGen() {
    	
    	return new CourseDataGenerator(locationGen(), userGen());
    }
    
    private AuthorityDataGenerator authorityGen() {
    	
    	return new AuthorityDataGenerator();
    }
    
    private AnswerDataGenerator answerGen() {
    	
    	return new AnswerDataGenerator(ratingGen(), questionGen());
    }
}
