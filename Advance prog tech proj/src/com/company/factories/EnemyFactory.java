package com.company.factories;

import com.company.entities.EnemyCharacter;
import com.company.entities.Entity;

public class EnemyFactory extends CharacterFactory{
    public Entity CreateEnemy(int x, int y,int e, int type)
    {
        return new EnemyCharacter( x , y,e,type);
    }
}
