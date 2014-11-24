/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.service;
import  edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.RPMAssignment;
import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.model.Team;
import  edu.baylor.ecs.softproj.model.User;
import java.util.Date;
import java.util.Set;
/**
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author yong shui <yong_shui@baylor.edu>
 * @author  Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
public interface ArtifactService {
    
    public void assgnArtifact(RPMAssignment rpmAssignment, User u, Date deadline);
    
    public Artifact findById(Integer id);
    
    public Set<Artifact> getArtifacts(User user);
    
    public ReviewAssignment getAssignment(User user, Integer ArtifactId);
    
    public String getFilePath(Integer artifactId);
    
    public boolean create(String name, String path, Team team, User submitter);
}
