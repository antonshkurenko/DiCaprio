package oscar.dicaprio.mechanics.physics;

import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.scene.actors.BaseActor;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

public class BodyUtils {

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
      return body.getPosition().x + ((BaseActor) body.getUserData()).getUserData().getWidth() / 2
          > 0;
    } catch (ClassCastException ignored) {

    }
    return true;
  }

  public static boolean bodyOnRightHalf(Body body) {
    try {
      return body.getPosition().x + ((BaseActor) body.getUserData()).getUserData().getWidth() / 2
          > 0;
    } catch (ClassCastException ignored) {

    }
    return true;
  }
}
