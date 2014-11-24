/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.service;
import  edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.RPMAssignment;
import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.model.TeamMember;
import java.util.Date;
/**
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author yong shui <yong_shui@baylor.edu>
 * @author  Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
public interface ArtifactService {
    
    public void assgnArtifact(RPMAssignment rpmAssignment, TeamMember u, Date deadline);
    
    public Artifact findById(Integer id);
    
    public ReviewAssignment getAssignment(TeamMember user, Integer ArtifactId);
    
    public String getFilePath(Integer artifactId);
    
    public boolean create(String name, String path, TeamMember submitter);
}
