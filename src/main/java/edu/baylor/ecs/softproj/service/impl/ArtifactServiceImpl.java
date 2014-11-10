package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.RPMAssignment;
import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.repository.ArtifactRepository;
import edu.baylor.ecs.softproj.repository.RPMAssignmentRepository;
import edu.baylor.ecs.softproj.repository.ReviewAssignmentRepository;
import edu.baylor.ecs.softproj.service.ArtifactService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
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
    public void assgnArtifact(RPMAssignment rpmAssignment, User u, Date deadline) {
        reviewAssignmentRepository.save(new ReviewAssignment(deadline, u, rpmAssignment));
        rpmAssignmentRepository.save(rpmAssignment);
    }

    @Override
    public Artifact findById(Integer artifactId) {
        Artifact findOne = artifactRepository.findOne(artifactId);
        return findOne;
    }

}
