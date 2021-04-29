package com.company.factories;

import com.company.entities.Entity;
import com.company.entities.PlayerCharacter;

public class PlayerFactory extends CharacterFactory
{
    public Entity CreatePlayer(int w,int h)
    {
        return new PlayerCharacter(w/2,h-100);
    }
}
