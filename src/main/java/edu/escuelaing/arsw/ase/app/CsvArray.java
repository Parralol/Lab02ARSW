package edu.escuelaing.arsw.ase.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvArray {
    static List<LinkedList<String>> records = new ArrayList<>();

    /**
     * Method made for processing csv files.
     * 
     * @param file file path
     * @return the records of the csv
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static List<LinkedList<String>> getCsv(String file) throws FileNotFoundException, IOException{

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(convertTo(values));
            }
        }
        records = organize(records);
        return records;
    }

    /**
     * Method made to convert from String[] to LinkedList<String>
     * @param a the array
     * @return
     */
    private static LinkedList<String> convertTo(String[] a){
        LinkedList<String> res = new LinkedList<>();
        for(int i =0;i<a.length;i++){
            res.add(a[i]);
        }
        return res;
    }

    /**
     * organices the ArrayList so that it's easier to process the data
     * @param a unorganized List of Lists
     * @return
     */
    private static List<LinkedList<String>> organize(List<LinkedList<String>> a){
        List<LinkedList<String>> response = new ArrayList<>();
        for(int i = 0; i<a.get(i).size(); i++){
            LinkedList<String> xd = new LinkedList<>();
            for(int j = 0; j<a.size(); j++){
                xd.add(a.get(j).get(i));
            }
            response.add(xd);
        }
        return response;
    }

}
