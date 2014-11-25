package edu.baylor.ecs.softproj.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 */
@Table(name = "rpm")
@Entity
public class RPM extends AbstractEntity {

    @OneToMany(mappedBy = "rpm")
    private Set<RPMAssignment> RPMAssignments;

    @ManyToOne
    @JoinColumn(name = "teammember_id")
    private TeamMember teamMember;
    
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    
    private boolean active;

    public RPM() {
    }

    public RPM(TeamMember teamMember, Team team) {
        this.teamMember = teamMember;
        this.team = team;
    }

    public Set<RPMAssignment> getRPMAssignments() {
        return RPMAssignments;
    }

    public void setRPMAssignments(Set<RPMAssignment> RPMAssignments) {
        this.RPMAssignments = RPMAssignments;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
}
