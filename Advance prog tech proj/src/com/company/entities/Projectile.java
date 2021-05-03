package com.company.entities;

public abstract class Projectile extends Entity {
    public Projectile(int x, int y) {
        super(x, y);
    }
    public void changeY(int value)
    {
        locationY = locationY + value;
    }
    public void changeX(int value)
    {
        locationX = locationX + value;
    }
}
