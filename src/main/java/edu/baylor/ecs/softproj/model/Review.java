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
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
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
    @JoinColumn(name = "review_assignment_id")
    private ReviewAssignment reviewAssignment;

    @ManyToMany
    @JoinTable(
        name="view_permission",
        joinColumns=@JoinColumn(name="review_id"),
        inverseJoinColumns=@JoinColumn(name="teammember_id")
    )
    private Set<TeamMember> canBeViewedBy;

    public Review() {
    }

    public Review(String content, ReviewAssignment reviewAssignment, Integer rating) {
        this.content = content;
        this.reviewAssignment = reviewAssignment;
        this.reviewerToArtifactRating = rating;
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

    public Set<TeamMember> getCanBeViewdBy() {
        return canBeViewedBy;
    }

    public void setCanBeViewdBy(Set<TeamMember> canBeViewdBy) {
        this.canBeViewedBy = canBeViewdBy;
    }

}
