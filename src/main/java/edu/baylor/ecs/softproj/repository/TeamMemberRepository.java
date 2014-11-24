package edu.baylor.ecs.softproj.repository;

import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.model.TeamMember;
import edu.baylor.ecs.softproj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 */
public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer> {
    public TeamMember findByUserAndTeam(User user, Team team);
}
