import java.awt.*;

public class Doodle{
   public static void main(String[] args){
      DrawingPanel panel = new DrawingPanel(400, 300);
      Graphics g = panel.getGraphics();
      panel.setBackground(Color.GRAY);
      drawPattern(g, 10, 20, 20);
      drawPattern(g, 150, 20, 30);
      drawPattern(g, 20, 150, 40);
      drawPattern(g, 300, 200, 40);
   }
   
   public static void drawPattern(Graphics g, int x, int y, int size){
      g.setColor(Color.PINK);
      g.fillOval(x, y, size, size);
      g.fillOval(x + size, y + size, size, size);
      g.setColor(Color.BLACK);
      g.drawRect(x, y, 2 * size, 2 * size);
      g.setColor(Color.GREEN);
      g.drawLine(x, y + 2 * size, x + 2 * size, y);
   }
}