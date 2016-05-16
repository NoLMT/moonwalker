import javax.swing.*;
import java.awt.*;

public class SampleLevel extends JPanel
{
  public static void main (String[] args) throws InterruptedException
  {
    JFrame frame = new JFrame("Moon Walker Level");
    SampleLevel l = new SampleLevel();
    frame.add(l);
    frame.setSize(900, 900);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void paint(Graphics g)
  {
    Graphics2D g2d = (Graphics2D) g;
    
    g2d.setColor(Color.darkGray);
    g2d.fillRect(0, 0, 900, 865);
    
    g2d.setColor(Color.cyan);
    g2d.fillRect(220, 790, 180, 100); // platform 1
    g2d.fillRect(550, 700, 350, 200); // platform 2 
    g2d.fillRect(725, 590, 175, 110); // platform 3
    
  }
}                                       