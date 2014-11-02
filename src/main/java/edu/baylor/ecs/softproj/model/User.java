package edu.baylor.ecs.softproj.model;

import javax.persistence.*;

/**
 * This class represents the "User" table in the database.
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Entity
@Table(name = "myuser")
@AttributeOverride(name = "id", column = @Column(name = "userId"))
public class User extends AbstractEntity {

    @Column(name = "email", length = 20, nullable = false)
    private String email;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "isadmin")
    private Boolean isAdmin;

    public User() {
    }

    public User(String email, String password, String firstName, String lastName, Boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
