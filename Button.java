import java.awt.*;
import java.awt.image.BufferedImage; 
import javax.imageio.*; 
import java.io.*; 

public class Button
{
  private MoonWalker m;
  private int x;
  private int y;
  private int color;
  private boolean pressed = false;
  private int pressTime = 500;
  private BufferedImage ispressed = null;
  private BufferedImage unpressed = null;
  
  public Button(MoonWalker m, int x, int y, int color)
  {
    this.m = m;
    this.x = x;
    this.y = y;
    this.color = color;
    
    if(color == 0)
    {
      try
       {
         unpressed = ImageIO.read(new File("Button Blue.png"));
       } catch (IOException e)
       {
         System.out.println("No Image");
       }
       try
       {
         ispressed = ImageIO.read(new File("Button Blue Pressed.png"));
       } catch (IOException e)
       {
         System.out.println("No Image");
       }
    }
    else if(color == 1)
    {
      try
      {
        unpressed = ImageIO.read(new File("Button Purple.png"));
      } catch (IOException e)
      {
        System.out.println("No Image");
      }
      try
      {
        ispressed = ImageIO.read(new File("Button Purple Pressed.png"));
      } catch (IOException e)
      {
        System.out.println("No Image");
      }
    }
    else if(color == 2)
    {
      try
      {
        unpressed = ImageIO.read(new File("Button Red.png"));
      } catch (IOException e)
      {
        System.out.println("No Image");
      }
      try
      {
        ispressed = ImageIO.read(new File("Button Red Pressed.png"));
      } catch (IOException e)
      {
        System.out.println("No Image");
      }
    }
    else if(color == 3)
    {
     try
     {
       unpressed = ImageIO.read(new File("Button Green.png"));
     } catch (IOException e)
     {
       System.out.println("No Image");
     }
     try
     {
       ispressed = ImageIO.read(new File("Button Green Pressed.png"));
     } catch (IOException e)
     {
       System.out.println("No Image");
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
  
  public boolean getPressed()
  {
    return pressed;
  }
  
  public void press()
  {
    pressed = true;
  }
  
  public void pressed(boolean button)
  {
    pressed = button;
  }
  
  public void unPress()
  {
    pressed = false;
  }
  
  public void timeDown()
  {
    //Countdown the button timer
    pressTime--;
    if(pressTime == 0)
    {
      pressed = false;
      pressTime = 500;
    }
  }
  
  public void paint(Graphics g2d) 
  { 
    if(pressed)
    {
      g2d.drawImage(ispressed, x, y+5, null);
    }
    else
    {
      g2d.drawImage(unpressed, x, y, null);
    }
    
    /*
    //Paint based on color
    if(color == 0) // blue
    {
      g2d.setColor(new Color(0, 0, 150)); 
    }
    if(color == 1) // purple
    {
      g2d.setColor(new Color(150, 0, 150)); 
    }
    if(color == 2) // red
    {
      g2d.setColor(new Color(150, 0, 0)); 
    }
    if(color == 3) // green
    {
      g2d.setColor(new Color(0, 150, 0)); 
    }
    if(!pressed)
    {
      g2d.fillRect(x, y, 30, 30); 
    } */
  }
}