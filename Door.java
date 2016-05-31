import java.awt.*;

public class Door
{
  private MoonWalker m;
  private int x;
  private int y;
  private int color;
  private boolean open = false;
  public Door(MoonWalker m, int x, int y, int color)
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
  
  public boolean getOpen()
  {
    return open;
  }
  
  public void open(boolean button)
  {
    open = button;
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
    if(!open)
    {
    g2d.fillRect(x, y, 30, 120); 
    }
  }
}