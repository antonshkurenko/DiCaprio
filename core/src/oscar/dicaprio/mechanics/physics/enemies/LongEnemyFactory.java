package oscar.dicaprio.mechanics.physics.enemies;

import oscar.dicaprio.utils.Constants;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public final class LongEnemyFactory extends AbstractEnemyFactory {

  /**
   * ___
   * |_|
   * | |
   * ---
   */


  @Override protected Enemy createEnemy() {
    return new Enemy.Builder()
        .setHeight(2f)
        .setY(Constants.RUNNING_LONG_ENEMY_Y)
        .createEnemy();
  }
}
