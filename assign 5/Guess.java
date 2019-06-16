// Parren Chen
// 10/30/18
// CSE142
// TA:  Ian Wohlers 
// Assignment #5
// import the java.ulti package
//
// This program will be a guessing game.


import java.util.*;

public class Guess{
   
   public static final int MAX = 100;//the maximum number of the game

   public static void main(String[] args){
      intro(); //prints the introduction message
      Random rand = new Random();
      Scanner console = new Scanner(System.in);      
      int gameNum = 1; //initial game number
      int guess; //initial guess
      int min;
      int currentGuess;
      //play the game and update guess results and the random number
      guess = currentGuess = min = singleGame(console, rand); 
      while (determeNext(console)) { //play the game multiple times
         guess += (currentGuess = singleGame(console, rand));
         gameNum ++;
            if (min > currentGuess) { //update minimum guess
               min =  currentGuess;
            }
         }
      reportResults(gameNum, guess, min); //show the result stats
      }

   public static void intro(){
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it.  For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      System.out.println();
   }
   
    /*the method to play the game
     * @param console, Scanner type, the input of the user
     * @param rand, Random type, the random number by the random object
     * return, int type, the current guess number
     */
   public static int singleGame(Scanner console, Random rand){
      System.out.println("I'm thinking of a number between 1 and " + MAX + "...");
      System.out.print("Your guess? ");      
      int currentNum = rand.nextInt(MAX) + 1;
      int currentGuess = 1;
      int number = console.nextInt();
      while (number != currentNum) {
         if (number > currentNum) { 
            System.out.println("It's higher.");
         } else {
            System.out.println("It's lower.");
         }
         currentGuess++;
         System.out.print("Your guess? ");
         number = console.nextInt();
      }
      System.out.println("You got it right in " + currentGuess + " guesses!");
      return currentGuess;
   }

   /*the method deterines whether need another the game starts
    * @param console, Scanner type, the input of the user
    * return, boolean type, whether keep playing the game
    */
   public static boolean determeNext(Scanner console){
      System.out.print("Do you want to play again? ");
      String answer = console.next().toLowerCase();
      System.out.println();
      //determine whether the first character is "y"
      return answer.substring(0,1).equals("y");
   }

   /*the method to get statistic results
    * @param gameNum
    * @param guess, int type, cumulate the total guesses
    * @param min, int type, determine the minimum guess
    * no return type
    */
   public static void reportResults(int gameNum, int guess,int min){
      System.out.println("Overall results:");
      System.out.println("Total games   = " + gameNum);
      System.out.println("Total guesses = " + guess);
      System.out.println("Guesses/game  = " + round1((double)guess / gameNum));
      System.out.println("Best game     = " + min);
   }
   
   /*the method to round number to one decimal place
    * @param number, double type, the number need to be round
    * return, double type, the rounded number
    */
   public static double round1(double number){
      double num = Math.round(10.0 * number) / 10.0;
      return num;
   }
   
}
