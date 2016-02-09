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

  String ENEMY_RUNNING_SMALL = "enemy_running_small";
  String ENEMY_RUNNING_WIDE = "enemy_running_wide";
  String ENEMY_RUNNING_LONG = "enemy_running_long";
  String ENEMY_RUNNING_BIG = "enemy_running_big";
  String ENEMY_FLYING_SMALL = "enemy_flying_small";
  String ENEMY_FLYING_WIDE = "enemy_flying_wide";

  Enemy getEnemy();
}
