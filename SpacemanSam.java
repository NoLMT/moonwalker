import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class SpacemanSam
{
  static int x = 50;
  static int y = 815;
  //Horizontal Velocity
  static int xv = 0;
  //Vertical Velocity
  static int yv = 0;
  //Horizontal Acceleration
  static int xa = 0; 
  //Vertical Acceleration
  static int ya = 0;
  //Number of Jump Boosts
  static int jumpBoost = 0;
  static int levelJump = 2;
  //Number of Shink Powers
  static int small = 0;
  static int levelSmall = 2;
  //Number of Speed Boosts
  static int speedBoost = 0;
  static int levelSpeed = 2;
  //Time spent small
  static int smallTime = 250;
  //Test if Jumping
  static boolean isJumping = false;
  //Test if Small
  static boolean isSmall = false;
  static boolean pause = false;
  // test if instructions are already onscreen
  static boolean display = false;
  static MoonWalker m;
  private BufferedImage instruct = null;
  private static BufferedImage img = null;
  private static BufferedImage img2 = null;
  static boolean facingRight = true;
  int colourGen = (int) (4*(Math.random())+ 1);
  
  public SpacemanSam(MoonWalker m)
  {
    this.m = m;
    
    try
    {
      instruct = ImageIO.read(new File("Instructions for game.jpg"));
    } catch (IOException e)
    {
      System.out.println("No Image");
    }
    
    if(colourGen == 1)
    {
      try
      {
        img = ImageIO.read(new File("Blue Spaceman.png"));
      } catch (IOException e)
      {
        System.out.println("No Image");
      }
    }
    else if(colourGen == 2)
    {
      try
      {
        img = ImageIO.read(new File("Green Spaceman.png"));
      } catch (IOException e)
      {
        System.out.println("No Image");
      }
    }
    else if(colourGen == 3)
    {
      try
      {
        img = ImageIO.read(new File("Red Spaceman.png"));
      } catch (IOException e)
      {
        System.out.println("No Image");
      }
    }
    else if(colourGen == 4)
    {
      try
      {
        img = ImageIO.read(new File("Purple Spaceman.png"));
      } catch (IOException e)
      {
        System.out.println("No Image");
      }
    }
    if (colourGen == 1)
    {
      try
      {
        img2 = ImageIO.read(new File("Blue Spaceman Small.png"));
      } catch (IOException e)
      {
        System.out.println("No Image");
      }
    }
    else if (colourGen == 2)
    {
      try
      {
        img2 = ImageIO.read(new File("Green Spaceman Small.png"));
      } catch (IOException e)
      {
        System.out.println("No Image");
      }
    }
    else if (colourGen == 3)
    {
      try
      {
        img2 = ImageIO.read(new File("Red Spaceman Small.png"));
      } catch (IOException e)
      {
        System.out.println("No Image");
      }
    }
    else if (colourGen == 4)
    {
      try
      {
        img2 = ImageIO.read(new File("Purple Spaceman Small.png"));
      } catch (IOException e)
      {
        System.out.println("No Image");
      }
    }
  }
  
  public boolean getPaused()
  {
    return pause;
  }
  
  public void setSpeed(int speed)
  {
    levelSpeed = speed;
  }
  
  public void setJump(int jump)
  {
    levelJump = jump;
  }
  
  public void setShrink(int shrink)
  {
    levelSmall = shrink;
  }
  
  public void reset()
  {
    x = 50;
    y = 815;
    xv = 0;
    yv = 0;
    xa = 0; 
    ya = 0;
    jumpBoost = levelJump;
    small = levelSmall;
    speedBoost = levelSpeed;
    smallTime = 250;
    isJumping = false;
    isSmall = false;
    m.unCollect();
    m.resetTimer();
  }
  
  public void move()
  {
    //Don't run if paused
    if(!pause)
    {
      if(yv > 1)
      {
        isJumping = true;
      }
      //If jumping then accelerate downward
      if(isJumping)
      {
        ya = 1;
      }
      //Move Horizontally
      x += xv;
      //Stop SMS from moving too quickly
      if(xv > 2)
      {
        xv -= 2;
      }
      else if(xv < -2)
      {
        xv += 2;
      }
      if(yv > 15)
      {
        yv -= 2;
      }
      //Stop SMS from falling through the floor
      if(y >= 815 && yv > 0)
      {
        ya = 0;
        yv = 0;
        y = 815;
        isJumping = false;
      }
      //Stop SMS from walking off the left side of the screen
      if(x <= 0 && xv < 0)
      {
        x = 0;
        xv = 0;
      }
      //Stop SMS from walking off the right side of the screen
      if(x >= 860 && xv > 0)
      {
        x = 860;
        xv = 0;
      }
      if((y < 0 && !isSmall) || (y < -25 && isSmall))
      {
        yv = 0;
        y = 0;
      }
      xv += xa;
      y += yv;
      yv += ya;
      //CountDown the smallTime
      if(isSmall)
      {
        smallTime--;
      }
      //Unshrink SMS when timer runs out
      if(smallTime == 0)
      {
        isSmall = false;
        smallTime = 250;
        m.checkBlock();
      }
    }
    //pause the timer
    else if(pause)
    {
      m.pauseTimer();
    }
  }
  
  public void paint(Graphics2D g2d)
  {
    g2d.setColor(new Color(0, 255, 0));
    if(isSmall)
    {
      g2d.drawImage(img2, x, y+25, null);
    }
    else
    {
      g2d.drawImage(img, x, y, null);
    }
    
    if(display)
    {
      g2d.drawImage(instruct, 650, 75, null);
    }
    
    //paint the word paused if paused
    if(pause)
    {
      g2d.setColor(new Color(0, 255, 255));
      g2d.setFont(new Font("Aharoni", Font.BOLD, 100));
      g2d.drawString("PAUSED", 300, 450);
    }
    //paint the number of boosts
    g2d.setColor(new Color(255, 255, 255));
    g2d.setFont(new Font("Aharoni", Font.BOLD, 32));
    g2d.drawString(speedBoost + "", 75, 35);
    //g2d.setColor(new Color(255, 0, 0));
    g2d.drawString(jumpBoost + "", 175, 35);
    //g2d.setColor(new Color(0, 255, 0));
    g2d.drawString(small + "", 275, 35);
  }
  
  //Platform Collision
  public void collision(Platform m)
  {
    if(((y+48 > m.getY() && y < m.getY()+20) && (x+25 > m.getX()-5 && x+25 < m.getX()+25)) && xv > 0 && !isSmall)
    {
      xv = 0;
      x = m.getX()-25;
    }
    if(((y+48 > m.getY() && y < m.getY()+20) && (x < m.getX()+35 && x > m.getX()+5)) && xv < 0 && !isSmall)
    {
      xv = 0;
      x = m.getX()+30;
    }
    if(((x+25 > m.getX() && x < m.getX()+30) && (y+50 > m.getY()-10 && y+50 < m.getY()+25)) && yv > 0 && !isSmall)
    {
      yv = 0;
      y = m.getY()-50;
      isJumping = false;
    }
    if((x+25 > m.getX()+2 && x < m.getX()+28) && (y < m.getY()+30 && y > m.getY()+5) && !isSmall)
    {
      yv = 0;
      y = m.getY()+31;
    }
    if(((y+48 > m.getY() && y+25 < m.getY()+20) && (x+25 > m.getX()-5 && x+25 < m.getX()+25)) && xv > 0 && isSmall)
    {
      xv = 0;
      x = m.getX()-25;
    }
    if(((y+48 > m.getY() && y+25 < m.getY()+28) && (x < m.getX()+35 && x > m.getX()+5)) && xv < 0 && isSmall)
    {
      xv = 0;
      x = m.getX()+30;
    }
    if(((x+25 > m.getX() && x < m.getX()+30) && (y+50 > m.getY()-10 && y+50 < m.getY()+25)) && yv > 0 && isSmall)
    {
      yv = 0;
      y = m.getY()-50;
      isJumping = false;
    }
    if((x+25 > m.getX()+2 && x < m.getX()+28) && (y+25 < m.getY()+30 && y+25 > m.getY()+5) && isSmall)
    {
      yv = 0;
      y = m.getY()+5;
    }
  }
  
  //Reset The Level if SMS grows into a block
  public void checkBlock(Platform r)
  {
    if((x+25 > r.getX()+2 && x < r.getX()+28) && (y < r.getY()+30 && y > r.getY()))
    {
      x = 50;
      y = 815;
      xv = 0;
      yv = 0;
      xa = 0; 
      ya = 0;
      jumpBoost = levelJump;
      small = levelSmall;
      speedBoost = levelSpeed;
      smallTime = 250;
      isJumping = false;
      isSmall = false;
      m.unCollect();
      m.resetTimer();
    }
  }
  
  //Collision for Coins
  public void collision(Coin c)
  {
    if((x+25 > c.getX() && x < c.getX()+30) && (y+50 > c.getY() && y < c.getY()+40) && !isSmall)
    {
      c.collect();
    }
    else if((x+25 > c.getX() && x < c.getX()+30) && (y+50 > c.getY() && y+25 < c.getY()+40) && isSmall)
    {
      c.collect();
    }
  }
  
  public void collision(ExitDoor ed)
  {
    if((x+25 > ed.getX() && x < ed.getX()+60) && (y+50 > ed.getY() && y < ed.getY()+90) && !isSmall)
    {
      m.levelUp();
      m.rebuild();
    }
    else if((x+25 > ed.getX() && x < ed.getX()+60) && (y+50 > ed.getY() && y+25 < ed.getY()+90) && isSmall)
    {
      m.levelUp();
      m.rebuild();
    }
  }
  
  //Collision for Buttons
  public void collision(Button b)
  {
    if((x+25 > b.getX() && x < b.getX()+30) && (y+50 > b.getY() && y < b.getY()+30) && !isSmall)
    {
      b.press();
    }
    else if((x+25 > b.getX() && x < b.getX()+30) && (y+50 > b.getY() && y+25 < b.getY()+30) && isSmall)
    {
      b.press();
    }
  }
  
  public void collision(Door d)
  {
    if(d.getOrientation())
    {
      if(((y+48 > d.getY() && y < d.getY()+110) && (x+25 > d.getX()-5 && x+25 < d.getX()+25)) && xv > 0 && !isSmall)
      {
        xv = 0;
        x = d.getX()-25;
      }
      if(((y+48 > d.getY() && y < d.getY()+110) && (x < d.getX()+35 && x > d.getX()+5)) && xv < 0 && !isSmall)
      {
        xv = 0;
        x = d.getX()+30;
      }
      if(((x+25 > d.getX() && x < d.getX()+30) && (y+50 > d.getY()-10 && y+50 < d.getY()+115)) && yv > 0 && !isSmall)
      {
        yv = 0;
        y = d.getY()-50;
        isJumping = false;
      }
      if((x+25 > d.getX()+2 && x < d.getX()+28) && (y < d.getY()+120 && y > d.getY()+5) && !isSmall)
      {
        yv = 0;
        y = d.getY()+121;
      }
      if(((y+48 > d.getY() && y+25 < d.getY()+110) && (x+25 > d.getX()-5 && x+25 < d.getX()+25)) && xv > 0 && isSmall)
      {
        xv = 0;
        x = d.getX()-25;
      }
      if(((y+48 > d.getY() && y+25 < d.getY()+110) && (x < d.getX()+35 && x > d.getX()+5)) && xv < 0 && isSmall)
      {
        xv = 0;
        x = d.getX()+30;
      }
      if(((x+25 > d.getX() && x < d.getX()+30) && (y+50 > d.getY()-10 && y+50 < d.getY()+115)) && yv > 0 && isSmall)
      {
        yv = 0;
        y = d.getY()-50;
        isJumping = false;
      }
      if((x+25 > d.getX()+2 && x < d.getX()+28) && (y+25 < d.getY()+120 && y+25 > d.getY()+5) && isSmall)
      {
        yv = 0;
        y = d.getY()+5;
      }
    }
    else
    {
      if(((y+48 > d.getY() && y < d.getY()+20) && (x+25 > d.getX()-5 && x+25 < d.getX()+115)) && xv > 0 && !isSmall)
      {
        xv = 0;
        x = d.getX()-25;
      }
      if(((y+48 > d.getY() && y < d.getY()+20) && (x < d.getX()+125 && x > d.getX()+5)) && xv < 0 && !isSmall)
      {
        xv = 0;
        x = d.getX()+120;
      }
      if(((x+25 > d.getX() && x < d.getX()+120) && (y+50 > d.getY()-10 && y+50 < d.getY()+25)) && yv > 0 && !isSmall)
      {
        yv = 0;
        y = d.getY()-50;
        isJumping = false;
      }
      if((x+25 > d.getX()+2 && x < d.getX()+118) && (y < d.getY()+30 && y > d.getY()+5) && !isSmall)
      {
        yv = 0;
        y = d.getY()+31;
      }
      if(((y+48 > d.getY() && y+25 < d.getY()+20) && (x+25 > d.getX()-5 && x+25 < d.getX()+115)) && xv > 0 && isSmall)
      {
        xv = 0;
        x = d.getX()-25;
      }
      if(((y+48 > d.getY() && y+25 < d.getY()+28) && (x < d.getX()+125 && x > d.getX()+5)) && xv < 0 && isSmall)
      {
        xv = 0;
        x = d.getX()+30;
      }
      if(((x+25 > d.getX() && x < d.getX()+120) && (y+50 > d.getY()-10 && y+50 < d.getY()+25)) && yv > 0 && isSmall)
      {
        yv = 0;
        y = d.getY()-50;
        isJumping = false;
      }
      if((x+25 > d.getX()+2 && x < d.getX()+118) && (y+25 < d.getY()+30 && y+25 > d.getY()+5) && isSmall)
      {
        yv = 0;
        y = d.getY()+5;
      }
    }
  }
  
  public void collision(PlatformDoor d)
  {
    if(d.getOrientation())
    {
      if(((y+48 > d.getY() && y < d.getY()+110) && (x+25 > d.getX()-5 && x+25 < d.getX()+25)) && xv > 0 && !isSmall)
      {
        xv = 0;
        x = d.getX()-25;
      }
      if(((y+48 > d.getY() && y < d.getY()+110) && (x < d.getX()+35 && x > d.getX()+5)) && xv < 0 && !isSmall)
      {
        xv = 0;
        x = d.getX()+30;
      }
      if(((x+25 > d.getX() && x < d.getX()+30) && (y+50 > d.getY()-10 && y+50 < d.getY()+115)) && yv > 0 && !isSmall)
      {
        yv = 0;
        y = d.getY()-50;
        isJumping = false;
      }
      if((x+25 > d.getX()+2 && x < d.getX()+28) && (y < d.getY()+120 && y > d.getY()+5) && !isSmall)
      {
        yv = 0;
        y = d.getY()+121;
      }
      if(((y+48 > d.getY() && y+25 < d.getY()+110) && (x+25 > d.getX()-5 && x+25 < d.getX()+25)) && xv > 0 && isSmall)
      {
        xv = 0;
        x = d.getX()-25;
      }
      if(((y+48 > d.getY() && y+25 < d.getY()+110) && (x < d.getX()+35 && x > d.getX()+5)) && xv < 0 && isSmall)
      {
        xv = 0;
        x = d.getX()+30;
      }
      if(((x+25 > d.getX() && x < d.getX()+30) && (y+50 > d.getY()-10 && y+50 < d.getY()+115)) && yv > 0 && isSmall)
      {
        yv = 0;
        y = d.getY()-50;
        isJumping = false;
      }
      if((x+25 > d.getX()+2 && x < d.getX()+28) && (y+25 < d.getY()+120 && y+25 > d.getY()+5) && isSmall)
      {
        yv = 0;
        y = d.getY()+5;
      }
    }
    else
    {
      if(((y+48 > d.getY() && y < d.getY()+20) && (x+25 > d.getX()-5 && x+25 < d.getX()+115)) && xv > 0 && !isSmall)
      {
        xv = 0;
        x = d.getX()-25;
      }
      if(((y+48 > d.getY() && y < d.getY()+20) && (x < d.getX()+125 && x > d.getX()+5)) && xv < 0 && !isSmall)
      {
        xv = 0;
        x = d.getX()+120;
      }
      if(((x+25 > d.getX() && x < d.getX()+120) && (y+50 > d.getY()-10 && y+50 < d.getY()+25)) && yv > 0 && !isSmall)
      {
        yv = 0;
        y = d.getY()-50;
        isJumping = false;
      }
      if((x+25 > d.getX()+2 && x < d.getX()+118) && (y < d.getY()+30 && y > d.getY()+5) && !isSmall)
      {
        yv = 0;
        y = d.getY()+31;
      }
      if(((y+48 > d.getY() && y+25 < d.getY()+20) && (x+25 > d.getX()-5 && x+25 < d.getX()+115)) && xv > 0 && isSmall)
      {
        xv = 0;
        x = d.getX()-25;
      }
      if(((y+48 > d.getY() && y+25 < d.getY()+28) && (x < d.getX()+125 && x > d.getX()+5)) && xv < 0 && isSmall)
      {
        xv = 0;
        x = d.getX()+30;
      }
      if(((x+25 > d.getX() && x < d.getX()+120) && (y+50 > d.getY()-10 && y+50 < d.getY()+25)) && yv > 0 && isSmall)
      {
        yv = 0;
        y = d.getY()-50;
        isJumping = false;
      }
      if((x+25 > d.getX()+2 && x < d.getX()+118) && (y+25 < d.getY()+30 && y+25 > d.getY()+5) && isSmall)
      {
        yv = 0;
        y = d.getY()+5;
      }
    }
  }
  
  public static BufferedImage horizontalFlip(BufferedImage img)
  {
    int w = 25;
    int h = img.getHeight();
    BufferedImage sms = new BufferedImage(w, h, img.getType());
    Graphics2D g = sms.createGraphics();
    g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);
    g.dispose();
    return sms;
  }
  
  public static void keyReleased(KeyEvent e) 
  {
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      pause = !pause;
    }
    //Set momentum to zero when key is released
    if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT && !pause)
    {
      xv = 0;
      xa = 0;
    }
  }
  
  public static void keyPressed(KeyEvent e)
  {
    //Jump
    if (e.getKeyCode() == KeyEvent.VK_UP && !pause)
    {
      if(!isJumping)
      {
        //Jump based on height
        if(!isSmall)
        {
          yv = -15;
        }
        else
        {
          yv = -10;
        }
        y += 1;
        isJumping = true;
      }
    }
    //SpeedBoost
    if (e.getKeyCode() == KeyEvent.VK_Q && !pause)
    {
      if(speedBoost > 0 && xv != 0)
      {
        if(xv > 0)
        {
          xv = 3;
        }
        else
        {
          xv = -3;
        }
        xv = 10*xv;
        speedBoost--;
      }
    }
    //Reset level
    if (e.getKeyCode() == KeyEvent.VK_R && !pause)
    {
      x = 50;
      y = 815;
      xv = 0;
      yv = 0;
      xa = 0; 
      ya = 0;
      jumpBoost = levelJump;
      small = levelSmall;
      speedBoost = levelSpeed;
      smallTime = 250;
      isJumping = false;
      isSmall = false;
      m.unCollect();
      m.resetTimer();
    }
    //Jump Boost
    if (e.getKeyCode() == KeyEvent.VK_W && !pause)
    {
      if(jumpBoost > 0)
      {
        if(!isSmall)
        {
          yv = -25;
        }
        else
        {
          yv = -15;
        }
        y += 1;
        isJumping = true;
        jumpBoost--;
      }
    }
    //Shrink
    if (e.getKeyCode() == KeyEvent.VK_E && !pause)
    {
      if(small > 0 && !isSmall)
      {
        isSmall = true;
        small--;
      }
    }
    //Walk Left
    if (e.getKeyCode() == KeyEvent.VK_LEFT && !pause)
    {
      if (facingRight)
      {
        img = horizontalFlip(img);
        img2 = horizontalFlip(img2);
        xa = -1;
        facingRight = false;
      }
      else 
      {
        xa = -1;
      }
    }
    //Walk Right
    if (e.getKeyCode() == KeyEvent.VK_RIGHT && !pause)
    {
      if (!facingRight)
      {
        img = horizontalFlip(img);
        img2 = horizontalFlip(img2);
        xa = 1;
        facingRight = true;
      }
      else
      {
        xa = 1;
      }
    }
    if(e.getKeyCode() == KeyEvent.VK_I)
    {
      display = !display;
    }
  }
}