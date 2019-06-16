// Parren Chen
// 1/19/19
// CSE142
// TA:  Ian Wohlers 
// Assignment #2
//
// This program will print a rocket ship. 

public class DrawRocket{
   
   //declare a class constant of size 
   public static final int SIZE = 3;
    
   public static void main(String[] args){
      drawArrow();
      drawStar();
      drawUp();
      drawDown();
      drawStar();
      drawDown();
      drawUp();
      drawStar();
      drawArrow();
   }
   
   //print the arrow-shape part
   public static void drawArrow(){
      for (int i = 1; i <= 2 * SIZE -1; i++){
         for (int j = - i + 2 * SIZE; j > 0; j--){
            System.out.print(" ");
         }
         for (int j = 1; j <= i; j++){
            System.out.print("/");
         }
         for (int j = 1; j <= 2; j++){
         System.out.print("*");
         }
         for (int j = 1; j <= i; j++){
            System.out.print("\\");
         }
         System.out.println();
      }
   }
   
   //print the star line between middle parts
   public static void drawStar(){
      System.out.print("+");
      for (int i = 1; i <= 2 * SIZE; i++){
         System.out.print("=*");
      }
      System.out.println("+");
   }
   
   //print the upper part of the rocket body
   public static void drawUp(){
      for (int i = 1; i <= SIZE; i++){
         System.out.print("|");
         for (int j = -i + SIZE; j > 0; j--){
            System.out.print(".");
         }
         for (int j = 1; j <= i; j++){
            System.out.print("/\\");
         }
         for (int j = -2 * i + 2 * SIZE; j > 0; j--){
            System.out.print(".");
         }
         for (int j = 1; j <= i; j++){
            System.out.print("/\\");
         }
         for (int j = - i + SIZE; j > 0; j--){
            System.out.print(".");
         }
         System.out.println("|");
      }
   }
   
   //print the lower part of the rocket body
   public static void drawDown(){
      for (int i = 1; i <= SIZE; i++){
         System.out.print("|");
         for (int j = 1; j <= i - 1; j++){
            System.out.print(".");
         }
         for (int j = SIZE + 1 - i; j > 0; j--){
            System.out.print("\\/");
         }
         for (int j = 1 ; j <= 2 * i - 2; j++){
            System.out.print(".");
         }
         for (int j = SIZE + 1 - i; j > 0; j--){
            System.out.print("\\/");
         }
         for (int j = 1; j <= i - 1; j++){
            System.out.print(".");
         }
         System.out.println("|");
      }
   }
}