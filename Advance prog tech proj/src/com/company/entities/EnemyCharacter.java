package com.company.entities;

public class EnemyCharacter extends Character
{

    public int EnemyID;
    public int type;

    public EnemyCharacter(int x, int y,int E,int t) {
        super(x, y);
        EnemyID = E;
        type = t;
    }

}
