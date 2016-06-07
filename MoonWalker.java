import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage; 
import javax.imageio.*; 
import java.io.*; 

public class MoonWalker extends JPanel
{
  public MoonWalker m;
  SpacemanSam sam = new SpacemanSam(this);
  Platform[] p = new Platform[179];
  private int s = 0;
  private int level = 0;
  Coin c1;
  Coin c2;
  Coin c3;
  Button[] b = new Button[2];
  Door[] d = new Door[1];
  ExitDoor ed;
  PlatformDoor[] pd = new PlatformDoor[1];
  static String time;
  static long startTime = System.currentTimeMillis();
  static long endTime;
  private BufferedImage bg = null;
  
  public MoonWalker()
  {
     try
    {
      bg = ImageIO.read(new File("Background.png"));
    } catch (IOException e)
    {
      System.out.println("No Image");
    }
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
  }
  
  public void rebuild()
  {
    switch(level)
    {
      case 0:
        s = 0;
        c1 = new Coin(this, 450, 470, 0);
        c2 = new Coin(this, 450, 815, 1);
        c3 = new Coin(this, 150, 360, 2); 
        b[0] = new Button(this, 1000, 750, 1);
        b[1] = new Button(this, 1000, 550, 3);
        ed = new ExitDoor(this, 50, 150);
        sam.setJump(0);
        sam.setSpeed(0);
        sam.setShrink(0);
        //true is vertical, false is horizontal
        d[0] = new Door(this, 1000, 200, 1, true);
        pd[0] = new PlatformDoor(this, 1000, 300, 3, false);
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
        for(int i = 240; i <= 240; i += 30) 
        {
          for (int l = 0; l <= 180; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        s = 167;
        for(int i = 330; i <= 360; i += 30)
        {
          for (int l = 210; l <= 360; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        sam.reset();
        break;
      default:
        s = 0;
        c1 = new Coin(this, 1000, 470, 0);
        c2 = new Coin(this, 1000, 815, 1);
        c3 = new Coin(this, 1000, 360, 2); 
        b[0] = new Button(this, 1000, 550, 2);
        b[1] = new Button(this, 1000, 550, 3);
        ed = new ExitDoor(this, 1000, 150);
        sam.setJump(2);
        sam.setSpeed(2);
        sam.setShrink(2);
        //true is vertical, false is horizontal
        d[0] = new Door(this, 1000, 200, 2, false);
        pd[0] = new PlatformDoor(this, 1000, 300, 3, false);
        for(int i = 0; i < p.length; i++)
        {
          p[i] = new Platform(this, 1000, 1000);
        }
        sam.reset();
    }  
  }
  
  public void levelUp()
  {
    level++;
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
    m.rebuild();
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
    for(int i = 0; i < b.length; i++)
    {
      b[i].unPress();
    }
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
    //g2d.setColor(new Color(0, 0, 100));
    //g2d.fillRect(0, 0, 900, 865);
    g2d.drawImage(bg, 0, 0, null);
    g2d.setColor(new Color(0, 255, 0));
    time = "" + (endTime/1000);
    g2d.setFont(new Font("Aharoni", Font.BOLD, 32));
    g2d.drawString(time, 445, 40);
    if(level > 0)
    {
      g2d.drawString("YOU WIN", 400, 445);
    }
    for(int i = 0; i < p.length; i++)
    {
      p[i].paint(g2d);
    }
    c1.paint(g2d);
    c2.paint(g2d);
    c3.paint(g2d);
    for(int i = 0; i < b.length; i++)
    {
      b[i].paint(g2d);
    }
    for(int i = 0; i < d.length; i++)
    {
      d[i].paint(g2d);
    }
    for(int i = 0; i < pd.length; i++)
    {
      pd[i].paint(g2d);
    }
    ed.paint(g2d);
    sam.paint(g2d);
  }
  
  public void move()
  {
    for(int i = 0; i < p.length; i++)
    {
      sam.collision(p[i]);
    }
    //If pressed, count down
    for(int i = 0; i < b.length; i++)
    {
      if(b[i].getPressed() && !sam.getPaused())
      {
        b[i].timeDown();
      }
    }
    for(int i = 0; i < b.length; i++)
    {
      for(int j = 0; j < b.length; j++)
      {
        if(b[i].getColor() == b[j].getColor() && b[i].getPressed())
        {
          b[j].pressed(b[i].getPressed());
        }
      }
      for(int j = 0; j < d.length; j++)
      {
        if(b[i].getColor() == d[j].getColor())
        {
          d[j].open(b[i].getPressed());
        }
      }
      for(int j = 0; j < pd.length; j++)
      {
        if(b[i].getColor() == pd[j].getColor())
        {
          pd[j].open(b[i].getPressed());
        }
      }
    }
    sam.collision(c1);
    sam.collision(c2);
    sam.collision(c3);
    sam.collision(ed);
    for(int i = 0; i < b.length; i++)
    {
      sam.collision(b[i]);
    }
    for(int i = 0; i < d.length; i++)
    {
      if(!d[i].getOpen())
      {
        sam.collision(d[i]);
      }
    }
    for(int i = 0; i < pd.length; i++)
    {
      if(pd[i].getOpen())
      {
        sam.collision(pd[i]);
      }
    }
    sam.move();
  }
}
