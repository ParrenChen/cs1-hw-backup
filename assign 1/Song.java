// Parren Chen
// 1/9/19
// CSE142
// TA:  Ian Wohlers 
// Assignment #1
//
// This program will print the cumulative song with 6 existing verses and a creative one.

public class Song{
   public static void main(String[] args){
      fly();
      System.out.println();
      spider();
      System.out.println();
      bird();
      System.out.println();
      cat();
      System.out.println();
      dog();
      System.out.println();
      panda();
      System.out.println();
      horse();
   }
   
   //Print existing verse 1
   public static void fly(){
      System.out.println("There was an old woman who swallowed a fly.");
      swallowFly();
   }
   
   //Print existing verse 2
   public static void spider(){
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      swallowSpider();
   }
   
   //Print existing verse 3
   public static void bird(){
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      swallowBird();
   }
   
   //Print existing verse 4
   public static void cat(){
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      swallowCat();
   }
   
   //Print existing verse 5
   public static void dog(){
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      swallowDog();
   }
   
   //Print my own verse 6
   public static void panda(){
      System.out.println("There was an old woman who swallowed a panda,");
      System.out.println("What a pity to swallow a panda.");
      swallowPanda();
   }
   
   //Print existing verse 7
   public static void horse(){
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   
   //Print repeating sentences for Fly
   public static void swallowFly(){
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
   }
   
   //Print repeating sentences for Spider
   public static void swallowSpider(){
      System.out.println("She swallowed the spider to catch the fly,");
      swallowFly();
   }
   
   //Print repeating sentences for Bird
   public static void swallowBird(){
      System.out.println("She swallowed the bird to catch the spider,");
      swallowSpider();
   }
   
   //Print repeating sentences for Cat
   public static void swallowCat(){
      System.out.println("She swallowed the cat to catch the bird,");
      swallowBird();
   }
   
   //Print repeating sentences for Dog
   public static void swallowDog(){
      System.out.println("She swallowed the dog to catch the cat,"); 
      swallowCat();
   }
   
   //Print repeating sentences for Panda
   public static void swallowPanda(){
      System.out.println("She swallowed the panda to catch the dog,");
      swallowDog();
   }

}