package oscar.dicaprio.mechanics.box2d;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

import oscar.dicaprio.utils.C;

/**
 * Class, that describes physical behavior and parameters of the iceberg
 */
public class IcebergUserData extends UserData {

  public IcebergUserData() {
    super(C.world.iceberg_width, C.world.iceberg_height);
  }
}
