import javax.swing.*;
import java.awt.*;

public class LevelTwo extends JPanel
{
  public Platform[] p = new Platform[30];
 
  public LevelTwo()
  {
    p[0] = new Platform(this, 720, 720);
    p[1] = new Platform(this, 750, 720);
    p[2] = new Platform(this, 780, 720);
    p[3] = new Platform(this, 810, 720);
    p[4] = new Platform(this, 840, 720);
    p[5] = new Platform(this, 870, 720);
    
    p[6] = new Platform(this, 720, 750);
    p[7] = new Platform(this, 750, 750);
    p[8] = new Platform(this, 780, 750);
    p[9] = new Platform(this, 810, 750);
    p[10] = new Platform(this, 840, 750);
    p[11] = new Platform(this, 870, 750);
 
    p[12] = new Platform(this, 720, 780);
    p[13] = new Platform(this, 750, 780);
    p[14] = new Platform(this, 780, 780);
    p[15] = new Platform(this, 810, 780);
    p[16] = new Platform(this, 840, 780);
    p[17] = new Platform(this, 870, 780);
    
    p[18] = new Platform(this, 720, 810);
    p[19] = new Platform(this, 750, 810);
    p[20] = new Platform(this, 780, 810);
    p[21] = new Platform(this, 810, 810);
    p[22] = new Platform(this, 840, 810);
    p[23] = new Platform(this, 870, 810);
    
    p[24] = new Platform(this, 720, 840);
    p[25] = new Platform(this, 750, 840);
    p[26] = new Platform(this, 780, 840);
    p[27] = new Platform(this, 810, 840);
    p[28] = new Platform(this, 840, 840);
    p[29] = new Platform(this, 870, 840);
  }
  
  public static void main (String[] args) throws InterruptedException
  {
    JFrame frame = new JFrame("Moon Walker Level");
    LevelTwo l = new LevelTwo();
    frame.add(l);
    frame.setSize(900, 900);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void paint(Graphics g)
  {
    Graphics2D g2d = (Graphics2D) g;
    
    g2d.setColor(new Color(0, 0, 100));
    g2d.fillRect(0, 0, 900, 900);
    
    for(int i = 0; i < p.length; i++)
    {
      p[i].paint(g2d);
    }
  }
}