import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class Platform
{
   //px and py meaning platform x and y
   private int px;
   private int py;
   public Platform(int x, int y)
   {
      px = x;
      py = y;
   }
   public void paint(Graphics g2d)
   {
      g2d.setColor(new Color(0, 255, 255));
      g2d.fillRect(px, py, 30, 30);
   }
}

