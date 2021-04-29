package visual.entities;

import java.awt.*;

public class EnemyProjectile2D
{
    public void draw(int[] loc, Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(0,255,0));
        g2d.fillRect(loc[0]+8,loc[1],10,10);
        Toolkit.getDefaultToolkit().sync();
    }
}
