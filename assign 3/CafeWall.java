// Parren Chen
// 1/19/19
// CSE142
// TA:  Ian Wohlers 
// Assignment #3
//
// This program will draw a cafe wall pattern.
// import the java.awt package for graphics

import java.awt.*;

public class CafeWall{

   public static final int MORTAR = 2;
   // the class constant for mortar value between the lines
   
   public static void main(String[] args){
      DrawingPanel panel = new DrawingPanel(650, 400);
      // the panel size is 650 * 400
      Graphics g = panel.getGraphics();
      panel.setBackground(Color.GRAY);
      drawSquares(g, 0, 0, 20, 4);
      drawSquares(g, 50, 70, 30, 5);
      offSet(g, 10, 150, 25, 4, 0);
      offSet(g, 250, 200, 25, 3, 10);
      offSet(g, 425, 180, 20, 5, 10);
      offSet(g, 400, 20, 35, 2, 35);
   }

   // draws a single line with initial position, pairs and size
   // parameters needed:
   //      g = make changes to the Graphics object
   //      x = initial x coordinate
   //      y = initial y coordinate
   //   size = size of the squares
   // number = number of pairs repeat
   public static void drawSquares(Graphics g, int x, int y, int size, int number){
      for(int i = 1; i <= number; i++){
         g.setColor(Color.BLACK);
         g.fillRect(x + 2 * (i - 1) * size, y, size, size);
         g.setColor(Color.WHITE);
         g.fillRect(x + (2 * i - 1) * size, y, size, size);
         g.setColor(Color.BLUE);
         g.drawLine(x + 2 * (i - 1) * size, y, x + (2 * i - 1) * size, y + size);
         g.drawLine(x + 2 * (i - 1) * size, y + size, x + (2 * i - 1) * size, y);
      }
   }

   // draws multiple lines and controls the offset
   // parameters needed:
   //      g = make changes to the Graphics object
   //      x = initial x coordinate
   //      y = initial y coordinate
   //   size = size of the square
   // number = number of pairs repeat
   // offSet = the desired offset of the line 
   public static void offSet(Graphics g, int x, int y, int size, 
                             int number, int offSet){
      for(int i = 0; i < 2 * number; i++){
         drawSquares(g, x + offSet * (i % 2), y + i * MORTAR + size * i, size, number);
      }
   }
}