package edu.baylor.ecs.softproj.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
public interface FileService {
    
    public InputStream downloadFile(String path) throws IOException;
    public void saveFile(InputStream file, String path) throws IOException;
}
