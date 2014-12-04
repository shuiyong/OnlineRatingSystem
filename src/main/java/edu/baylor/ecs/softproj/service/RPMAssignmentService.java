package edu.baylor.ecs.softproj.service;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.RPM;
import edu.baylor.ecs.softproj.model.RPMAssignment;

/**
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
public interface RPMAssignmentService {

    public RPMAssignment create(Artifact a, RPM rpm);
    public RPMAssignment update(RPMAssignment rpmAssignment);
    
    public RPMAssignment getByArtifactId(Integer id);
    public RPMAssignment getById(Integer id);

}
