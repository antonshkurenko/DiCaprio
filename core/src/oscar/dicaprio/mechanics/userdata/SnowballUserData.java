package oscar.dicaprio.mechanics.userdata;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/16/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

import com.badlogic.gdx.math.Vector2;
import oscar.dicaprio.utils.C;

/**
 * Class, that describes physical behavior and parameters of the iceberg's snowballs
 */
public class SnowballUserData extends UserData {

  private Vector2 mLinearVelocity;

  public SnowballUserData(float diameter, float angle) {
    super(diameter, diameter);
    mLinearVelocity = new Vector2(C.world.snowball_linear_velocity);
    mLinearVelocity.setAngle(angle);
  }

  //region Getters and setters
  public Vector2 getLinearVelocity() {
    return new Vector2(mLinearVelocity);
  }
  //endregion
}
