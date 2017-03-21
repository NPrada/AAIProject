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
        
        
        
        double nodebias[][];                                                    //initialize table containing the bias of each node second parameter is the total number of nodes including the input node      
        nodebias = new double[4][5];                                            //   /nodenumber/Sj/f(Sj)/node type/  0=input 1=hidden 2=output
        double weights[][];                                                    //initialize table containing the bias of each node second parameter is the total number of nodes including the input node      
        nodebias = new double[4][5];
        
        
        
        Node w0_3 = new Node(1,1);                                              //set up all the lines that will be needed for the system
        Node w1_3 = new Node(3,1);
        Node w2_3 = new Node(4,0);
        Node w0_4 = new Node(-6,1);
        Node w1_4 = new Node(6,1);
        Node w2_4 = new Node(5,0);
        
        //calculate the f(Sj) of node 0_3
        double node3Sj;
        node3Sj = w1_3.weight * w1_3.Ui + w2_3.weight * w2_3.Ui + w0_3.weight;    // this is Sj
        double node3fSj;
        node3fSj = 1/(1+Math.pow(Math.E,-node3Sj));
        
        //calculate the f(Sj) of node 0_4
        double node4Sj;
        node4Sj = w1_4.weight * w1_4.Ui + w2_4.weight * w2_4.Ui + w0_4.weight;    // this is Sj
        double node4fSj;
        node4fSj = 1/(1+Math.pow(Math.E,-node4Sj));
        
        
        Node w0_5 = new Node(-3.92,1);                                          //output node
        Node w3_5 = new Node(2,0.9820);                                         //output node weights
        Node w4_5 = new Node(4,0.5);
        
        
        
        
        
        System.out.println(calcHiddenNodeUj(w1_3.weight , w1_3.Ui , w2_3.weight , w2_3.Ui , w0_3.weight));
        
//        System.out.println(w1_3.weight);
        System.out.println(node3fSj);
//        System.out.println(node4fSj);
        
    }
    
//    public static void calcHiddenNodeUj(double w1weig, double w1Ui){
//        int x;
//        x = w1weig;
//    }
    public static double calcHiddenNodeUj(double... w){
        double Sj =0; 
        double Uj = 0;
        double inputs[];
        inputs = new double [50];
        int i = 0;
        
        for (double arg : w) {                                                  //sets the inputs into an array
            inputs[i] = arg;
            
            i++;
        }
        
        for (int x = 0; x < i-1; x++){                                          //adds up the differnt w1_3.weight * w1_3.Ui
            if ( (x & 1) == 0 ) { 
            //even
            Sj = Sj + inputs[x]*inputs[x+1];
        
            }}
        Sj = Sj + inputs[i-1];                                                  //adds the bias of the node then Sj is done being calculated
        Uj = 1/(1+Math.pow(Math.E,-Sj));
        return Uj;
    }
    
    
    
    public static void readCSV() {
        
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
