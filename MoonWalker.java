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
  Button[] b = new Button[3];
  Door[] d = new Door[2];
  ExitDoor ed;
  PlatformDoor[] pd = new PlatformDoor[2];
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
        for(int i = 0; i < p.length; i++)
        {
          p[i] = new Platform(this, 1000, 1000);
        }
        c1 = new Coin(this, 450, 470, 0);
        c2 = new Coin(this, 450, 815, 1);
        c3 = new Coin(this, 150, 360, 2); 
        b[0] = new Button(this, 1000, 550, 2);
        b[1] = new Button(this, 1000, 550, 3);
        b[2] = new Button(this, 1000, 550, 3);
        ed = new ExitDoor(this, 50, 150);
        sam.setJump(0);
        sam.setSpeed(0);
        sam.setShrink(0);
        //true is vertical, false is horizontal
        d[0] = new Door(this, 1000, 200, 2, false);
        d[1] = new Door(this, 1000, 200, 2, false);
        pd[0] = new PlatformDoor(this, 1000, 300, 3, false);
        pd[1] = new PlatformDoor(this, 0, 770, 3, false);
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
      case 3:
        s = 0;
        for(int i = 0; i < p.length; i++)
        {
          p[i] = new Platform(this, 1000, 1000);
        }
        c1 = new Coin(this, 345, 520, 0);
        c2 = new Coin(this, 450, 815, 1);
        c3 = new Coin(this, 150, 360, 2); 
        b[0] = new Button(this, 200, 832, 2);
        b[1] = new Button(this, 1000, 550, 3);
        b[2] = new Button(this, 1000, 550, 3);
        ed = new ExitDoor(this, 800, 300);
        sam.setJump(0);
        sam.setSpeed(1);
        sam.setShrink(0);
        //true is vertical, false is horizontal
        d[0] = new Door(this, 300, 570, 0, false);
        d[1] = new Door(this, 1000, 200, 2, false);
        pd[0] = new PlatformDoor(this, 180, 720, 2, false);
        pd[1] = new PlatformDoor(this, 0, 770, 3, false);
        for(int i = 720; i <= 870; i += 30)
        {
          for (int l = 300; l <= 420; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        for(int i = 780; i <= 780; i += 30)
        {
          for (int l = 0; l <= 30; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        for(int i = 210; i <= 720; i += 30)
        {
          for (int l = 150; l <= 150; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        for(int i = 630; i <= 630; i += 30)
        {
          for (int l = 0; l <= 30; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        for(int i = 720; i <= 720; i += 30)
        {
          for (int l = 120; l <= 120; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        for(int i = 450; i <= 450; i += 30)
        {
          for (int l = 0; l <= 30; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        for(int i = 540; i <= 540; i += 30)
        {
          for (int l = 120; l <= 120; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        for(int i = 330; i <= 330; i += 30)
        {
          for (int l = 120; l <= 120; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        for(int i = 60; i <= 570; i += 30)
        {
          for (int l = 270; l <= 270; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        for(int i = 420; i <= 480; i += 30)
        {
          for (int l = 300; l <= 390; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        for(int i = 750; i <= 870; i += 30)
        {
          for (int l = 450; l <= 510; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        for(int i = 420; i <= 570; i += 30)
        {
          for (int l = 420; l <= 450; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        for(int i = 420; i <= 540; i += 30)
        {
          for (int l = 480; l <= 480; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        sam.reset();
        break;
      case 4:
        s = 0;
        c1 = new Coin(this, 30, 650, 0);
        c2 = new Coin(this, 840, 60, 1);
        c3 = new Coin(this, 540, 390, 2); 
        b[0] = new Button(this, 810, 832, 3);
        b[1] = new Button(this, 30, 150, 0);
        b[2] = new Button(this, 390, 630, 1);
        ed = new ExitDoor(this, 810, 180);
        sam.setJump(1);
        sam.setSpeed(1);
        sam.setShrink(1);
        //true is vertical, false is horizontal
        d[0] = new Door(this, 90, 60, 1, true);
        d[1] = new Door(this, 780, 150, 1, true);
        pd[0] = new PlatformDoor(this, 0, 770, 3, false);
        pd[1] = new PlatformDoor(this, 660, 210, 0, true);
        for(int i = 0; i < p.length; i++)
        {
          p[i] = new Platform(this, 1000, 1000);
        }
        
        for(int i = 480; i <= 600; i += 30)
        {
          for (int l = 0; l <= 30; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        p[s] = new Platform(this, 60, 600);
        s++;
        
        for(int i = 600; i <= 660; i += 30)
        {
          for (int l = 90; l <= 120; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }

        for(int i = 660; i <= 660; i += 30)
        {
          for (int l = 90; l <= 420; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 330; i <= 540; i += 30)
        {
          for (int l = 270; l <= 390; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 770; i <= 770; i += 30)
        {
          for (int l = 780; l <= 900; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 680; i <= 680; i += 30)
        {
          for (int l = 540; l <= 690; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 390; i <= 390; i += 30)
        {
          for (int l = 120; l <= 210; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 270; i <= 270; i += 30)
        {
          for (int l = 120; l <= 180; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 180; i <= 180; i += 30)
        {
          for (int l = 0; l <= 90; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 330; i <= 480; i += 30)
        {
          for (int l = 420; l <= 420; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
             
        for(int i = 330; i <= 420; i += 30)
        {
          for (int l = 450; l <= 450; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 330; i <= 360; i += 30)
        {
          for (int l = 480; l <= 660; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 390; i <= 420; i += 30)
        {
          for (int l = 630; l <= 660; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 450; i <= 480; i += 30)
        {
          for (int l = 660; l <= 690; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 510; i <= 540; i += 30)
        {
          for (int l = 690; l <= 720; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 270; i <= 270; i += 30)
        {
          for (int l = 750; l <= 900; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 120; i <= 120; i += 30)
        {
          for (int l = 720; l <= 900; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 60; i <= 60; i += 30)
        {
          for (int l = 780; l <= 780; l += 30)
          {
            p[s] = new Platform(this, l, i);
            s++;
          }
        }
        
        for(int i = 240; i <= 300; i += 30)
        {
          for (int l = 300; l <= 630; l += 90)
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
        b[2] = new Button(this, 1000, 550, 3);
        ed = new ExitDoor(this, 800, 810);
        sam.setJump(2);
        sam.setSpeed(2);
        sam.setShrink(2);
        //true is vertical, false is horizontal
        d[0] = new Door(this, 1000, 200, 2, false);
        d[1] = new Door(this, 1000, 200, 2, false);
        pd[0] = new PlatformDoor(this, 1000, 300, 3, false);
        pd[1] = new PlatformDoor(this, 0, 770, 3, false);
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
    if(level > 4)
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
