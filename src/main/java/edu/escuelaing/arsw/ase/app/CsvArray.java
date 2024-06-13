package edu.escuelaing.arsw.ase.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvArray {
    static List<LinkedList<String>> records = new ArrayList<>();
    public static List<LinkedList<String>> getCsv(String file) throws FileNotFoundException, IOException{

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(convertTo(values));
            }
        }
        return records;
    }

    private static LinkedList<String> convertTo(String[] a){
        LinkedList<String> res = new LinkedList<>();
        for(int i =0;i<a.length;i++){
            res.add(a[i]);
        }
        return res;
    }
}
