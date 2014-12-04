package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.RPM;
import edu.baylor.ecs.softproj.model.RPMAssignment;
import edu.baylor.ecs.softproj.repository.RPMAssignmentRepository;
import edu.baylor.ecs.softproj.service.RPMAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Transactional
@Service("rpmAssignmentService")
public class RPMAssignmentServiceImpl implements RPMAssignmentService {
    
    @Autowired
    private RPMAssignmentRepository rpmAssignmentRepository;

    @Override
    public RPMAssignment create(Artifact a, RPM rpm) {
        return rpmAssignmentRepository.save(new RPMAssignment(a, rpm));
    }

    @Override
    public RPMAssignment getByArtifactId(Integer id) {
        return rpmAssignmentRepository.findByArtifactId(id);
    }

    @Override
    public RPMAssignment update(RPMAssignment rpmAssignment) {
        return rpmAssignmentRepository.save(rpmAssignment);
    }

    @Override
    public RPMAssignment getById(Integer id) {
        return rpmAssignmentRepository.findOne(id);
    }

    
}
