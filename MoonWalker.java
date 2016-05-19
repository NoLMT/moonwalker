import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MoonWalker extends JPanel
{
  public MoonWalker m;
  SpacemanSam sam = new SpacemanSam(this);
  Platform[] p = new Platform[133];
  Coin c1 = new Coin(this, 770, 800, 0);
  Coin c2 = new Coin(this, 800, 800, 1);
  Coin c3 = new Coin(this, 830, 800, 2);
  
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
    p[0] = new Platform(this, 220, 745);
    p[1] = new Platform(this, 250, 735);
    p[2] = new Platform(this, 300, 685);
    p[3] = new Platform(this, 500, 485);
    p[4] = new Platform(this, 500, 800);
    p[5] = new Platform(this, 100, 100);
    p[6] = new Platform(this, 130, 100);
    p[7] = new Platform(this, 160, 100);
    p[8] = new Platform(this, 100, 130);
    p[9] = new Platform(this, 130, 130);
    p[10] = new Platform(this, 500, 770);
    p[11] = new Platform(this, 500, 740);
    p[12] = new Platform(this, 500, 710);
    p[13] = new Platform(this, 500, 680);
    p[14] = new Platform(this, 500, 830);
    p[15] = new Platform(this, 500, 860);
    for(int i = 16; i < p.length; i++)
    {
      p[i] = new Platform(this, i*2, i*2);
    }
  }
  
  public static void main(String[] args) throws InterruptedException
  {
    JFrame frame = new JFrame("Moon Walker");
    MoonWalker m = new MoonWalker();
    frame.add(m);
    frame.setResizable(false);
    frame.setSize(890, 890);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    while (true) 
    {
      m.move(); 
      m.repaint(); 
      Thread.sleep(15);
    } 
  }
  
  public void unCollect()
  {
    c1.unCollect();
    c2.unCollect();
    c3.unCollect();
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
    c1.paint(g2d);
    c2.paint(g2d);
    c3.paint(g2d);
  }
  
  public void move()
  {
    for(int i = 0; i < p.length; i++)
    {
      sam.collision(p[i]);
    }
    sam.collision(c1);
    sam.collision(c2);
    sam.collision(c3);
    sam.move();
  }
}