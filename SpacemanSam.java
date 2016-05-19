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
  static int jumpBoost = 2;
  //Number of Shink Powers
  static int small = 20;
  //Number of Speed Boosts
  static int speedBoost = 20;
  //Time spent small
  static int smallTime = 250;
  //Test if Jumping
  static boolean isJumping = false;
  //Test if Small
  static boolean isSmall = false;
  static MoonWalker m;
  
  public SpacemanSam(MoonWalker m)
  {
    this.m = m;
  }
  
  public void move()
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
    //Stop SMS from moving to quickly
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
    }
  }
  
  public void paint(Graphics2D g2d)
  {
    g2d.setColor(new Color(0, 255, 0));
    //Paint based on size
    if(!isSmall)
    {
      g2d.fillRect(x, y, 25, 50);
    }
    else
    {
      g2d.fillRect(x, y+25, 25, 25);
    }
  }
  
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
  
  public static void keyReleased(KeyEvent e) 
  {
    //Set momentum to zero when key is released
    if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      xv = 0;
      xa = 0;
    }
  }
  
  public static void keyPressed(KeyEvent e)
  {
    //Jump
    if (e.getKeyCode() == KeyEvent.VK_UP)
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
    if (e.getKeyCode() == KeyEvent.VK_Q)
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
    if (e.getKeyCode() == KeyEvent.VK_R)
    {
      x = 50;
      y = 815;
      xv = 0;
      yv = 0;
      xa = 0; 
      ya = 0;
      jumpBoost = 2;
      small = 2;
      speedBoost = 2;
      smallTime = 250;
      isJumping = false;
      isSmall = false;
      m.unCollect();
    }
    //Jump Boost
    if (e.getKeyCode() == KeyEvent.VK_W)
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
    if (e.getKeyCode() == KeyEvent.VK_E)
    {
      if(small > 0 && !isSmall)
      {
        isSmall = true;
        small--;
      }
    }
    //Walk Left
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      xa = -1;
    }
    //Walk Right
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      xa = 1;
    }
  }
}