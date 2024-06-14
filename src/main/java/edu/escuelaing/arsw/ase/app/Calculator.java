package edu.escuelaing.arsw.ase.app;

public class Calculator {
    
    public static String mean(LinkedList<Double> data){
        Double res = 0.0;
        for(int i =0; i<data.size(); i++){
            res += data.get(i);
        }
        res = res/data.size();
        return res.toString();
    }
 
    public static String stdDeviation(LinkedList<Double> data){
        Double res = 0.0;

        Double mean = Double.valueOf(mean(data));
        int size = data.size();
        for(int i = 0 ; i< size; i++){
            res += Math.pow(data.get(i) - mean, 2);
        }
        return Double.toString( Math.sqrt(res / (size - 1)));
    }
}
