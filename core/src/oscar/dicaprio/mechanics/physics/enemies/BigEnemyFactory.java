package oscar.dicaprio.mechanics.physics.enemies;

import oscar.dicaprio.utils.C;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public final class BigEnemyFactory extends AbstractEnemyFactory {

  /**
   * _____
   * |_|_|
   * | | |
   * -----
   */

  @Override protected Enemy createEnemy() {
    return new Enemy.Builder()
        .setWidth(2f)
        .setHeight(2f)
        .setY(C.world.enemy_running_long_y)
        .createEnemy();
  }
}
