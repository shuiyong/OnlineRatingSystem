package edu.baylor.ecs.softproj.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This class represents membership of user in team.
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 */
@Table(name = "teammember")
@Entity
public class TeamMember extends AbstractEntity {

    @ManyToMany(mappedBy = "canBeViewedBy")
    private Set<Review> canView;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "teamMember")
    private Set<RPM> rpms;

    @OneToMany(mappedBy = "submitter")
    private Set<Artifact> submitterOf;

    @OneToMany(mappedBy = "reviewer")
    private Set<ReviewAssignment> reviewerOf;

    public TeamMember() {
    }

    public TeamMember(User user, Team team) {
        this.user = user;
        this.team = team;
    }

    public Set<Review> getCanView() {
        return canView;
    }

    public void setCanView(Set<Review> canView) {
        this.canView = canView;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Set<RPM> getRpms() {
        return rpms;
    }

    public void setRpms(Set<RPM> rpms) {
        this.rpms = rpms;
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
    
    public RPM getActiveRPM() {
        for(RPM rpm: getRpms()) {
            if (rpm.isActive()) {
                return rpm;
            }
        }
        
        return null;
    }

}
