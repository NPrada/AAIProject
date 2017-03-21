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
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [AREA= " + country[0] + " , BFIHOST=" + country[1] + " , FARL= " + country[2] + " , FPEXT= " + country[3] + 
                        " ,  LDP= " + country[4] + " , PROPWET= " + country[5] +"]");
              
            }

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
