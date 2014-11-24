/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.web.bean;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.service.UserService;
import edu.baylor.ecs.softproj.service.ArtifactService;
import edu.baylor.ecs.softproj.service.FileService;
import edu.baylor.ecs.softproj.service.TeamService;
import edu.baylor.ecs.softproj.web.helper.FacesMessages;
import java.io.IOException;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Controller("submitartifactBean")
@Scope("request")
public class SubmitArtifact {
    
    @Autowired
    public ArtifactService artifactService;
    
    @Autowired
    public UserService userService;
    
    @Autowired
    public TeamService teamService;
    
    @Autowired
    public FileService fileService;
    
    private UploadedFile file;
    
    private String name;
    
    private int teamId;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
    
    public UploadedFile getFile() {
        return file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        if (file != null) {
            try {                
                String path = file.getFileName();
                fileService.saveFile(file.getInputstream(), path);
                Team team = teamService.getTeam(teamId);
                artifactService.create(name, path, team, userService.getCurrentUser());
                
                FacesMessages.addInfoMessage("Succesful: " + file.getFileName() + " is uploaded.");
            } catch (IOException ex) {
                FacesMessages.addInfoMessage("File upload failed.");
            }
        } else {
            FacesMessages.addInfoMessage("No file selected.");
        }
    }
}
