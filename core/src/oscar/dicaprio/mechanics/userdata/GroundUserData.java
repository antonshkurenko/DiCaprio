package oscar.dicaprio.mechanics.userdata;

import oscar.dicaprio.utils.C;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Class, that describes physical behavior and parameters of the ground
 */
public class GroundUserData extends UserData {

  public GroundUserData() {
    super(C.world.ground_width, C.world.ground_height);
  }
}
