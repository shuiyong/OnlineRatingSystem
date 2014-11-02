package edu.baylor.ecs.softproj.service;

import edu.baylor.ecs.softproj.model.User;

/**
 * Interface for the service layer providing operations with users.
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
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

}
