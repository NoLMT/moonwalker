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
  public Platform(MoonWalker m, int x, int y)
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
  public void paint(Graphics g2d)
  {
    g2d.setColor(new Color(0, 255, 255));
    g2d.fillRect(x, y, 30, 30);
  }
} 