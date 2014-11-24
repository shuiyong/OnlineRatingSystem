package edu.baylor.ecs.softproj.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author yong shui <yong_shui@baylor.edu @author Petr Smrc
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Entity
public class RPMAssignment extends AbstractEntity {

    private Integer lecturerToRPMRating;

    private Integer RPMToArtifactRating;

    private String comment;

    @OneToMany(mappedBy = "rpmAssignment")
    private Set<ReviewAssignment> reviewAssignments;

    @ManyToOne
    @JoinColumn(name = "artifact_id")
    private Artifact artifact;
    
    @ManyToOne
    @JoinColumn(name = "rpm_id")
    private RPM rpm;

    public RPMAssignment() {
    }

    public RPMAssignment(Artifact artifact, RPM rpm) {
        this.rpm = rpm;
        this.artifact = artifact;
    }

    public RPM getRpm() {
        return rpm;
    }

    public void setRpm(RPM rpm) {
        this.rpm = rpm;
    }

    public Integer getLecturerToRPMRating() {
        return lecturerToRPMRating;
    }

    public void setLecturerToRPMRating(Integer lecturerToRPMRating) {
        this.lecturerToRPMRating = lecturerToRPMRating;
    }

    public Integer getRPMToArtifactRating() {
        return RPMToArtifactRating;
    }

    public void setRPMToArtifactRating(Integer RPMToArtifactRating) {
        this.RPMToArtifactRating = RPMToArtifactRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<ReviewAssignment> getReviewAssignments() {
        return reviewAssignments;
    }

    public void setReviewAssignments(Set<ReviewAssignment> reviewAssignments) {
        this.reviewAssignments = reviewAssignments;
    }

    public Artifact getArtifact() {
        return artifact;
    }

    public void setArtifact(Artifact artifact) {
        this.artifact = artifact;
    }
}
