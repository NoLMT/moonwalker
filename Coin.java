import java.awt.*; 
import java.awt.image.BufferedImage; 
import javax.imageio.*; 
import java.io.*; 

public class Coin
{
  private BufferedImage img = null;
  int x;
  int y;
  MoonWalker m;
  boolean isCollected = false;
  //Which coin is it
  int coinNum;
  
  public Coin(MoonWalker m, int x, int y, int coinNum)
  {
    this.m = m;
    this.x = x;
    this.y = y;
    this.coinNum = coinNum;
     try
     {
       img = ImageIO.read(new File("Coin.png"));
     } catch (IOException e)
     {
       System.out.println("No Image");
     }
  }
  
  public int getX()
  {
    return x;
  }
  
  public int getY()
  {
    return y;
  }
  
  //Collect the coin
  public void collect()
  {
    isCollected = true;
  }
  
  //Reset Coins
  public void unCollect()
  {
    isCollected = false;
  }
  
   public void paint(Graphics g2d) 
  {
     if(isCollected && coinNum == 0)
     {
       g2d.drawImage(img, 640, 10, null);
     }
     else if(isCollected && coinNum == 1)
     {
       g2d.drawImage(img, 700, 10, null);
     }
     else if(isCollected && coinNum == 2)
     {
       g2d.drawImage(img, 580, 10, null);
     }
     else
     {
       g2d.drawImage(img, x, y, null);
     }
  }
}