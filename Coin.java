import java.awt.*; 
import java.awt.event.KeyEvent; 
import java.awt.image.BufferedImage; 
import javax.imageio.*; 
import java.io.*; 

public class Coin
{
  int x;
  int y;
  MoonWalker m;
  boolean isCollected = false;
  
  public Coin(MoonWalker m, int x, int y)
  {
    this.m = m;
    this.x = x;
    this.y = y;
  }
  
  public int getX()
  {
    return x;
  }
  
  public int getY()
  {
    return y;
  }
  
  public void collect()
  {
    isCollected = true;
  }
  
  public void unCollect()
  {
    isCollected = false;
  }
  
   public void paint(Graphics g2d) 
  {
    g2d.setColor(new Color(150, 0, 150)); 
    if(isCollected)
    {
      g2d.fillOval(800, 20, 30, 40); 
    }
    else
    {
      g2d.fillOval(x, y, 30, 40); 
    }
  }
}
  
  
    