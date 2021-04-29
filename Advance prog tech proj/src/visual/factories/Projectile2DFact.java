package visual.factories;

import com.company.entities.PlayerProjectile;
import visual.entities.PlayerProjectile2D;
import visual.entities.Projectile2D;

public class Projectile2DFact
{
    public PlayerProjectile2D CreateProj()
    {
        return new PlayerProjectile2D();
    }
}
