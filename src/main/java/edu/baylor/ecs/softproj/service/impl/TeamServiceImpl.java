package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.repository.TeamRepository;
import edu.baylor.ecs.softproj.repository.UserRepository;
import edu.baylor.ecs.softproj.service.TeamService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Transactional
@Service("teamService")
public class TeamServiceImpl implements TeamService {
    
    @Autowired
    private TeamRepository teamRepository;

    

    

}
