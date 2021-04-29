package visual.entities;

import java.awt.*;

public class EnemyCharacter2D
{
    int enemyID;
    int[] xy;
    public EnemyCharacter2D(int eid)
    {
        this.enemyID = eid;

    }

    public void setXy(int[] xy) {
        this.xy = xy;
    }
    public void draw(int[] loc, Graphics g,int type)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(255,255,255));

        if(type == 0)
        {

            g2d.fillRect(loc[0],loc[1]-15,5,5);
            g2d.fillRect(loc[0]+5, loc[1]-15,5,5);
            g2d.fillRect(loc[0]-5, loc[1]-15,5,5);
            g2d.fillRect(loc[0],loc[1]-10,5,5);
            for(int j=1;j <= 2; j++)
            {
                g2d.fillRect(loc[0]+j*5, loc[1]-10,5,5);
                g2d.fillRect(loc[0]-j*5, loc[1]-10,5,5);
            }

            g2d.fillRect(loc[0],loc[1]-5,5,5);

            g2d.fillRect(loc[0]+10, loc[1]-5,5,5);
            g2d.fillRect(loc[0]-10, loc[1]-5,5,5);


            g2d.fillRect(loc[0],loc[1],5,5);
            for(int j=1;j <= 2; j++)
            {
                g2d.fillRect(loc[0]+j*5, loc[1],5,5);
                g2d.fillRect(loc[0]-j*5, loc[1],5,5);
            }
            g2d.fillRect(loc[0], loc[1]+5,5,5);
            for(int j=1;j <= 3; j++)
            {
                g2d.fillRect(loc[0]+j*5, loc[1]+5,5,5);
                g2d.fillRect(loc[0]-j*5, loc[1]+5,5,5);

            }

        }
        else if(type == 1)
        {
            g2d.setColor(new Color(255,255,255));




            g2d.fillRect(loc[0],loc[1],5,5);
            for(int i = 0;i < 3;i++)
            {
                g2d.fillRect(loc[0]+5, loc[1]-(5*i),5,5);
                g2d.fillRect(loc[0]-5, loc[1]-(5*i),5,5);
            }
            for(int i = 0; i < 2;i++)
            {
                g2d.fillRect(loc[0]+10-(i*5), loc[1]-15,5,5);
                g2d.fillRect(loc[0]-10+(i*5), loc[1]-15,5,5);
            }


            g2d.fillRect(loc[0]+15, loc[1],5,5);
                g2d.fillRect(loc[0]-15, loc[1],5,5);



            for(int j=1;j <= 3; j++)
            {
                g2d.fillRect(loc[0]+j*5, loc[1]+5,5,5);
                g2d.fillRect(loc[0]-j*5, loc[1]+5,5,5);

            }
            g2d.setColor(new Color(255,0,0));

            g2d.fillRect(loc[0]+5, loc[1]-20,5,5);
            g2d.fillRect(loc[0]-5, loc[1]-20,5,5);
        }
        else
        {
            g2d.setColor(new Color(0,120,255));

            g2d.fillRect(loc[0],loc[1]-15,5,5);
            g2d.fillRect(loc[0]+5, loc[1]-15,5,5);
            g2d.fillRect(loc[0]-5, loc[1]-15,5,5);
            g2d.fillRect(loc[0],loc[1]-10,5,5);
            for(int j=1;j <= 2; j++)
            {
                g2d.fillRect(loc[0]+j*5, loc[1]-10,5,5);
                g2d.fillRect(loc[0]-j*5, loc[1]-10,5,5);
            }

            g2d.fillRect(loc[0],loc[1]-5,5,5);

            g2d.fillRect(loc[0]+10, loc[1]-5,5,5);
            g2d.fillRect(loc[0]-10, loc[1]-5,5,5);


            g2d.fillRect(loc[0],loc[1],5,5);
            for(int j=1;j <= 2; j++)
            {
                g2d.fillRect(loc[0]+j*5, loc[1],5,5);
                g2d.fillRect(loc[0]-j*5, loc[1],5,5);
            }
            g2d.fillRect(loc[0], loc[1]+5,5,5);
            for(int j=1;j <= 3; j++)
            {
                g2d.fillRect(loc[0]+j*5, loc[1]+5,5,5);
                g2d.fillRect(loc[0]-j*5, loc[1]+5,5,5);

            }
        }


        Toolkit.getDefaultToolkit().sync();
    }
}
