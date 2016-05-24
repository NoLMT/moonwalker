import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MoonWalker extends JPanel
{
  public MoonWalker m;
  SpacemanSam sam = new SpacemanSam(this);
  Platform[] p = new Platform[172];
  private int t = 0;
  private int o = 0;
  private int u = 0;
  private int f = 0;
  private int z = 0;
  private int s = 0;
  private int k = 0; 
  Coin c1 = new Coin(this, 480, 360, 0);
  Coin c2 = new Coin(this, 450, 815, 1);
  Coin c3 = new Coin(this, 830, 800, 2); // FIX POSITION
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
    for(int n = 780; n <= 840; n += 30)
    {
      for (int m = 210; m <= 360; m += 30)
      {
        p[t] = new Platform(this, m, n);
        t++;
      }
    }
    o = 18;
    for(int r = 690; r <= 780; r += 30)
    {
      p[o] = new Platform(this, 450, r);
      o++;
    }
    u = 22;
    for(int b = 690; b <= 870; b += 30)
    {
      for (int a = 540; a <= 870; a += 30)
      {
        p[u] = new Platform(this, a, b);
        u++;
      }
    }
    f = 106;
    for(int g = 600; g <= 690; g += 30)
    {
      for (int h = 720; h <= 870; h += 30)
      {
        p[f] = new Platform(this, h, g);
        f++;
      }
    }
    z = 130 ;
    for(int x = 510; x <= 540; x += 30)
    {
      for (int y = 510; y <= 660; y += 30)
      {
        p[z] = new Platform(this, y, x);
        z++;
      }
    }
    s = 142 ;
    for(int i = 450; i <= 510; i += 30) 
    {
      for (int l = 270; l <= 420; l += 30)
      {
        p[s] = new Platform(this, l, i);
        s++;
      }
    }
    k = 160;
    for(int e = 420; e <= 450; e += 30) 
    {
      for (int t = 0; t <= 150; t += 30)
      {
        p[k] = new Platform(this, t, e);
        k++;
      }
    }
  }
  public void unCollect()
  {
    c1.unCollect();
    c2.unCollect();
    c3.unCollect();
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
      Thread.sleep(15);
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