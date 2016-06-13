import java.awt.*;
import java.awt.image.BufferedImage; 
import javax.imageio.*; 
import java.io.*; 

public class Door
{
  private MoonWalker m;
  private int x;
  private int y;
  private int color;
  private boolean open = false;
  private boolean orientation = false;
  private BufferedImage vertical = null;
  private BufferedImage horizontal = null;
  public Door(MoonWalker m, int x, int y, int color, boolean orientation)
  {
    this.m = m;
    this.x = x;
    this.y = y;
    this.color = color;
    this.orientation = orientation;
    
    if(color == 0)
    {
      if(orientation) // true is vertical, false is horizontal
      {
        try
        {
          vertical = ImageIO.read(new File("Door Blue.png"));
        } catch (IOException e)
        {
          System.out.println("No Image");
        }
      }
      else
      {
        try
        {
          horizontal = ImageIO.read(new File("Door Blue Horizontal.png"));
        } catch (IOException e)
        {
          System.out.println("No Image");
        }
      }
    }
    else if(color == 1)
    {
      if(orientation) // true is vertical, false is horizontal
      {
        try
        {
          vertical = ImageIO.read(new File("Door Purple.png"));
        } catch (IOException e)
        {
          System.out.println("No Image");
        }
      }
      else
      {
        try
        {
          horizontal = ImageIO.read(new File("Door Purple Horizontal.png"));
        } catch (IOException e)
        {
          System.out.println("No Image");
        }
      }
    }
    else if(color == 2)
    {
      if(orientation) // true is vertical, false is horizontal
      {
        try
        {
          vertical = ImageIO.read(new File("Door Red.png"));
        } catch (IOException e)
        {
          System.out.println("No Image");
        }
      }
      else
      {
        try
        {
          horizontal = ImageIO.read(new File("Door Red Horizontal.png"));
        } catch (IOException e)
        {
          System.out.println("No Image");
        }
      }
    }
    else if(color == 3)
    {
      if(orientation)
      {
        try
        {
          vertical = ImageIO.read(new File("Door Green.png"));
        } catch (IOException e)
        {
          System.out.println("No Image");
        }
      }
      else
      {
        try
        {
          horizontal = ImageIO.read(new File("Door Green Horizontal.png"));
        } catch (IOException e)
        {
          System.out.println("No Image");
        }
      }
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
  
  public int getColor()
  {
    return color;
  }
  
  public boolean getOpen()
  {
    return open;
  }
  
  public boolean getOrientation()
  {
    return orientation;
  }
  
  public void open(boolean button)
  {
    open = button;
  }
  
  public void paint(Graphics g2d) 
  { 
    if(!open)
    {
      if(orientation)
      {
        g2d.drawImage(vertical, x, y, null);
      }
      else
      {
        g2d.drawImage(horizontal, x, y, null);
      }
    }
  }
}