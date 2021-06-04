package com.company;

public class Config {
    private static Config single_instance = null;


    public int EnemyRows;
    public int EnemyColumns;
    public int EnemySpeed;
    public int PlayerSpeed;
    public int CProjectileSpeed;
    public int Playerlives;

    private Config()
    {

    }

    public void setVarsConfig(int ER,int EC, int ES, int PS, int CPS,int PL)
    {
        if(ER > 4 || ER < 1)
        {
            this.EnemyRows = ER;
        }
        else
        {
            this.EnemyRows = 4;
        }

        if(EC > 14 || EC < 1)
        {
            this.EnemyColumns = EC;
        }
        else
        {
            this.EnemyColumns = 10;
        }
        this.EnemySpeed = ES;
        this.PlayerSpeed = PS;
        this.CProjectileSpeed = CPS;
        this.Playerlives = PL;
    }

    // static method to create instance of Singleton class
    public static Config getInstance()
    {
        if (single_instance == null)
            single_instance = new Config();

        return single_instance;
    }
}
