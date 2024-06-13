package edu.escuelaing.arsw.ase.app;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main class for LOC counting program
 */
public final class App {
    static List<Path> allFiles = new ArrayList<>();
    static List<String> files = new ArrayList<>();
    static String[] res = {};
    /**
     * Empty constructor for app class
     */
    private App() {
    }

    /**
     * Selects files in the current directory
     * @param args
     * @throws Exception
     */
    public static void selectFiles(String[] args) throws Exception{

        for(Path a : allFiles){
            Path con = a.getFileName();
            if(con.toString().equals(args[1])){
                files.add(a.toString());
            }
        }
        if(files.size()>1) throw new Exception("There is more than 1 file with the same name");
        if( files.size()<1)throw new Exception("There is no more than 1 file with the same name");
        if(args[0].equals("phy")){
            res = Phy.calculate(files.get(0));
        }else if(args[0].equals("loc")){
            res = Loc.calculate(files.get(0));
        }else{
            throw new Exception("Argument error, should be \"phy\" or \"loc\" ");
        }
    }  

    /**
     *  Main method
     * @param args The arguments of the program.
     * @throws Exception 
     */
    @SuppressWarnings({ "rawtypes"})
    public static void main(String[] args) throws Exception {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        String xd = System.getProperty("user.dir");
        Path rootPath = Paths.get(xd.split(":")[0] + ":", xd.split(":")[1]);
        allFiles = Lister.listAllFiles(rootPath, allFiles); 

        selectFiles(args);
        
        //System.out.println("Found files:"); 
        //allFiles.forEach(System.out::println); 

        //System.out.println("Found corresponding files:"); 
        files.forEach(System.out::println); 

        List resp = Arrays.asList(res);
        
            System.out.println("Lines of code found: " + resp.get(resp.size()-1));
        
    }
}
