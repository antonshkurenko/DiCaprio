package oscar.dicaprio.mechanics.box2d;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/11/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

import com.badlogic.gdx.math.Vector2;
import oscar.dicaprio.utils.Constants;
import oscar.dicaprio.utils.UserDataType;

/**
 * Class, that describes physical behavior and parameters of the enemy
 */
public class CoinUserData extends UserData {

  private Vector2 mLinearVelocity;

  public CoinUserData(float width, float height) {
    super(width, height);
    mLinearVelocity = Constants.COIN_LINEAR_VELOCITY;
  }

  @Override public UserDataType getUserDataType() {
    return UserDataType.COIN;
  }

  //region Getters and setters
  public Vector2 getLinearVelocity() {
    return mLinearVelocity;
  }
}
