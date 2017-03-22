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
import java.util.Random;
/**
 *
 * @author Niccolo Prada
 */


public class AAIProject {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //start by initializong all the components that I need for the backprop 
        
        //set up all the arrows that will be needed for the ANN inluding the bias
        //the second parameter needs to be set up to take the input from the table
        //unless it is a bias arrow then the second parameter is always 1
        
        //hidden nodes
        Node w0_10 = new Node(calcRand(20,-10),1);  
        Node w0_11 = new Node(calcRand(20,-10),1);   
        Node w0_12 = new Node(calcRand(20,-10),1);  
        Node w0_13 = new Node(calcRand(20,-10),1);  
        Node w0_14 = new Node(calcRand(20,-10),1);                         
        //vectors  from inputs to each hidden node                                //for these the Ui is the input at their starting node    
        Node w1_10 = new Node(calcRand(20,0),1);                                
        Node w2_10 = new Node(calcRand(20,0),0);
        Node w3_10 = new Node(calcRand(20,0),1);   
        Node w4_10 = new Node(calcRand(20,0),1);   
        Node w5_10 = new Node(calcRand(20,0),1);   
        Node w6_10 = new Node(calcRand(20,0),1);   
        Node w7_10 = new Node(calcRand(20,0),1);   
        Node w8_10 = new Node(calcRand(20,0),1);   
        
        Node w1_11 = new Node(calcRand(20,0),1);                                
        Node w2_11 = new Node(calcRand(20,0),0);
        Node w3_11 = new Node(calcRand(20,0),1);   
        Node w4_11 = new Node(calcRand(20,0),1);   
        Node w5_11 = new Node(calcRand(20,0),1);   
        Node w6_11 = new Node(calcRand(20,0),1);   
        Node w7_11 = new Node(calcRand(20,0),1);   
        Node w8_11 = new Node(calcRand(20,0),1);
        
        Node w1_12 = new Node(calcRand(20,0),1);                                
        Node w2_12 = new Node(calcRand(20,0),0);
        Node w3_12 = new Node(calcRand(20,0),1);   
        Node w4_12 = new Node(calcRand(20,0),1);   
        Node w5_12 = new Node(calcRand(20,0),1);   
        Node w6_12 = new Node(calcRand(20,0),1);   
        Node w7_12 = new Node(calcRand(20,0),1);   
        Node w8_12 = new Node(calcRand(20,0),1);
        
        Node w1_13 = new Node(calcRand(20,0),1);                                
        Node w2_13 = new Node(calcRand(20,0),0);
        Node w3_13 = new Node(calcRand(20,0),1);   
        Node w4_13 = new Node(calcRand(20,0),1);   
        Node w5_13 = new Node(calcRand(20,0),1);   
        Node w6_13 = new Node(calcRand(20,0),1);   
        Node w7_13 = new Node(calcRand(20,0),1);   
        Node w8_13 = new Node(calcRand(20,0),1);
        
        Node w1_14 = new Node(calcRand(20,0),1);                                
        Node w2_14 = new Node(calcRand(20,0),0);
        Node w3_14 = new Node(calcRand(20,0),1);   
        Node w4_14 = new Node(calcRand(20,0),1);   
        Node w5_14 = new Node(calcRand(20,0),1);   
        Node w6_14 = new Node(calcRand(20,0),1);   
        Node w7_14 = new Node(calcRand(20,0),1);   
        Node w8_14 = new Node(calcRand(20,0),1);
        
        //vecors from hidden nodes to output node                               //for these the Ui needs to be calculated on the first forward pass hence the ui is 0
        Node w10_20 = new Node(calcRand(20,0),0);                                
        Node w11_20 = new Node(calcRand(20,0),0);
        Node w12_20 = new Node(calcRand(20,0),0);
        Node w13_20 = new Node(calcRand(20,0),0);
        Node w14_20 = new Node(calcRand(20,0),0);
        
