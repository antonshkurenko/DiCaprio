package oscar.dicaprio.mechanics.enemies;

import oscar.dicaprio.utils.C;

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
        .setY(C.world.enemy_running_long_y)
        .createEnemy();
  }
}
