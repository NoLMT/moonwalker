import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MoonWalker extends JPanel
{
  public MoonWalker m;
  SpacemanSam sam = new SpacemanSam(this);
  Platform[] plat = new Platform[24];
  
  public MoonWalker()
  {
    KeyListener listener = new KeyListener()
    {
      public void keyTyped(KeyEvent e){}  
      public void keyReleased(KeyEvent e) 
      { sam.keyReleased(e); }
      public void keyPressed(KeyEvent e) 
      { sam.keyPressed(e);} 
    };
    addKeyListener(listener);
    setFocusable(true);
    //For every 30x30 square of platform
    plat[0] = new Platform(220, 805);
    plat[1] = new Platform(250, 805);
    plat[2] = new Platform(280, 805);
    plat[3] = new Platform(310, 805);
    plat[4] = new Platform(340, 805);
    plat[5] = new Platform(220, 835);
    plat[6] = new Platform(250, 835);
    plat[7] = new Platform(280, 835);
    plat[8] = new Platform(310, 835);
    plat[9] = new Platform(340, 835);
    plat[10] = new Platform(220, 745);
    plat[11] = new Platform(250, 745);
    plat[12] = new Platform(280, 745);
    plat[13] = new Platform(310, 745);
    plat[14] = new Platform(340, 745);
    plat[15] = new Platform(220, 775);
    plat[16] = new Platform(250, 775);
    plat[17] = new Platform(280, 775);
    plat[18] = new Platform(310, 775);
    plat[19] = new Platform(340, 775);
    plat[20] = new Platform(190, 805);
    plat[21] = new Platform(190, 835);
    plat[22] = new Platform(160, 805);
    plat[23] = new Platform(160, 835);
  }
  
  public static void main(String[] args) throws InterruptedException
  {
    JFrame frame = new JFrame("Moon Walker");
    MoonWalker m = new MoonWalker();
    frame.add(m);
    frame.setSize(900, 900);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    while (true) 
    {
      m.move(); 
      m.repaint(); 
      Thread.sleep(10);
    } 
  }
  
  public void paint(Graphics g) 
  { 
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(new Color(0, 0, 100));
    g2d.fillRect(0, 0, 900, 865);
    for(int n = 0; n < plat.length; n++)
    {
       plat[n].paint(g2d);
    }
    sam.paint(g2d);
  }
  
  public void move()
  {
    sam.move();
  }
}