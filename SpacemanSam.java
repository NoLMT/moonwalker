import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class SpacemanSam
{
  static int x = 50;
  static int y = 815;
  static int xv = 0;
  static int yv = 0;
  static int xa = 0; 
  static int ya = 0;
  static int jumpBoost = 2;
  static int small = 2;
  static int speedBoost = 2;
  static int smallTime = 250;
  static boolean isJumping = false;
  static boolean isSmall = false;
  MoonWalker m;
  
  public SpacemanSam(MoonWalker m)
  {
    this.m = m;
  }
  
  public void move()
  {
    if(isJumping)
    {
    ya = 1;
    }
    x += xv;
    if(xv > 2)
    {
      xv -= 2;
    }
    else if(xv < -2)
    {
      xv += 2;
    }
    if(y >= 815 && yv > 0)
    {
      ya = 0;
      yv = 0;
      y = 815;
      isJumping = false;
    }
    if(x <= 0 && xv < 0)
    {
      x = 0;
      xv = 0;
    }
    if(x >= 860 && xv > 0)
    {
      x = 860;
      xv = 0;
    }
    xv += xa;
    y += yv;
    yv += ya;
    if(isSmall)
    {
      smallTime--;
    }
    if(smallTime == 0)
    {
      isSmall = false;
      smallTime = 250;
    }
  }
  
  public void paint(Graphics2D g2d)
  {
    g2d.setColor(new Color(0, 255, 0));
    if(!isSmall)
    {
      g2d.fillRect(x, y, 25, 50);
    }
    else
    {
      g2d.fillRect(x, y+25, 25, 25);
    }
  }
  
  public static void keyReleased(KeyEvent e) 
  {
    if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      xv = 0;
      xa = 0;
    }
  }
  
  public static void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      if(!isJumping)
      {
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
    }
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
    if (e.getKeyCode() == KeyEvent.VK_E)
    {
      if(small > 0 && !isSmall)
      {
        isSmall = true;
        small--;
      }
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      xa = -1;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      xa = 1;
    }
  }
}