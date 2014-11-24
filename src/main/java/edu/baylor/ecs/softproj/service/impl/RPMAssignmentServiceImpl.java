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

    

}
