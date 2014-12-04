package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.RPM;
import edu.baylor.ecs.softproj.model.RPMAssignment;
import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.model.TeamMember;
import edu.baylor.ecs.softproj.repository.ArtifactRepository;
import edu.baylor.ecs.softproj.repository.RPMAssignmentRepository;
import edu.baylor.ecs.softproj.repository.ReviewAssignmentRepository;
import edu.baylor.ecs.softproj.repository.TeamMemberRepository;
import edu.baylor.ecs.softproj.repository.TeamRepository;
import edu.baylor.ecs.softproj.service.ArtifactService;
import java.util.Date;
import java.util.HashSet;
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
public class ArtifactServiceImplTest {
    
    @Autowired
    ArtifactService artifactService;
    
    @Autowired
    RPMAssignmentRepository rpmAssignmentRepository;
    
    @Autowired
    TeamMemberRepository teamMemberRepository;
    
    @Autowired
    ArtifactRepository artifactRepository;
    
    @Autowired
    ReviewAssignmentRepository reviewAssignmentRepository;
    
    @Autowired
    TeamRepository teamRepository;
    
    @Test
    public void testAssignArtifact() {
        RPMAssignment rpmAssignment = new RPMAssignment();
        rpmAssignmentRepository.save(rpmAssignment);
        TeamMember teamMember = new TeamMember();
        teamMemberRepository.save(teamMember);
        artifactService.assgnArtifact(rpmAssignment, teamMember, new Date());
        assertEquals(1, reviewAssignmentRepository.findAll().size());
    }
    
    @Test
    public void testFindById() {
        Artifact a1 = new Artifact();
        a1.setName("ahoj");
        a1.setFilePath("blabla");
        artifactRepository.save(a1);
        Artifact a2 = artifactService.findById(a1.getId());
        assertEquals(a1.getName(), a2.getName());
    }
    
    @Test
    public void testGetAssignment() {
        TeamMember teamMember = new TeamMember();
        teamMemberRepository.save(teamMember);
        Artifact a1 = new Artifact();
        a1.setName("ahoj");
        a1.setFilePath("blabla");
        artifactRepository.save(a1);
        RPMAssignment rpmAssignment = new RPMAssignment();
        rpmAssignment.setArtifact(a1);
        rpmAssignmentRepository.save(rpmAssignment);
        ReviewAssignment reviewAssignment1 = new ReviewAssignment();
        reviewAssignment1.setDeadline(new Date());
        reviewAssignment1.setReviewer(teamMember);
        reviewAssignment1.setRpmAssignment(rpmAssignment);
        reviewAssignment1.setLecturerToReviewRating(123);
        reviewAssignmentRepository.save(reviewAssignment1);
        ReviewAssignment reviewAssignment2 = artifactService.getAssignment(teamMember, a1.getId());
        assertEquals(reviewAssignment1.getLecturerToReviewRating(), reviewAssignment2.getLecturerToReviewRating());
    }
    
    @Test
    public void testgetFilePath() {
        Artifact a1 = new Artifact();
        a1.setName("ahoj");
        a1.setFilePath("blabla");
        artifactRepository.save(a1);
        String path = artifactService.getFilePath(a1.getId());
        assertEquals(a1.getFilePath(), path);
    }
    
    @Test
    public void testCreate() {
        Team team = new Team();
        team.setArtifacts(new HashSet<Artifact>());
        team.setRpm(new HashSet<RPM>());
        teamRepository.save(team);
        TeamMember teamMember = new TeamMember();
        teamMember.setTeam(team);
        teamMember.setSubmitterOf(new HashSet<Artifact>());
        teamMember = teamMemberRepository.save(teamMember);
        artifactService.create("lejno", "lejno", teamMember);
        Artifact a = artifactRepository.findAll().iterator().next();
        assertEquals("lejno", a.getFilePath());
    }

}
