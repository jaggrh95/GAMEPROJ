package visual.factories;

import visual.entities.Character2D;
import visual.entities.EnemyCharacter2D;

public class Enemy2DFactory
{
    public EnemyCharacter2D getEnemy(int enemyID)
    {
        return new EnemyCharacter2D(enemyID);
    }
}
