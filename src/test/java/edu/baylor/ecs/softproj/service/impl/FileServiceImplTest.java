package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.service.FileService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
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
public class FileServiceImplTest {
    
    String path = "softproj_test";
    String originalContent = "ahoj";
    
    @Autowired
    FileService fileService;
    
    @Test
    public void testSaveFile() {
        InputStream inputStream;
        try {
            inputStream = new ByteArrayInputStream(originalContent.getBytes("UTF-8"));
            fileService.saveFile(inputStream, path);
        } catch (Exception ex) {
            assert false;
        }
    }
    
    @Test
    public void testDownloadFile() {
        try {
            Scanner s = new Scanner(fileService.downloadFile(path));
            String content = s.nextLine();
            assertEquals(originalContent, content);
        } catch (Exception ex) {
            assert false;
        }
    }
    
}
