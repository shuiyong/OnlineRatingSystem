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
    @JoinColumn(name = "reviewer_id")
    private TeamMember reviewer;

    @ManyToOne
    @JoinColumn(name = "rpm_assignment_id")
    private RPMAssignment rpmAssignment;

    @OneToMany(mappedBy = "reviewAssignment")
    private Set<Review> reviews;

    public ReviewAssignment() {
    }

    public ReviewAssignment(Date deadline, TeamMember reviewer, RPMAssignment rpmAssignment) {
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

    public TeamMember getReviewer() {
        return reviewer;
    }

    public void setReviewer(TeamMember reviewer) {
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
