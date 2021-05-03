package com.company.entities;

public class EnemyProjectile extends Projectile {
    private int type = 0;
    public EnemyProjectile(int x, int y,int t) {
        super(x, y);
        type = t;

    }

    public int getType() {
        return type;
    }
}
