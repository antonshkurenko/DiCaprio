package oscar.dicaprio.mechanics.box2d;

import oscar.dicaprio.utils.UserDataType;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class GroundUserData extends UserData {

  @Override public UserDataType getUserDataType() {
    return UserDataType.GROUND;
  }
}
