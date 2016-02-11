package oscar.dicaprio.mechanics.physics.enemies;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

// todo(tonyshkurenko), 2/9/16: Aint sure it was good way to create factory just to differ enemies by size
public interface EnemyFactory {
  Enemy getEnemy();
}
