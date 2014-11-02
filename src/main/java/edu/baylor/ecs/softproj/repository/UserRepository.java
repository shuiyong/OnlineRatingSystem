package edu.baylor.ecs.softproj.repository;

import edu.baylor.ecs.softproj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This repository is implemented by Spring Data.
 *
 * It provides persistent database operations on the "User" table
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}
