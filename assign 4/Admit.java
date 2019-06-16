// Parren Chen
// 1/30/19
// CSE142
// TA:  Ian Wohlers 
// Assignment #4
//
// This program will compute the applicants score and compare their score
// import the java.util package for Math class and Scanner class
import java.util.*;

public class Admit{
   
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      intro();
      double score1 = getScore(console, 1);
      double score2 = getScore(console, 2);
      conclusion(score1, score2);
   }
   
   //print the intro statements 
   public static void intro() {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant.  For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
   }
   
   //prompt for applicants' academic information and calculate their overall score
   // parameters needed:
   //     console = pass the Scanner to the method
   //      number = the number for the applicant
   //return the overall score of the applicant
   public static double getScore(Scanner console, int number) {
      System.out.println("Information for applicant #" + number + ":");
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      int type = console.nextInt(); 
      double examScore;
      if (type == 1){
         examScore = satAnalyze(console);
      } else { //type == 2
         examScore = actAnalyze(console);
      }
      double gpaScore = gpaCalc(console);
      System.out.println("    GPA score = "+round1(gpaScore));
      System.out.println();
      double total = examScore + gpaScore;
      return total;
   }
   
   //calculate the exam score using the SAT score formula
   // parameters needed:
   //       math = the applicants SAT math score
   //    reading = the applicants SAT reading score
   //    writing = the applicants SAT writing score
   //return the SAT exam score
   public static double satForm(int math, int reading, int writing) {
      double result = (2 * math + reading + writing) / 32.0;
      return result;
   }
   
   //calculate the exam score using the ACT score formula
   // parameters needed:
   //    english = the applicants ACT English score
   //       math = the applicants ACT math score
   //    reading = the applicants ACT reading score
   //    science = the applicants ACT science score
   //return the ACT exam score
   public static double actForm(int english, int math, int reading, int science) {
      double result = (english + 2 * math + reading + science) / 1.8;
      return result;
   }
   
   //prompt for detailed SAT score information
   // parameters needed:
   //    console = pass the Scanner to the method
   //return the exam part of the overall score for SAT
   public static double satAnalyze(Scanner console) {
      System.out.print("    SAT math? ");
      int math = console.nextInt();
      System.out.print("    SAT critical reading? ");
      int reading = console.nextInt();
      System.out.print("    SAT writing? ");
      int writing = console.nextInt();
      double examScore = satForm(math, reading, writing);
      System.out.println("    exam score = " + round1(examScore));
      return examScore;
   }
   
   //prompt for detailed ACT score information 
   // parameters needed:
   //    console = pass the Scanner to the method
   //return the exam part of the overall score for ACT
   public static double actAnalyze(Scanner console) {
      System.out.print("    ACT English? ");
      int english = console.nextInt();
      System.out.print("    ACT math? ");
      int math = console.nextInt();
      System.out.print("    ACT reading? ");
      int reading = console.nextInt();
      System.out.print("    ACT science? ");
      int science = console.nextInt();
      double examScore = actForm(english, math, reading, science);
      System.out.println("    exam score = " + round1(examScore));
      return examScore;
   }
   
   //prompt for detailed GPA information
   // parameters needed:
   //    console = pass the Scanner to the method
   //return the gpa part of the overall score
   public static double gpaCalc(Scanner console) {
      System.out.print("    overall GPA? ");
      double gpa = console.nextDouble();
      System.out.print("    max GPA? ");
      double max = console.nextDouble();
      System.out.print("    Transcript Multiplier? ");
      double multi = console.nextDouble();
      return gpaForm(gpa, max, multi);
   }
   
   //calculate the GPA score using the GPA score formula
   // parameters needed:
   //    gpa = the applicant's current GPA
   //    max = the applicant's possible full GPA
   //  multi = the GPA score multiplier
   //return the GPA score
   public static double gpaForm(double gpa, double max, double multi) {
      double result = gpa / max * 100 * multi;
      return result;
   }
   
   //round a number to 1 digit after the decimal point
   // parameters needed:
   //  number = the number need to be round to one decimal place
   //return the rounded number
   public static double round1(double number) {
      return Math.round(number * 10.0) / 10.0;
   }   
   
   //print the overall result and conclusion for the applicants 
   // parameters needed:
   //  score1 = the first applicant's overall score
   //  score2 = the second applicant's overall  score
   public static void conclusion(double score1, double score2) {
      System.out.println("First applicant overall score  = " + round1(score1));
      System.out.println("Second applicant overall score = " + round1(score2));
      if (score1 > score2){
         System.out.print("The first applicant seems to be better");
      } else if (score1 < score2){
         System.out.print("The second applicant seems to be better");
      } else { //score1 == score 2   
         System.out.print("The two applicants seem to be equal");
      }
   }

}