// Parren Chen
// 3/2/19
// CSE142
// TA:  Ian Wohlers 
// Assignment #7
// import the java's ulti, io packages
//
// This program reads the file of answers of the Keirsey Temperament Sorter
// personality test, calculates the occurence and percentage of these answers 
// in each of the 4 dimensions, and creates an output file of corresponding 
// personality type.

import java.util.*;
import java.io.*;

public class Personality{
   
   // the number of dimensions of the test
   public static final int DIMENSION = 4;

   public static void main(String[] args) throws FileNotFoundException {
      intro();
      Scanner console = new Scanner(System.in);
      String inputName =  input(console);
      String outputName =  output(console);
      Scanner input = new Scanner(new File(inputName));
      PrintStream output = new PrintStream(new File(outputName));
      int[] aCount = new int[DIMENSION];
      int[] bCount = new int[DIMENSION];
      int[] bPercent = new int[DIMENSION];
      while(input.hasNextLine()) {
         String nameLine = input.nextLine();
         String data = input.nextLine().toLowerCase();
         count(data, aCount, bCount);
         bPercent(aCount, bCount, bPercent);
         String personality = personality(bPercent);
         print(output, nameLine, bPercent, personality);
         reset(aCount, bCount);
      }
   }
   
   //prints the introduction statements
   public static void intro() {
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter.  It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   //prompts the user for the input file name
   // parameters needed:
   //    console = the input Scanner of the user
   //return the input file name to look for
   public static String input(Scanner console) {  
      System.out.print("input file name? ");
      return console.next();
   }
   
   //prompts the user for the output file name
   // parameters needed:
   //    console = the input Scanner of the user
   //return the output file name to create
   public static String output(Scanner console) {
      System.out.print("output file name? ");
      return console.next();
   }
   
   //uses the line of question answers to count the "a" and "b" occurence, 
   //and uses the number to set the count array value
   // parameters needed:
   //    data = the line of 70 answers to the peronality questions
   //  aCount = the array stores "a" occurence in each dimension
   //  bCount = the array stores "b" occurence in each dimension
   //no return
   public static void count(String data, int[] aCount, int[] bCount) {   
      for(int i = 0; i < 70; i++){     // the total questions of the test is 70
         if(data.charAt(i) == 'a'){
            aCount[(i % 7 + 1) / 2]++;
         } else if(data.charAt(i) == 'b'){
            bCount[(i % 7 + 1) / 2]++;   
         }
      }
   } 
   
   //calculate the occurence of answer "b"'s percentage in each dimension
   // parameters needed:
   //    aCount = the occurence of "a" in each dimension
   //    bCount = the occurence of "b" in each dimension
   //no return
   public static void bPercent(int[] aCount, int[] bCount, int[] bPercent){
      for(int i = 0; i < DIMENSION; i++){
         int sum = aCount[i] + bCount[i];
         double percentage = bCount[i] * 100.0 / sum;
         int percent = (int) Math.round(percentage);
         bPercent[i] = percent;
      }
   }
   
   //uses the skewness of "b" in each dimension to report the tester's personality
   // parameters needed:
   //    bPercent = the percentage of "b"'s occurence in each dimension
   //return String of the personality type
   public static String personality(int[] bPercent){    
      String personality = new String();
      //all possible personality type
      String[] type = {"E", "I", "S", "N", "T", "F", "J", "P"}; 
      for(int i = 0; i < DIMENSION; i++){
         if(bPercent[i] < 50){  
            personality += type[i * 2];
         } else if (bPercent[i] > 50){ 
            personality += type[i * 2 + 1];
         } else {   //bPercent[i] = 50
            personality += "X";
         }
      }
      return personality;
   }
   
   //prints the results to an output file of given name
   // parameters needed:
   //      output = the output file object
   //    nameLine = the name of the tester
   //    bPercent = the percentage of "b"'s occurence in each dimension
   // personality = the overall result of personality
   //no return
   public static void print(PrintStream output, String nameLine,
                            int[] bPercent, String personality){
      output.println(nameLine + ": " + Arrays.toString(bPercent) + " = " + personality);
   }
   
   //resets previous value of counts of "a" and "b" to 0
   // parameters needed:
   //    aCount = the occurence of "a" in each dimension
   //    bCount = the occurence of "b" in each dimension
   //no return
   public static void reset(int[] aCount, int[] bCount){
      for(int i = 0; i < DIMENSION; i++){
         aCount[i] = 0;
         bCount[i] = 0;
      }
   }
   
}