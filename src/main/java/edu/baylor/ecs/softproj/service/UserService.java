package edu.baylor.ecs.softproj.service;
import java.util.List;
import java.util.Set;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.model.Course;

/**
 * Interface for the service layer providing operations with users.
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 * @author yong shui <yong_shui@baylor.edu>
 */
public interface UserService {

    public User create(String email, String password, String firstName, String lastName, Boolean isAdmin);

    /**
     * Returns a persistent user object with given id from the database.
     *
     * @param userId id of the user we are looking for
     * @return persistent user object with given id, or null if none is found
     */
    public User getById(Integer userId);

    public User getByEmail(String email);

    /**
     * Returns a persistent user object of a user that is currently logged on to
     * this session.
     *
     * @return persistent user object
     */
    public User getCurrentUser();
    
    /**
     * Changes password of a user.
     * 
     * @param u user to change the password of
     * @param newPlainPassword new password in plain form
     */
    public void changePassword(User u, String newPlainPassword);
    
    /**
     * Return a set of students candidates to create a team
     */
    public List<User> getStudents(User user);
    
    /**
     * Return the course a lecture have
     */
    public Set<Course> getCourse(User user);

}
