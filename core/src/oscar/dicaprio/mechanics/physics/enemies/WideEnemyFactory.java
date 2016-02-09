package oscar.dicaprio.mechanics.physics.enemies;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public final class WideEnemyFactory extends AbstractEnemyFactory {

  /**
   * _____
   * | | |
   * -----
   */

  @Override protected Enemy createEnemy() {
    return new Enemy.Builder()
        .setWidth(2f)
        .createEnemy();
  }
}
