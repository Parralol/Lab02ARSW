package edu.escuelaing.arsw.ase.app;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class for calculating Mean and std. Dev 
 */
public final class App {

    static List<Path> allFiles = new ArrayList<>();
    static List<String> files = new ArrayList<>();

    static List<LinkedList<String>> data;
    static List<LinkedList<String>> resp = new ArrayList<>();

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
            if(con.toString().equals(args[0])){
                files.add(a.toString());
            }
        }
        if(files.size()>1) throw new Exception("There is more than 1 file with the same name");
        if( files.size()<1)throw new Exception("There is no more than 1 file with the same name");
        data = CsvArray.getCsv(files.get(0));
    }  

    @SuppressWarnings("rawtypes")
    private static List<LinkedList<Double>> convert(){
        List<LinkedList<Double>> resp = new ArrayList<>();
        for(LinkedList a: data){
            LinkedList<Double> resv = new LinkedList<>();
            for(int i = 1; i<a.size();i++){
                resv.add(Double.parseDouble((String)a.get(i)));
            }
            resp.add(resv);
        }
        return resp;
    }

    private static void prepareFiles() throws IOException{
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        String xd = System.getProperty("user.dir");
        Path rootPath = Paths.get(xd.split(":")[0] + ":", xd.split(":")[1]);
        allFiles = Lister.listAllFiles(rootPath, allFiles); 
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static void generateResponse(){
        List<LinkedList<Double>> respo =  convert();
        LinkedList<String> header = new LinkedList<>();
        header.add("Mean");
        header.add("Standard deviation");
        for(LinkedList a : respo){
            LinkedList<String> resv = new LinkedList<>();
            resp.add(header);
            resv.add(Calculator.mean(a));
            resv.add(Calculator.stdDeviation(a));
            resp.add(resv);
        }
        int count = 0;
        int it = 0;
        for(LinkedList a : resp){
            if(count %2 == 0){
                System.out.println("\n");
                System.out.println(data.get(it).get(0) );
                it +=1;
            }
            a.printList();   
            
            count +=1;
        }
    }
    /**
     *  Main method
     * @param args The arguments of the program.
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        prepareFiles();
        selectFiles(args);
        generateResponse();
        
    }

    
    
}
