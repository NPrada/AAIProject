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
        Node w0_3 = new Node(calcRand(20,-10),1);  
        Node w0_4 = new Node(calcRand(20,-10),1);                         
        //vectors  from inputs to each hidden node                                //for these the Ui is the input at their starting node    
        Node w1_3 = new Node(calcRand(20,0),1);                                
        Node w2_3 = new Node(calcRand(20,0),0);                              
        
        Node w1_4 = new Node(calcRand(20,0),1);
        Node w2_4 = new Node(calcRand(20,0),0);
        
        //vecors from hidden nodes to output node                               //for these the Ui needs to be calculated on the first forward pass hence the ui is 0
        Node w3_5 = new Node(calcRand(20,0),0);                                
        Node w4_5 = new Node(calcRand(20,0),0);
        
        //output node weight
        Node w0_5 = new Node(-20,0);                                
        
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
            double node3Uj = calcNodeUj(w1_3.weight , w1_3.Ui , w2_3.weight , w2_3.Ui , w0_3.weight);
            double node4Uj = calcNodeUj(w1_4.weight , w1_4.Ui , w2_4.weight , w2_4.Ui , w0_4.weight);

            //set weights of all the vectors leaving that node eg node3Uj
            w3_5.setUi(node3Uj); 
            
            w4_5.setUi(node4Uj); 
            
            //set the Ui of the outputnode
            double outputnodeUj = calcNodeUj(w3_5.weight , w3_5.Ui , w4_5.weight , w4_5.Ui , w0_5.weight);
            w0_5.setUi(outputnodeUj);
            System.out.println("This the the ui: "+w0_5.Ui);

            //calculate delta for the output cell
            w0_5.setDelta(calcOutputDelta(w0_5.Ui,1));                          // the second parameter is what it should be

            //calculate delta for node 3
            w0_3.setDelta(calcDelta(w3_5.Ui,w3_5.weight,w0_5.delta));

            //calculate delta for node 4
            w0_4.setDelta(calcDelta(w4_5.Ui,w4_5.weight,w0_5.delta));

            //do the pass to update all the weights
            
            //hidden node's bias
            w0_3.setNewWeight(updateWeight(w0_3.weight,1,w0_3.delta));          //bias vecotrs have an Ui of 1
            w0_4.setNewWeight(updateWeight(w0_4.weight,1,w0_4.delta));
            
            //all the vectors to each node from all the inputs
            w1_3.setNewWeight(updateWeight(w1_3.weight,w1_3.Ui,w0_3.delta));
            w2_3.setNewWeight(updateWeight(w2_3.weight,w2_3.Ui,w0_3.delta));

            w1_4.setNewWeight(updateWeight(w1_4.weight,w1_4.Ui,w0_4.delta));
            w2_4.setNewWeight(updateWeight(w2_4.weight,w2_4.Ui,w0_4.delta));
            
            //vectors fromm hidden nodes to output
            w3_5.setNewWeight(updateWeight(w3_5.weight,w3_5.Ui,w0_5.delta));
            w4_5.setNewWeight(updateWeight(w4_5.weight,w4_5.Ui,w0_5.delta));
            //output node
            w0_5.setNewWeight(updateWeight(w0_5.weight,1,w0_5.delta));
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
