package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.RPM;
import edu.baylor.ecs.softproj.model.RPMAssignment;
import edu.baylor.ecs.softproj.repository.ArtifactRepository;
import edu.baylor.ecs.softproj.repository.RPMAssignmentRepository;
import edu.baylor.ecs.softproj.repository.RPMRepository;
import edu.baylor.ecs.softproj.service.RPMAssignmentService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context-test.xml"})
public class RPMAssignmentServiceImplTest {
    
    @Autowired
    RPMAssignmentService rpmAssignmentService;
    
    @Autowired
    RPMAssignmentRepository rpmAssignmentRepository;
    
    @Autowired
    ArtifactRepository artifactRepository;
    
    @Autowired
    RPMRepository rpmRepository;

    @Test
    public void testCreate() {
        Artifact a = new Artifact();
        a.setName("name");
        a.setFilePath("path");
        artifactRepository.save(a);
        RPM rpm = new RPM();
        rpmRepository.save(rpm);
        rpmAssignmentService.create(a, rpm);
        assertEquals(1, rpmAssignmentRepository.findAll().size());
    }
    
    @Test
    public void testGetByArtifactId() {
        Artifact a = new Artifact();
        a.setName("name");
        a.setFilePath("path");
        artifactRepository.save(a);
        RPMAssignment rpma = new RPMAssignment();
        rpma.setArtifact(a);
        rpmAssignmentRepository.save(rpma);
        RPMAssignment rpma2 = rpmAssignmentService.getByArtifactId(a.getId());
        assertEquals(a.getName(), rpma2.getArtifact().getName());
    }
    
    @Test
    public void testUpdate() {
        RPMAssignment rpma = new RPMAssignment();
        rpma = rpmAssignmentRepository.save(rpma);
        rpma = rpmAssignmentRepository.findOne(rpma.getId());
        rpma.setComment("comment");
        RPMAssignment rpma2 = rpmAssignmentService.update(rpma);
        assertEquals(rpma.getComment(), rpma2.getComment());
    }
    
    @Test
    public void testGetById() {
        RPMAssignment rpma = new RPMAssignment();
        rpma.setComment("comment");
        rpma = rpmAssignmentRepository.save(rpma);
        RPMAssignment rpma2 = rpmAssignmentService.getById(rpma.getId());
        assertEquals(rpma.getComment(), rpma2.getComment());
    }
    
}
