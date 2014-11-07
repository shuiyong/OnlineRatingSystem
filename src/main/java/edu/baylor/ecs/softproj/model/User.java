package edu.baylor.ecs.softproj.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * This class represents the "User" table in the database.
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 */
@Entity
public class User extends AbstractEntity {

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Boolean isAdmin;

    @ManyToMany(mappedBy = "canBeViewdBy")
    private Set<Review> canView;

    @ManyToMany(mappedBy = "teamMembers")
    private Set<Team> memeberOf;

    @OneToMany(mappedBy = "lecturer")
    private Set<Course> lecturerOf;

    @OneToMany(mappedBy = "rpm")
    private Set<Team> rpmOf;

    @OneToMany(mappedBy = "submitter")
    private Set<Artifact> submitterOf;

    @OneToMany(mappedBy = "reviewer")
    private Set<ReviewAssignment> reviewerOf;

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

    public Set<Review> getCanView() {
        return canView;
    }

    public void setCanView(Set<Review> canView) {
        this.canView = canView;
    }

    public Set<Team> getMemeberOf() {
        return memeberOf;
    }

    public void setMemeberOf(Set<Team> memeberOf) {
        this.memeberOf = memeberOf;
    }

    public Set<Course> getLecturerOf() {
        return lecturerOf;
    }

    public void setLecturerOf(Set<Course> lecturerOf) {
        this.lecturerOf = lecturerOf;
    }

    public Set<Team> getRpmOf() {
        return rpmOf;
    }

    public void setRpmOf(Set<Team> rpmOf) {
        this.rpmOf = rpmOf;
    }

    public Set<Artifact> getSubmitterOf() {
        return submitterOf;
    }

    public void setSubmitterOf(Set<Artifact> submitterOf) {
        this.submitterOf = submitterOf;
    }

    public Set<ReviewAssignment> getReviewerOf() {
        return reviewerOf;
    }

    public void setReviewerOf(Set<ReviewAssignment> reviewerOf) {
        this.reviewerOf = reviewerOf;
    }

}
