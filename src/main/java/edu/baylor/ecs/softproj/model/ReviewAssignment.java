package edu.baylor.ecs.softproj.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 */
@Entity
public class ReviewAssignment extends AbstractEntity {

    private Integer lecturerToReviewRating;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date deadline;

    @ManyToOne
    private User reviewer;

    @ManyToOne
    private RPMAssignment rpmAssignment;

    @OneToMany(mappedBy = "reviewAssignment")
    private Set<Review> reviews;

    public ReviewAssignment() {
    }

    public ReviewAssignment(Date deadline, User reviewer, RPMAssignment rpmAssignment) {
        this.deadline = deadline;
        this.reviewer = reviewer;
        this.rpmAssignment = rpmAssignment;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public Integer getLecturerToReviewRating() {
        return lecturerToReviewRating;
    }

    public void setLecturerToReviewRating(Integer lecturerToReviewRating) {
        this.lecturerToReviewRating = lecturerToReviewRating;
    }

    public RPMAssignment getRpmAssignment() {
        return rpmAssignment;
    }

    public void setRpmAssignment(RPMAssignment rpmAssignment) {
        this.rpmAssignment = rpmAssignment;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

}
