package com.company.entities;

public abstract class Entity
{
    public int locationX;
    public int locationY;

    public Entity(int x, int y)
    {
        locationX = x;
        locationY = y;
    }
}
