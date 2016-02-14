package oscar.dicaprio.mechanics.physics;

import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.scene.actors.BaseActor;
import oscar.dicaprio.scene.actors.CoinActor;
import oscar.dicaprio.scene.actors.EnemyActor;
import oscar.dicaprio.scene.actors.GroundActor;
import oscar.dicaprio.scene.actors.RunnerActor;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Utils to associate bodies with their presentation
 */
public class BodyUtils {

  public static boolean bodyIsRunner(Body body) {
    try {
      final BaseActor actor = (BaseActor) body.getUserData();
      return actor != null && actor instanceof RunnerActor;
    } catch (ClassCastException e) {
      return false;
    }
  }

  public static boolean bodyIsGround(Body body) {
    try {
      final BaseActor actor = (BaseActor) body.getUserData();
      return actor != null && actor instanceof GroundActor;
    } catch (ClassCastException e) {
      return false;
    }
  }

  public static boolean bodyIsEnemy(Body body) {
    try {
      final BaseActor actor = (BaseActor) body.getUserData();
      return actor != null && actor instanceof EnemyActor;
    } catch (ClassCastException e) {
      return false;
    }
  }

  public static boolean bodyIsCoin(Body body) {
    try {
      final BaseActor actor = (BaseActor) body.getUserData();
      return actor != null && actor instanceof CoinActor;
    } catch (ClassCastException e) {
      return false;
    }
  }

  /**
   * |-------------------------
   * |
   * left  |
   * bound |
   * |
   * |_________________________
   *
   * @param body body to check
   * @return is before left bound
   */
  public static boolean bodyInLeftBound(Body body) {
    try {
      final BaseActor actor = (BaseActor) body.getUserData();

      if (actor instanceof RunnerActor || actor instanceof EnemyActor
          || actor instanceof CoinActor) {
        return body.getPosition().x + ((BaseActor) body.getUserData()).getUserData().getWidth() / 2
            > 0;
      }
    } catch (ClassCastException ignored) {

    }
    return true;
  }
}
