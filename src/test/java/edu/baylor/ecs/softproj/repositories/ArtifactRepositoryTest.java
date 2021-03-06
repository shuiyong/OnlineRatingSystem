package edu.baylor.ecs.softproj.repositories;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.repository.ArtifactRepository;
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
public class ArtifactRepositoryTest {
    
    @Autowired
    ArtifactRepository artifactRepository;
    
    @Test
    public void testFindAll() {
        Artifact artifact = new Artifact();
        artifact.setName("aaa");
        artifact.setFilePath("/etc/test");
        artifactRepository.save(artifact);
        int count = artifactRepository.findAll().size();
        assertEquals(1, count);
    }

}
