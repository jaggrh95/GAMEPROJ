package com.company.factories;

import com.company.entities.EnemyProjectile;
import com.company.entities.Entity;
import com.company.entities.PlayerProjectile;

public class EnemyProjectileFactory extends ProjectileFactory{
    public Entity CreateProjectile(int x, int y)
    {
        return new EnemyProjectile(x,y);
    }
}
