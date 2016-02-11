package oscar.dicaprio.mechanics.physics.enemies;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * It holds the one instance of the enemy and returns it
 */
public abstract class AbstractEnemyFactory implements EnemyFactory {

  protected final Enemy mCachedEnemyInstance = createEnemy();

  protected abstract Enemy createEnemy();

  @Override public Enemy getEnemy() {
    return mCachedEnemyInstance;
  }
}
