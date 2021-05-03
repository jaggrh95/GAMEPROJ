package visual.entities;

import java.awt.*;

public class EnemyProjectile2D
{
    public void draw(int[] locc, Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        if(locc[2] == 0)
        {
            g2d.setColor(new Color(100,255,100));
            g2d.fillRect(locc[0]+8,locc[1],10,10);
        }
        else if(locc[2] == 1)
        {
            g2d.setColor(new Color(0,0,150));
            g2d.fillRect(locc[0]+8,locc[1],10,10);

        }
        else if(locc[2] == 2)
        {
            g2d.setColor(new Color(255,255,0));
            g2d.fillRect(locc[0]+8,locc[1]-8,5,5);
            g2d.fillRect(locc[0]+4,locc[1]-4,5,5);
            g2d.fillRect(locc[0]+8,locc[1],5,5);
            g2d.fillRect(locc[0]+4,locc[1]+4,5,5);
            g2d.fillRect(locc[0]+8,locc[1]+8,5,5);
            g2d.fillRect(locc[0]+4,locc[1]+12,5,5);


        }
        else if(locc[2] == 3)
        {
            g2d.setColor(new Color(255,30,40));
            g2d.fillRect(locc[0]+8,locc[1],10,10);

        }

        Toolkit.getDefaultToolkit().sync();
    }
}
