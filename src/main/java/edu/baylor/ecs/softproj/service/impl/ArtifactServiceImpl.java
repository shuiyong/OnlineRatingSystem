package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.RPMAssignment;
import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.model.TeamMember;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.repository.ArtifactRepository;
import edu.baylor.ecs.softproj.repository.RPMAssignmentRepository;
import edu.baylor.ecs.softproj.repository.ReviewAssignmentRepository;
import edu.baylor.ecs.softproj.service.ArtifactService;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 * @author Yong Shui <Yong_Shui@baylor.edu>
 */
@Transactional
@Service("artifactService")
public class ArtifactServiceImpl implements ArtifactService {
    
    @Autowired
    private ReviewAssignmentRepository reviewAssignmentRepository;
    
    @Autowired
    private RPMAssignmentRepository rpmAssignmentRepository;
    
    @Autowired
    private ArtifactRepository artifactRepository;

    @Override
    public void assgnArtifact(RPMAssignment rpmAssignment, TeamMember tm, Date deadline) {
        reviewAssignmentRepository.save(new ReviewAssignment(deadline, tm, rpmAssignment));
        rpmAssignmentRepository.save(rpmAssignment);
    }

    @Override
    public Artifact findById(Integer artifactId) {
        Artifact findOne = artifactRepository.findOne(artifactId);
        return findOne;
    }
    
    @Override
    public ReviewAssignment getAssignment(TeamMember user, Integer artifactId){
        Set<Artifact> result = new HashSet<Artifact>();
        Set<ReviewAssignment> ra = reviewAssignmentRepository.findByReviewer(user);
        for (ReviewAssignment reviewAssignment : ra) {
            if(reviewAssignment.getRpmAssignment().getArtifact().getId().equals(artifactId)){
                return reviewAssignment;
            }
        }
        return null;
    }
    
    @Override
    public String getFilePath(Integer artifactId){
        return artifactRepository.findOne(artifactId).getFilePath();
    }

    @Override
    public boolean create(String name, String path, TeamMember submitter) {
        Team team = submitter.getTeam();
        Artifact a = new Artifact(name, path, team, submitter);
        submitter.getSubmitterOf().add(a);
        team.getArtifacts().add(a);
        artifactRepository.save(a);
        return true;
    }
}
