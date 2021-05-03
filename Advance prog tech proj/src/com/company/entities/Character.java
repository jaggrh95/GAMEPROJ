package com.company.entities;

public abstract class Character extends Entity
{
    public boolean alive = true;

    public Character(int x, int y) {
        super(x, y);
    }

    public boolean isAlive()
    {
        return alive;
    }

    public void kill()
    {
        alive = false;
    }

    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }
}
