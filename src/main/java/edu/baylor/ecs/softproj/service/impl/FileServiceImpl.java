package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.service.FileService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Transactional
@Service("fileService")
public class FileServiceImpl implements FileService {

    public static final String PATH_TO_FILES = ""; 
    
    @Override
    public InputStream downloadFile(String path) throws IOException {
        return new FileInputStream(new File(PATH_TO_FILES + path));
    }

    @Override
    public void saveFile(InputStream file, String path) throws IOException {
        File f = new File(PATH_TO_FILES + path);
        OutputStream outputStream = new FileOutputStream(f);

        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = file.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
        }
    }
    
    
}
