package com.company.factories;

import com.company.entities.Entity;
import com.company.entities.PlayerProjectile;
import com.company.entities.Projectile;

public class PlayerProjectileFactory  extends ProjectileFactory
{
    public Entity CreateProjectile(int x, int y)
    {
        return new PlayerProjectile(x,y);
    }

}
