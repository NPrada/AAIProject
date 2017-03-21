/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaiproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Nico
 */
public class AAIProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String csvFile = "CWDataStudent.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            
            for(int i = 0; i < 587; i++)  {                                     //chanage the 587 to you dataset length nad also on line 44
               
                line = br.readLine();                                           //reads the current line of the csv file
                String[] rawdata = line.split(cvsSplitBy);                      //System.out.println(line + "    //          " + i); debug stuff
                                                                                
                double trainingdata[][];
                trainingdata = new double[587][9];
                
                for(int x = 0; x < (trainingdata[i].length)-1; x++){            //loops through 9 times, or the number of headers and adds each number into the 
                    
                    trainingdata[i][x]=Double.parseDouble(rawdata[x]);
                   }
            }
            System.out.println("Your csv file has been read succesfully!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
