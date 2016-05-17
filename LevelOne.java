import javax.swing.*;
import java.awt.*;

public class LevelOne extends JPanel
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
    //          ( x ,  y , wid, hei);
    g2d.fillRect(210, 780, 180, 90); // platform 1
    g2d.fillRect(540, 690, 360, 210); // platform 2 
    g2d.fillRect(720, 600, 180, 120); // platform 3
    g2d.fillRect(510, 510, 180, 60); // platform 4
    g2d.fillRect(270, 450, 180, 90); // platform 5
    g2d.fillRect(0, 420, 180, 60); // platform 6
  }
}                                       
