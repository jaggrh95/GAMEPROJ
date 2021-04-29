package visual;

import com.company.entities.EnemyCharacter;
import com.company.entities.PlayerCharacter;
import visual.entities.EnemyCharacter2D;
import visual.entities.PlayerCharacter2D;
import com.company.Game;
import visual.factories.Enemy2DFactory;
import visual.factories.EnemyProjectileFact2D;
import visual.factories.Projectile2DFact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Visualisation extends JPanel implements ActionListener
{
    private Timer timer;
    PlayerCharacter2D P = new PlayerCharacter2D();
    Enemy2DFactory E2DF = new Enemy2DFactory();
    Projectile2DFact PR2DF = new Projectile2DFact();
    EnemyProjectileFact2D EPR2DF = new EnemyProjectileFact2D();
    private JLabel statusbar;

    Vector<Integer> EIDHolder = new Vector<Integer>();

    Vector<EnemyCharacter2D> E = new Vector<EnemyCharacter2D>();
    Game GAME;



    public Visualisation(Game G,vis parent) {
        statusbar = parent.getStatusBar();
        statusbar.setText("Press CTRL to start");
        GAME = G;
        setFocusable(true);
        timer = new Timer(2, this);
        timer.start();  // start timer (activates actionPerformed)
        addKeyListener(new TAdapter()); // activate key input


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int[] A = new int[2];
        Vector<EnemyCharacter2D> E = new Vector<EnemyCharacter2D>();
        Graphics2D g2d = (Graphics2D) g;

        A = GAME.getPlayerpos();
        EIDHolder = GAME.GetAllEIDS();
        P.draw(A,g2d);
        for(int i = 0; i < GAME.enemyCount;i++)
        {
            E.add(E2DF.getEnemy(EIDHolder.get(i)));
            E.get(i).draw(GAME.GetSpecifiedEnemyLocation(EIDHolder.get(i)),g2d,GAME.getEnemyType(EIDHolder.get(i)));
        }
        if(GAME.PProjectileExists)
        {
            PR2DF.CreateProj().draw(GAME.getPlayerProjectilePos(),g2d);
        }
        if(GAME.EProjectileExists)
        {
            EPR2DF.getEProjectile().draw(GAME.getEnemyProjectilePos(),g2d);
        }
        if(GAME.paused)
        {
            statusbar.setText("PAUSED::::SCORE:" + GAME.score);

        }
        else
        {
            statusbar.setText("SCORE:" + GAME.score);

        }

        g2d.dispose();


    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int keycode = e.getKeyCode();
            switch (keycode) {
                case KeyEvent.VK_LEFT:
                    GAME.CS.setLeft(true);
                    break;
                case KeyEvent.VK_RIGHT:
                    GAME.CS.setRight(true);
                    break;

                case KeyEvent.VK_SPACE:
                    GAME.CS.setSpace(true);
                    break;

                case KeyEvent.VK_CONTROL:
                    GAME.CS.setControl(true);
                    break;
            }
        }
    }
}
