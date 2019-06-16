// Parren Chen
// 2/23/19
// CSE142
// TA:  Ian Wohlers 
// Assignment #6
// import the java's ulti, io, awt packages
//
// This program reads the file of name sex combination's statistics since 
// the start year from the Social Security Administration, prompts user 
// for a combination and searches the file for data that draws a graph.
// It prints a not found message if the combination fail to be found.

import java.util.*;
import java.io.*;
import java.awt.*;

public class Names{
   
   //the number of total decades
   public static final int DECADES = 14;
   
   //the start year of data
   public static final int START_YEAR = 1880;
   
   //the width between each data in the graph
   public static final int WIDTH = 70;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("names.txt"));
      intro();
      String name = search(input);
      if (name != null){  //combination is found in data file
         DrawingPanel panel = new DrawingPanel(DECADES * WIDTH, 550);
         //the vertical size of the panel is set to be 550
         Graphics g = panel.getGraphics();
         graphFrame(g);
         pointMarker(g, name);
      }
   }
   
   //prints the introduction statements
   public static void intro() {
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social Security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since " + START_YEAR + ".");
      System.out.println();
   }
   
   //prompts the user for the name/sex combination
   // parameters needed:
   //       input = pass the Scanner of the file to the method
   //return the name/sex combination found, return null if not found
   public static String search(Scanner input){
      Scanner console = new Scanner(System.in);
      System.out.print("name? ");
      String name = console.next().toLowerCase();
      System.out.print("sex (M or F)? ");
      String gender = console.next().toLowerCase();
      while (input.hasNextLine()) {
         String search = input.nextLine();
         Scanner line = new Scanner(search);
         if (line.next().toLowerCase().equals(name) 
             && line.next().toLowerCase().equals(gender)){
            return search;
         }
      }
      System.out.println("name/sex combination not found");
      return null;
   }
   
   //draws the frame of the graph in DrawingPanel
   //  parameter needed:
   //     g = pass the Graphics of the DrawingPanel to the method
   // no return
   public static void graphFrame(Graphics g) {
      g.drawLine(0, 25, DECADES * WIDTH, 25);
      g.drawLine(0, 525, DECADES * WIDTH, 525);
      for (int i = 0; i <= DECADES - 1; i++){
         String str = String.valueOf(START_YEAR + 10 * i);
         g.drawLine(WIDTH * i, 0, WIDTH * i, 550);
         g.drawString(str, WIDTH * i, 550);
      }
   }
   
   //reads the line of the name/sex combination and graphs its stats
   //  parameters needed:
   //     g = pass the Graphics of the DrawingPanel to the method
   //  line = the line name/sex combination is found
   // no return
   public static void pointMarker(Graphics g, String line) {
      Scanner pointMarker = new Scanner(line);
      String currentName = pointMarker.next();
      String gender = pointMarker.next();
      int num1 = pointMarker.nextInt();;
      int num2 = num1;
      g.setColor(Color.RED);
      g.drawString(currentName + " " + gender + " " + num1, 0, 25 + modifier(num1) / 2);
      for(int i = 0; i < DECADES - 1; i++){
         num1 = pointMarker.nextInt();
         g.setColor(Color.RED);
         g.drawString(currentName + " " + gender + " " + num1, 
                     (i + 1) * WIDTH, 25 + modifier(num1) / 2);
         g.drawLine(i * WIDTH, 25 + modifier(num2) / 2, 
                   (i + 1) * WIDTH, 25 + modifier(num1) / 2);
         num2 = num1;
      }
   }
   
   //modifies the number to fit the DrawingPanel, changes the number to 1000 if it equals to 0
   //  parameter needed:
   //    num = the number needed to be modified
   // return the number after modification
   public static int modifier(int num) {
      if (num == 0) {
         num = 1000; //set the coordinate number to the bottom of the graph
      } else {   //num != 0
         num--;
      }
      return num;
   }
   
}