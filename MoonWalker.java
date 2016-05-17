import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MoonWalker extends JPanel
{
  public MoonWalker m;
  SpacemanSam sam = new SpacemanSam(this);
  Platform[] p = new Platform[5];
  
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
    p[0] = new Platform(this, 220, 765);
    p[1] = new Platform(this, 250, 735);
    p[2] = new Platform(this, 300, 685);
    p[3] = new Platform(this, 500, 485);
    p[4] = new Platform(this, 500, 800);
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
    g2d.setColor(new Color(0, 255, 255));
    sam.paint(g2d);
    for(int i = 0; i < p.length; i++)
    {
      p[i].paint(g2d);
    }
  }
  
  public void move()
  {
    for(int i = 0; i < p.length; i++)
    {
      sam.collision(p[i]);
    }
    sam.move();
  }
}