import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MoonWalker extends JPanel
{
  public MoonWalker m;
  SpacemanSam sam = new SpacemanSam(this);
  Platform[] p = new Platform[186];
  private int s = 0;
  Coin c1 = new Coin(this, 480, 360, 0);
  Coin c2 = new Coin(this, 450, 815, 1);
  Coin c3 = new Coin(this, 90, 120, 2); 
  Button b = new Button(this, 800, 570, 3);
  Door d = new Door(this, 200, 200, 3);
  static String time;
  static long startTime = System.currentTimeMillis();
  static long endTime;
  
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
    for(int i = 780; i <= 840; i += 30)
    {
      for (int l = 210; l <= 360; l += 30)
      {
        p[s] = new Platform(this, l, i);
        s++;
      }
    }
    s = 18;
    for(int i = 690; i <= 780; i += 30)
    {
      p[s] = new Platform(this, 450, i);
        s++;
    }
    s = 22;
    for(int i = 690; i <= 870; i += 30)
    {
      for (int l = 540; l <= 870; l += 30)
      {
        p[s] = new Platform(this, l, i);
        s++;
      }
    }
    s = 106;
    for(int i = 600; i <= 690; i += 30)
    {
      for (int l = 720; l <= 870; l += 30)
      {
        p[s] = new Platform(this, l, i);
        s++;
      }
    }
    s = 130 ;
    for(int i = 480; i <= 510; i += 30)
    {
      for (int l = 510; l <= 660; l += 30)
      {
        p[s] = new Platform(this, l, i);
        s++;
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
    s = 160;
    for(int i = 240; i <= 270; i += 30) 
    {
      for (int l = 0; l <= 180; l += 30)
      {
        p[s] = new Platform(this, l, i);
        s++;
      }
    }
    s = 174;
    for(int i = 330; i <= 360; i += 30)
    {
      for (int l = 210; l <= 360; l += 30)
      {
        p[s] = new Platform(this, l, i);
        s++;
      }
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
      endTime = (System.currentTimeMillis())-startTime;
    } 
  }
  
  public void unCollect()
  {
    c1.unCollect();
    c2.unCollect();
    c3.unCollect();
    b.unPress();
  }
  
  public void checkBlock()
  {
    for(int i = 0; i < p.length; i++)
    {
      sam.checkBlock(p[i]);
    }
  }
  
  public void pauseTimer()
  {
    startTime += 15;
  }
  
  public void resetTimer()
  {
    startTime = System.currentTimeMillis();
  }
  
  public void paint(Graphics g) 
  { 
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(new Color(0, 0, 100));
    g2d.fillRect(0, 0, 900, 865);
    g2d.setColor(new Color(0, 255, 255));
    time = "" + (endTime/1000);
    g2d.setFont(new Font("Aharoni", Font.BOLD, 24));
    g2d.drawString(time, 500, 50);
    for(int i = 0; i < p.length; i++)
    {
      p[i].paint(g2d);
    }
    c1.paint(g2d);
    c2.paint(g2d);
    c3.paint(g2d);
    b.paint(g2d);
    d.paint(g2d);
    sam.paint(g2d);
  }
  
  public void move()
  {
    for(int i = 0; i < p.length; i++)
    {
      sam.collision(p[i]);
    }
    //If pressed, count down
    if(b.getPressed() && !sam.getPaused())
    {
      b.timeDown();
    }
    if(b.getColor() == d.getColor())
    {
      d.open(b.getPressed());
    }
    sam.collision(c1);
    sam.collision(c2);
    sam.collision(c3);
    sam.collision(b);
    sam.move();
  }
}
