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
  int coinNum;
  
  public Coin(MoonWalker m, int x, int y, int coinNum)
  {
    this.m = m;
    this.x = x;
    this.y = y;
    this.coinNum = coinNum;
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
    if(isCollected && coinNum == 0)
    {
      g2d.fillOval(750, 20, 30, 40); 
    }
    else if(isCollected && coinNum == 1)
    {
      g2d.fillOval(800, 20, 30, 40); 
    }
    else if(isCollected && coinNum == 2)
    {
      g2d.fillOval(850, 20, 30, 40); 
    }
    else
    {
      g2d.fillOval(x, y, 30, 40); 
    }
  }
}
  
  
    