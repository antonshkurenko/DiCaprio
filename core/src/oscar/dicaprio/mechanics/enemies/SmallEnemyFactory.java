package oscar.dicaprio.mechanics.enemies;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public final class SmallEnemyFactory extends AbstractEnemyFactory {

  /**
   *  _
   * | |
   * ---
   */
  @Override protected Enemy createEnemy() {
    return new Enemy.Builder().createEnemy();
  }
}
