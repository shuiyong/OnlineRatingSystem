package edu.baylor.ecs.softproj.model;

import java.util.Date;
import javax.persistence.*;

/**
 * This class represents the "Presentation" table in the database.
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Entity
@Table(name = "reviewassignment")
@AttributeOverride(name = "id", column = @Column(name = "reviewassignmentid"))
public class ReviewAssignment extends AbstractEntity {

    @Column(name = "lecturerrating")
    private Integer lecturerRating;

    @Column(name = "deadline")
    @Temporal(TemporalType.TIME)
    private Date deadline;
    
    @ManyToOne
    private User reviewer;

    
    public ReviewAssignment() {
    }

    public ReviewAssignment(Date deadline, User reviewer) {
        this.deadline = deadline;
        this.reviewer = reviewer;
    }

    public Integer getLecturerRating() {
        return lecturerRating;
    }

    public void setLecturerRating(Integer lecturerRating) {
        this.lecturerRating = lecturerRating;
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
    

}
