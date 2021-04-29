package visual.entities;

import java.awt.*;

public class PlayerProjectile2D
{
    public void draw(int[] loc, Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(255,0,0));
        g2d.fillRect(loc[0]+10,loc[1]-10,5,5);
        Toolkit.getDefaultToolkit().sync();
    }
}
