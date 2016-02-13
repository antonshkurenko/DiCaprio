package oscar.dicaprio.mechanics.physics;

import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.mechanics.box2d.UserData;
import oscar.dicaprio.utils.UserDataType;

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
      final UserData userData = (UserData) body.getUserData();
      return userData != null && userData.getUserDataType() == UserDataType.RUNNER;
    } catch (ClassCastException e) {
      return false;
    }
  }

  public static boolean bodyIsGround(Body body) {
    try {
      final UserData userData = (UserData) body.getUserData();
      return userData != null && userData.getUserDataType() == UserDataType.GROUND;
    } catch (ClassCastException e) {
      return false;
    }
  }

  public static boolean bodyIsEnemy(Body body) {
    try {
      final UserData userData = (UserData) body.getUserData();
      return userData != null && userData.getUserDataType() == UserDataType.ENEMY;
    } catch (ClassCastException e) {
      return false;
    }
  }

  public static boolean bodyIsCoin(Body body) {
    try {
      final UserData userData = (UserData) body.getUserData();
      return userData != null && userData.getUserDataType() == UserDataType.COIN;
    } catch (ClassCastException e) {
      return false;
    }
  }

  /**
   *
   *       |-------------------------
   *       |
   * left  |
   * bound |
   *       |
   *       |_________________________
   *
   *
   * @param body body to check
   * @return is before left bound
   */
  public static boolean bodyInLeftBound(Body body) {
    try {
      final UserData userData = (UserData) body.getUserData();

      switch (userData.getUserDataType()) {
        case RUNNER:
        case ENEMY:
        case COIN:
          return body.getPosition().x + userData.getWidth() / 2 > 0;
      }
    } catch (ClassCastException ignored) {

    }
    return true;
  }
}