        //output node weight
        Node w0_20 = new Node(calcRand(20,0),0);                                
        
        //start a for loop that will do the backpropagation process over and over
        for (int i = 0; i < 100; i++) {                                         //sets the inputs into an array
           
//            System.out.println("These are the current weights");
//            System.out.println(w0_3.weight);
//            System.out.println(w1_3.weight);
//            System.out.println(w2_3.weight);
//            System.out.println(w0_4.weight);
//            System.out.println(w1_4.weight);
//            System.out.println(w2_4.weight);
//            System.out.println(w0_5.weight);
//            System.out.println(w3_5.weight);
//            System.out.println(w4_5.weight);
            
            //generate weights for all the vectors to the output
            double node10Uj = calcNodeUj(w1_10.weight,w1_10.Ui,w2_10.weight,w2_10.Ui,w3_10.weight,w3_10.Ui,w4_10.weight,w4_10.Ui,w5_10.weight,w5_10.Ui,w6_10.weight,w6_10.Ui,w7_10.weight,w7_10.Ui,w8_10.weight,w8_10.Ui,  w0_10.weight);
            double node11Uj = calcNodeUj(w1_11.weight,w1_11.Ui,w2_11.weight,w2_11.Ui,w3_11.weight,w3_11.Ui,w4_11.weight,w4_11.Ui,w5_11.weight,w5_11.Ui,w6_11.weight,w6_11.Ui,w7_11.weight,w7_11.Ui,w8_11.weight,w8_11.Ui,  w0_11.weight);
            double node12Uj = calcNodeUj(w1_12.weight,w1_12.Ui,w2_12.weight,w2_12.Ui,w3_12.weight,w3_12.Ui,w4_12.weight,w4_12.Ui,w5_12.weight,w5_12.Ui,w6_12.weight,w6_12.Ui,w7_12.weight,w7_12.Ui,w8_12.weight,w8_12.Ui,  w0_12.weight);
            double node13Uj = calcNodeUj(w1_13.weight,w1_13.Ui,w2_13.weight,w2_13.Ui,w3_13.weight,w3_13.Ui,w4_13.weight,w4_13.Ui,w5_13.weight,w5_13.Ui,w6_13.weight,w6_13.Ui,w7_13.weight,w7_13.Ui,w8_13.weight,w8_13.Ui,  w0_13.weight);
            double node14Uj = calcNodeUj(w1_14.weight,w1_14.Ui,w2_14.weight,w2_14.Ui,w3_14.weight,w3_14.Ui,w4_14.weight,w4_14.Ui,w5_14.weight,w5_14.Ui,w6_14.weight,w6_14.Ui,w7_14.weight,w7_14.Ui,w8_14.weight,w8_14.Ui,  w0_14.weight);
            

            //set weights of all the vectors leaving that node eg node3Uj
            w10_20.setUi(node10Uj);
            w11_20.setUi(node10Uj); 
            w12_20.setUi(node10Uj); 
            w13_20.setUi(node10Uj); 
            w14_20.setUi(node10Uj); 
            
            //set the Ui of the outputnode
            double outputnodeUj = calcNodeUj(w10_20.weight,w10_20.Ui,w11_20.weight,w11_20.Ui,w12_20.weight,w12_20.Ui,w13_20.weight,w13_20.Ui,w14_20.weight,w14_20.Ui, w0_20.weight);
            w0_20.setUi(outputnodeUj);
            System.out.println("This the the ui: "+w0_20.Ui);

            //calculate delta for the output cell
            w0_20.setDelta(calcOutputDelta(w0_20.Ui,1));                          // the second parameter is what we want this ANN to train towards

            //calculate delta for node 3
            w0_10.setDelta(calcDelta(w10_20.Ui,w10_20.weight,w0_20.delta));
            w0_11.setDelta(calcDelta(w11_20.Ui,w11_20.weight,w0_20.delta));
            w0_12.setDelta(calcDelta(w12_20.Ui,w12_20.weight,w0_20.delta));
            w0_13.setDelta(calcDelta(w13_20.Ui,w13_20.weight,w0_20.delta));
            w0_14.setDelta(calcDelta(w14_20.Ui,w14_20.weight,w0_20.delta));

            //do the pass to update all the weights
            
            //hidden node's bias
            w0_10.setNewWeight(updateWeight(w0_10.weight,1,w0_10.delta));          //bias vecotrs have an Ui of 1
            w0_11.setNewWeight(updateWeight(w0_11.weight,1,w0_11.delta));
            w0_12.setNewWeight(updateWeight(w0_12.weight,1,w0_12.delta));
            w0_13.setNewWeight(updateWeight(w0_13.weight,1,w0_13.delta));
            w0_14.setNewWeight(updateWeight(w0_14.weight,1,w0_14.delta));
            
            //all the vectors to each node from all the inputs
            w1_10.setNewWeight(updateWeight(w1_10.weight,w1_10.Ui,w0_10.delta));
            w2_10.setNewWeight(updateWeight(w2_10.weight,w2_10.Ui,w0_10.delta));
            w3_10.setNewWeight(updateWeight(w3_10.weight,w3_10.Ui,w0_10.delta));
            w4_10.setNewWeight(updateWeight(w4_10.weight,w4_10.Ui,w0_10.delta));
            w5_10.setNewWeight(updateWeight(w5_10.weight,w5_10.Ui,w0_10.delta));
            w6_10.setNewWeight(updateWeight(w6_10.weight,w6_10.Ui,w0_10.delta));
            w7_10.setNewWeight(updateWeight(w7_10.weight,w7_10.Ui,w0_10.delta));
            w8_10.setNewWeight(updateWeight(w8_10.weight,w8_10.Ui,w0_10.delta));
            
            w1_11.setNewWeight(updateWeight(w1_11.weight,w1_11.Ui,w0_11.delta));
            w2_11.setNewWeight(updateWeight(w2_11.weight,w2_11.Ui,w0_11.delta));
            w3_11.setNewWeight(updateWeight(w3_11.weight,w3_11.Ui,w0_11.delta));
            w4_11.setNewWeight(updateWeight(w4_11.weight,w4_11.Ui,w0_11.delta));
            w5_11.setNewWeight(updateWeight(w5_11.weight,w5_11.Ui,w0_11.delta));
            w6_11.setNewWeight(updateWeight(w6_11.weight,w6_11.Ui,w0_11.delta));
            w7_11.setNewWeight(updateWeight(w7_11.weight,w7_11.Ui,w0_11.delta));
            w8_11.setNewWeight(updateWeight(w8_11.weight,w8_11.Ui,w0_11.delta));
            
            w1_12.setNewWeight(updateWeight(w1_12.weight,w1_12.Ui,w0_12.delta));
            w2_12.setNewWeight(updateWeight(w2_12.weight,w2_12.Ui,w0_12.delta));
            w3_12.setNewWeight(updateWeight(w3_12.weight,w3_12.Ui,w0_12.delta));
            w4_12.setNewWeight(updateWeight(w4_12.weight,w4_12.Ui,w0_12.delta));
            w5_12.setNewWeight(updateWeight(w5_12.weight,w5_12.Ui,w0_12.delta));
            w6_12.setNewWeight(updateWeight(w6_12.weight,w6_12.Ui,w0_12.delta));
            w7_12.setNewWeight(updateWeight(w7_12.weight,w7_12.Ui,w0_12.delta));
            w8_12.setNewWeight(updateWeight(w8_12.weight,w8_12.Ui,w0_12.delta));
            
            w1_13.setNewWeight(updateWeight(w1_13.weight,w1_13.Ui,w0_13.delta));
            w2_13.setNewWeight(updateWeight(w2_13.weight,w2_13.Ui,w0_13.delta));
            w3_13.setNewWeight(updateWeight(w3_13.weight,w3_13.Ui,w0_13.delta));
            w4_13.setNewWeight(updateWeight(w4_13.weight,w4_13.Ui,w0_13.delta));
            w5_13.setNewWeight(updateWeight(w5_13.weight,w5_13.Ui,w0_13.delta));
            w6_13.setNewWeight(updateWeight(w6_13.weight,w6_13.Ui,w0_13.delta));
            w7_13.setNewWeight(updateWeight(w7_13.weight,w7_13.Ui,w0_13.delta));
            w8_13.setNewWeight(updateWeight(w8_13.weight,w8_13.Ui,w0_13.delta));
            
            w1_14.setNewWeight(updateWeight(w1_14.weight,w1_14.Ui,w0_14.delta));
            w2_14.setNewWeight(updateWeight(w2_14.weight,w2_14.Ui,w0_14.delta));
            w3_14.setNewWeight(updateWeight(w3_14.weight,w3_14.Ui,w0_14.delta));
            w4_14.setNewWeight(updateWeight(w4_14.weight,w4_14.Ui,w0_14.delta));
            w5_14.setNewWeight(updateWeight(w5_14.weight,w5_14.Ui,w0_14.delta));
            w6_14.setNewWeight(updateWeight(w6_14.weight,w6_14.Ui,w0_14.delta));
            w7_14.setNewWeight(updateWeight(w7_14.weight,w7_14.Ui,w0_14.delta));
            w8_14.setNewWeight(updateWeight(w8_14.weight,w8_14.Ui,w0_14.delta));
          
            
            //vectors fromm hidden nodes to output
            w10_20.setNewWeight(updateWeight(w10_20.weight,w10_20.Ui,w0_20.delta));
            w11_20.setNewWeight(updateWeight(w11_20.weight,w11_20.Ui,w0_20.delta));
            w12_20.setNewWeight(updateWeight(w12_20.weight,w12_20.Ui,w0_20.delta));
            w13_20.setNewWeight(updateWeight(w13_20.weight,w13_20.Ui,w0_20.delta));
            w14_20.setNewWeight(updateWeight(w14_20.weight,w14_20.Ui,w0_20.delta));
            //output node
            w0_20.setNewWeight(updateWeight(w0_20.weight,1,w0_20.delta));       //middle parameter always stays 2 beceause this is a bias
        }
    }
    
    //This calculates the nodes detal depending on the Uj of the node and the desired output
    public static double updateWeight(double currentWeight, double Ui,double pointNodeDelta) {
        
        double newWeight = currentWeight + 0.1 * pointNodeDelta * Ui;
        return newWeight;
    }
    
    public static double calcDelta(double nodesUj, double linkWeight, double outputDelta){
        double S;
        double delta;
        
        S = nodesUj*(1-nodesUj);
        delta = (linkWeight * outputDelta) * S;
        
        return delta;
    
    }
    
    public static double calcOutputDelta(double nodesUj, double desiredOutput){
        double S;
        double delta;
        
        S = nodesUj*(1-nodesUj);
        delta = (desiredOutput - nodesUj) * S;
     
        return delta;
    
    }
    
    //this function requires the W1,2 then the Uj to be entered subsequently, 
    //tne the last value is the bias value of the node
    public static double calcNodeUj(double... w){                        
        double Sj =0; 
        double Uj;
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
    //this generates a random number for me, if parameters are max 10 and min -5
    //it will return numbers between 5 & -5
    public static double calcRand(int max,double min) {                 
                                                                    
        Random rand = new Random();
        double randNum = (rand.nextInt(max) + min);                                  
        return randNum;
        
    }
    
    public static void readCSV() {
        
        String csvFile = "CWDataStudent.csv";
        BufferedReader br = null;
        String line;
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
