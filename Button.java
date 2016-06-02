import java.awt.*;

public class Button
{
  private MoonWalker m;
  private int x;
  private int y;
  private int color;
  private boolean pressed = false;
  private int pressTime = 250;
  public Button(MoonWalker m, int x, int y, int color)
  {
    this.m = m;
    this.x = x;
    this.y = y;
    this.color = color;
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
      pressTime = 250;
    }
  }
  
  public void paint(Graphics g2d) 
  { 
    //Paint based on color
    if(color == 0)
    {
      g2d.setColor(new Color(0, 0, 150)); 
    }
    if(color == 1)
    {
      g2d.setColor(new Color(150, 0, 150)); 
    }
    if(color == 2)
    {
      g2d.setColor(new Color(150, 0, 0)); 
    }
    if(color == 3)
    {
      g2d.setColor(new Color(0, 150, 0)); 
    }
    if(!pressed)
    {
      g2d.fillRect(x, y, 30, 30); 
    }
  }
}