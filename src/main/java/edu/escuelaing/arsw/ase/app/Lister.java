package edu.escuelaing.arsw.ase.app;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * class made to handle the entirety of directories in which the programm is working
 */
public class Lister {
    /**
     * Allows to list all files under certain directory
     * @param currentPath
     * @param allFiles
     * @return
     * @throws IOException
     */
    public static List<Path> listAllFiles(Path currentPath, List<Path> allFiles) throws IOException  
    { 
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(currentPath))  
        { 
            for (Path entry : stream) { 
                if (Files.isDirectory(entry)) { 
                    listAllFiles(entry, allFiles); 
                } else { 
                    allFiles.add(entry); 
                } 
            } 
        } 
        return allFiles;
    } 
}
