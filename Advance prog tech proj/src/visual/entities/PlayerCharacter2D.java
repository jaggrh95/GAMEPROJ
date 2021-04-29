package visual.entities;

import java.awt.*;

public class PlayerCharacter2D {

    public void draw(int[] loc,Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(0,0,0));
        g2d.fillRect(0,0,1920,900);
        g2d.setColor(new Color(255,255,255));

        g2d.fillRect(loc[0],loc[1],5,5);
        for(int j=0;j < 3; j++)
        {
            for (int i=0; i<5-(j*2); i++)
            {
                g2d.fillRect(loc[0]+i*5+j*5,loc[1]-5*j,5,5);

            }
        }

        Toolkit.getDefaultToolkit().sync();
    }
}
