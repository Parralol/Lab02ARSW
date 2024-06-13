package edu.escuelaing.arsw.ase.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class made to print out the lines of code without the comments and white lines
 */
public class Loc {
        private static boolean javadoc;
        private static Pattern jadoci = Pattern.compile("/\\\\*.*");
        private static Pattern jadocf = Pattern.compile(".*\\\\*/"); 
        private static Pattern comment = Pattern.compile("//.*"); 

        /**
         * Class made to process an entire file taking out the comments and saving it inside an Array of String
         * @param name
         * @return String[]
         */
        public static String[] calculate(String name){
            int count = 0;
            ArrayList<String> res = new ArrayList<>();
            String[] a = {};
            try{
                File file = new File(name);
                Scanner reader = new Scanner(file);
                while(reader.hasNextLine()){
                    String line = reader.nextLine();
                    if(!line.equals(""))
                    line = analize(line);
                    if(!javadoc){ 
                        if(line.trim().length() > 0){
                            count +=1;
                        }
                        res.add(line + count);
                    }
                }
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            res.add(Integer.toString(count));
            return res.toArray(a);
    }

    /**
     * Method responsible for analizing each line
     * @param line
     * @return String
     */ 
    private static String analize(String line){
        String[] salv = line.split(" ");
        String res = "";
        boolean commentb = false;
        for(int i = 0 ; i < salv.length; i++){
            String val = salv[i];
           if(jadoci.matcher(val).matches() && val.charAt(1)!= '/'){ 
                javadoc = true;
            }else if(jadocf.matcher(val).matches() && val.charAt(0)!= '/'){ 
                javadoc = false;
            }else if(comment.matcher(val).matches() || commentb){ 
                commentb = true;
                

            }else{
                res += val + " ";
            }
        }
        return res;
    }
}
