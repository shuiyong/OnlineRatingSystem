/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.service;
import  edu.baylor.ecs.softproj.model.Artifact;
import  edu.baylor.ecs.softproj.model.User;
/**
 *
 * @author yong shui <yong_shui@baylor.edu>
 */
public interface ArtifactService {
    public void submitArtifact(Artifact artfiact);
    public void assgnArtifact();
    public void getResult(Artifact artfiact);
    public void rateArtifact(Artifact artifact);
    public void getArtifacts(User user);
}
