package edu.baylor.ecs.softproj.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author yong shui<yong_shui@baylor.edu>
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 */
@Entity
public class Review extends AbstractEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date submitted;

    private Integer reviewerToArtifactRating;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    private ReviewAssignment reviewAssignment;

    @ManyToMany
    @JoinTable(
        name="view_permission",
        joinColumns=@JoinColumn(name="review_id"),
        inverseJoinColumns=@JoinColumn(name="user_id")
    )
    private Set<User> canBeViewdBy;

    public Review() {
    }

    public Review(String content, ReviewAssignment reviewAssignment) {
        this.content = content;
        this.reviewAssignment = reviewAssignment;
    }

    @PrePersist
    protected void onCreate() {
        this.submitted = new Date();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSubmitted() {
        return submitted;
    }

    public Integer getReviewerToArtifactRating() {
        return reviewerToArtifactRating;
    }

    public void setReviewerToArtifactRating(Integer reviewerToArtifactRating) {
        this.reviewerToArtifactRating = reviewerToArtifactRating;
    }

    public ReviewAssignment getReviewAssignment() {
        return reviewAssignment;
    }

    public void setReviewAssignment(ReviewAssignment reviewAssignment) {
        this.reviewAssignment = reviewAssignment;
    }

    public Set<User> getCanBeViewdBy() {
        return canBeViewdBy;
    }

    public void setCanBeViewdBy(Set<User> canBeViewdBy) {
        this.canBeViewdBy = canBeViewdBy;
    }

}
