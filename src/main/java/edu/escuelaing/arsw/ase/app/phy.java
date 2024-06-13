package edu.escuelaing.arsw.ase.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class made to deliver a entire file 
 */
public class Phy {
    /**
     * Method made to save a entire file as an array of string
     * @param name
     * @return String[]
     */
    public static String[] calculate(String name){
        ArrayList<String> res = new ArrayList<>();
        String[] a = {};
        int count = 0;
        try{
            File file = new File(name);
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                count +=1;
                res.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        res.add(Integer.toString(count));
        return res.toArray(a);
    }
}
