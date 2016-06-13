import java.awt.*; 
import java.awt.event.KeyEvent; 
import java.awt.image.BufferedImage; 
import javax.imageio.*; 
import java.io.*; 

public class Platform 
{ 

  private int x; 
  private int y; 
  MoonWalker m;
  private BufferedImage img = null;
  
  public Platform(MoonWalker m, int x, int y) 
  { 
    this.m = m;
    this.x = x; 
    this.y = y; 
    
   try
    {
      img = ImageIO.read(new File("Platform.png"));
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
  
  public void paint(Graphics g2d) 
  { 
    g2d.drawImage(img, x, y, null);
  } 
} 