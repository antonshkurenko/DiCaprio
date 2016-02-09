package oscar.dicaprio.mechanics.physics.enemies;

import oscar.dicaprio.utils.Constants;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public final class SmallFlyingEnemyFactory extends AbstractEnemyFactory {

  /**
   * ___
   * |_|
   *
   * ---
   */


  @Override protected Enemy createEnemy() {
    return new Enemy.Builder()
        .setY(Constants.FLYING_ENEMY_Y)
        .createEnemy();
  }
}
