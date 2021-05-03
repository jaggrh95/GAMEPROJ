package com.company;
import com.company.entities.*;
import com.company.factories.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Game implements ActionListener
{
    //Entity list
    private Vector<Entity> Entlist;

    //Timing off the game
    public Timer timer;

    //Factories
    private PlayerFactory PLF = new PlayerFactory();
    private EnemyFactory EF = new EnemyFactory();
    private PlayerProjectileFactory PPF = new PlayerProjectileFactory();
    private EnemyProjectileFactory EPF = new EnemyProjectileFactory();

    //control class
    public Controls CS = new Controls();

    //keeps score
    public int score = 0;

    //used in procjectilestates and interaction
    public boolean PProjectileExists = false;
    public boolean EProjectileExists = false;
    private int enemytypecounter = 0;
    private Boolean left = false;

    //used for enemy movement
    private int counter = 0;
    private boolean enemyDirectionRight = true;


    //Variables for enemies
    public int enemyCount = 0;
    private int enemycountstart = 0;
    private int highestEID = 0;
    private int lowestEID = 99999;

    //used for player
    private Entity PLAYPROJHOLD;
    public int[] playerPos = new int[2];
    private  boolean alive;
    public int lives = 3;
    private int deadcounter = 0;

    //screen size and paused variable
    public boolean paused = true;
    private  int SCREEN_WIDTH,SCREEN_HEIGHT;

    //Constructor
    //will prepare inital variables depending on giving parameters
    public Game(int w,int h)
    {
        SCREEN_HEIGHT = h;
        SCREEN_WIDTH = w;
        Entlist = new Vector<Entity>();
        timer = new Timer(50,this);
        Setup();
        timer.start();
    }

    //Setup
    //Sets up the enemies and player
    public void Setup()
    {
        Entity player = PLF.CreatePlayer(SCREEN_WIDTH,SCREEN_HEIGHT);
        Entlist.add(player);
        playerPos[0] = player.locationX;
        playerPos[1] = player.locationY;

        for(int i = 0; i < 12 ; i++)
        {
            for(int j = 0; j < 4;j++)
            {
                Entlist.add(EF.CreateEnemy(20 + (40*i),30 + (60*j),1+enemyCount,j));
                enemyCount++;

            }
        }
        getNewEIDs();
        enemycountstart = enemyCount;

    }

    //SpawnPlayer
    //Used in initial setup and for respawning after death
    void ReSpawnPlayer()
    {

        for(int i =0; i < Entlist.size();i++)
        {
            if(Entlist.get(i) instanceof PlayerCharacter)
            {
                Entlist.get(i).locationY = SCREEN_HEIGHT - 100;
                Entlist.get(i).locationX = SCREEN_WIDTH/2;
                ((PlayerCharacter) Entlist.get(i)).setAlive(true);
            }
        }

        playerPos[0] = SCREEN_WIDTH/2;
        playerPos[1] = SCREEN_HEIGHT-100;
        alive = true;

    }

    //Collision
    //checks for any collision between projectiles and other entities
    void Collision()
    {
        for (int i = 0;i < Entlist.size();i++)
        {
            for (int j = 0;j < Entlist.size();j++)
            {
                if(Entlist.get(i) instanceof EnemyCharacter && Entlist.get(j) instanceof PlayerProjectile &&Entlist.get(i).locationX >= Entlist.get(j).locationX-15 && Entlist.get(i).locationX <= Entlist.get(j).locationX+25 && Entlist.get(i).locationY >= Entlist.get(j).locationY-20 && Entlist.get(i).locationY <= Entlist.get(j).locationY+5 && i != j)
                {
                        if(((EnemyCharacter) Entlist.get(i)).EnemyID == highestEID || ((EnemyCharacter) Entlist.get(i)).EnemyID == lowestEID)
                        {

                            Entlist.remove(Entlist.get(i));
                            Entlist.remove(PLAYPROJHOLD);
                            highestEID = 0;
                            lowestEID = 99999;
                            getNewEIDs();
                            enemyCount--;

                        }
                        else
                        {
                            Entlist.remove(Entlist.get(i));
                            Entlist.remove(PLAYPROJHOLD);

                            enemyCount--;
                        }
                        PProjectileExists = false;
                        score = score + 20;
                        break;
                    }
                    if(Entlist.get(i) instanceof PlayerCharacter && Entlist.get(j) instanceof EnemyProjectile&&Entlist.get(i).locationX >= Entlist.get(j).locationX-20 && Entlist.get(i).locationX <= Entlist.get(j).locationX+25 && Entlist.get(i).locationY >= Entlist.get(j).locationY-20 && Entlist.get(i).locationY <= Entlist.get(j).locationY+20 && i != j) {
                     {
                         ((PlayerCharacter) Entlist.get(i)).kill();
                            Entlist.remove(j);
                            EProjectileExists = false;

                        }
                    }
                }
            }


    }

    //InteractionProjectile method
    //Handles speed of projectiles, visibility and movement depending on type of projectile
    void InteractionProjectile()
    {
        if(EProjectileExists)
        {
            for(int i = 0; i < Entlist.size();i++)
            {
                if(Entlist.get(i) instanceof EnemyProjectile)
                {
                    if(((EnemyProjectile) Entlist.get(i)).getType() == 2)
                    {
                        enemytypecounter++;
                        if(enemytypecounter == 10)
                        {
                            if(left)
                            {
                                ((EnemyProjectile) Entlist.get(i)).changeX(-20);
                                left = !left;

                            }
                            else
                            {

                                ((EnemyProjectile) Entlist.get(i)).changeX(20);
                                left = !left;
                            }
                            enemytypecounter = 0;

                        }
                        ((EnemyProjectile) Entlist.get(i)).changeY(((EnemyProjectile) Entlist.get(i)).getType() + 4 * 2);
                    }
                    else
                    {
                        ((EnemyProjectile) Entlist.get(i)).changeY(((EnemyProjectile) Entlist.get(i)).getType()+4 * 2);

                    }
                    if(Entlist.get(i).locationY >= SCREEN_HEIGHT)
                    {
                        Entlist.remove(i);
                        EProjectileExists = false;
                    }
                }
            }
        }
        if(PProjectileExists)
        {
            for(int i = 0; i < Entlist.size();i++)
            {
                if(Entlist.get(i) instanceof PlayerProjectile)
                {
                    ((PlayerProjectile) Entlist.get(i)).changeY(-10);
                    if(Entlist.get(i).locationY <= 10)
                    {
                        Entlist.remove(i);
                        score = score - 5;
                        PProjectileExists = false;
                    }
                }
            }
        }

    }

    //State method
    //Checks all inputs for any key presses and updates game accordingly
    void State()
    {
        if(CS.isCtrl())
        {
            CS.setControl(false);
            paused = !paused;
        }
        if((CS.isLeft() || CS.isRight()) && !paused)
        {
            for(int i = 0; i < Entlist.size();i++)
            {
                if(Entlist.get(i) instanceof PlayerCharacter)
                {
                    if(CS.isRight())
                    {
                        if(Entlist.get(i).locationX < SCREEN_WIDTH + 60)
                        {
                            Entlist.get(i).locationX += 10;
                        }
                        CS.setRight(false);

                    }
                    else
                    {
                        if(Entlist.get(i).locationX > 0)
                        {
                            Entlist.get(i).locationX -= 10;
                        }
                        CS.setLeft(false);

                    }
                    playerPos[0] = Entlist.get(i).locationX;

                }
            }
        }

        if((!PProjectileExists && CS.isSpace()) && !paused)
        {
            for(int i = 0; i < Entlist.size();i++)
            {
                if(Entlist.get(i) instanceof PlayerCharacter)
                {
                    PProjectileExists = true;
                    PLAYPROJHOLD = PPF.CreateProjectile(Entlist.get(i).locationX,Entlist.get(i).locationY);
                    Entlist.add(PLAYPROJHOLD);
                }
            }

        }
        CS.setSpace(false);

    }

    //UpdateEnemies()
    //Updates enemies and enemy projectiles
    void UpdateEnemies()
    {
        counter++;
        if(counter == 20)
        {
            EnemyMoves();
            counter = 0;
        }
        EnemyProjectileState();

    }

    //EnemeyprojectileState()
    //Checks wether or not an enemy bullet has been fired and more are allowed.
    void EnemyProjectileState()
    {
        if(!EProjectileExists && !paused)
        {
            int randomNum = ThreadLocalRandom.current().nextInt(1, enemycountstart + 1);
            for(int i = 0;i < Entlist.size();i++)
            {
                if(Entlist.get(i) instanceof EnemyCharacter && ((EnemyCharacter) Entlist.get(i)).EnemyID == randomNum)
                {
                    EProjectileExists = true;
                    Entlist.add(EPF.CreateProjectile(Entlist.get(i).locationX-10,Entlist.get(i).locationY,((EnemyCharacter) Entlist.get(i)).type));
                }
            }
        }
    }
    //EnemyMoves
    //moves enemies left,right and down according to their current direction
    public void EnemyMoves()
    {
        boolean godown = false;
        for(int i = 0;i < Entlist.size();i++) {
            if (Entlist.get(i) instanceof EnemyCharacter && ((EnemyCharacter) Entlist.get(i)).EnemyID == highestEID && enemyDirectionRight) {
                if ((Entlist.get(i)).locationX >= SCREEN_WIDTH) {
                    enemyDirectionRight = !enemyDirectionRight;
                    godown = true;
                }
            } else if (Entlist.get(i) instanceof EnemyCharacter && ((EnemyCharacter) Entlist.get(i)).EnemyID == lowestEID && !enemyDirectionRight) {
                if ((Entlist.get(i)).locationX <= 70) {
                    enemyDirectionRight = !enemyDirectionRight;
                    godown = true;
                }
            }
        }
            for(int i = 0;i < Entlist.size();i++) {
                if (Entlist.get(i) instanceof EnemyCharacter)
                {
                    if(godown)
                    {
                        Entlist.get(i).locationY += 20;
                    }
                    else if (enemyDirectionRight)
                    {
                        Entlist.get(i).locationX += 50;
                    }
                    else
                    {
                        Entlist.get(i).locationX -= 50;
                    }

                }

            }
    }

    //getNewEIDS()
    //appoints new Higher and lower limits for enemies
    //Used to know which enemies are on the outer limit and how far they're maximum allowed to go
    void getNewEIDs()
    {
        for(int i = 0;i < Entlist.size();i++)
        {
            if(Entlist.get(i) instanceof  EnemyCharacter)
            {
                if(((EnemyCharacter) Entlist.get(i)).EnemyID < lowestEID)
                {
                    lowestEID = ((EnemyCharacter) Entlist.get(i)).EnemyID;
                }
                if(((EnemyCharacter) Entlist.get(i)).EnemyID > highestEID)
                {
                  highestEID = ((EnemyCharacter) Entlist.get(i)).EnemyID;
                }

            }
        }
    }

    //actionPerformed
    //Updates on each clock cycle
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i = 0;i < Entlist.size();i++)
        {
            if(Entlist.get(i) instanceof PlayerCharacter)
            {
                alive = ((PlayerCharacter) Entlist.get(i)).isAlive();
            }
        }
        if(!paused && alive)
        {
            UpdateEnemies();
            Collision();
            InteractionProjectile();

        }
        else if(!alive)
        {
            deadcounter++;
            if(deadcounter >= 60 )
            {
                if(!(lives > 0))
                {
                    //OFFICIALLY DEAD, DO SOMETHING HERE?
                }
                else {
                    lives -= 1;
                    ReSpawnPlayer();
                    deadcounter = 0;

                }
            }
        }
        else
        {
            CS.setLeft(false);
            CS.setSpace(false);
            CS.setRight(false);

        }

        State();
    }

    //Data functions
    //Used by visualisation to get necesarry Data out for visualisation
    public int getEnemyType(int eid)
    {
        for(int i = 0; i < Entlist.size();i++)
        {
            if(Entlist.get(i) instanceof EnemyCharacter)
            {
                if(((EnemyCharacter) Entlist.get(i)).EnemyID == eid)
                {
                    return ((EnemyCharacter) Entlist.get(i)).type;
                }

            }
        }
        return 0;
    }
    public int[] getPlayerpos()
    {
        return playerPos;
    }

    public boolean playerAlive()
    {
        return alive;
    }

    public int[] getPlayerProjectilePos()
    {
        int[] xy = new int[2];
        for(int i = 0; i < Entlist.size();i++)
        {
            if(Entlist.get(i) instanceof PlayerProjectile)
            {
                xy[0] = Entlist.get(i).locationX;
                xy[1] = Entlist.get(i).locationY;
                break;
            }
        }
        return xy;
    }
    public int[] getEnemyProjectilePos()
    {
        int[] xy = new int[3];
        for(int i = 0; i < Entlist.size();i++)
        {
            if(Entlist.get(i) instanceof EnemyProjectile)
            {
                xy[0] = Entlist.get(i).locationX;
                xy[1] = Entlist.get(i).locationY;
                xy[2] = ((EnemyProjectile) Entlist.get(i)).getType();

                break;
            }
        }
        return xy;
    }
    public Vector<Integer> GetAllEIDS()
    {
        Vector<Integer> EIDHolder = new Vector<>();
        for(int i = 0 ; i < Entlist.size();i++)
        {
            if(Entlist.get(i) instanceof EnemyCharacter)
            {
                EIDHolder.add(((EnemyCharacter) Entlist.get(i)).EnemyID);
            }
        }
        return EIDHolder;
    }
    public int[] GetSpecifiedEnemyLocation(int eid)
    {
        int[] xy = new int[2];
        for(int i = 0; i < Entlist.size();i++)
        {
            if(Entlist.get(i) instanceof EnemyCharacter)
            {
                if(((EnemyCharacter) Entlist.get(i)).EnemyID == eid)
                {
                    xy[0] = Entlist.get(i).locationX;
                    xy[1] = Entlist.get(i).locationY;
                    break;
                }

            }
        }
        return xy;
    }
}

