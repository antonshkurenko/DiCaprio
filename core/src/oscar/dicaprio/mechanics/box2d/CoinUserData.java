package oscar.dicaprio.mechanics.box2d;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/11/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

import com.badlogic.gdx.math.Vector2;
import oscar.dicaprio.utils.C;

/**
 * Class, that describes physical behavior and parameters of the enemy
 */
public class CoinUserData extends UserData {

  private Vector2 mLinearVelocity;

  private boolean mIsRemovable = false;

  public CoinUserData(float diameter) {
    super(diameter, diameter);
    mLinearVelocity = C.world.coin_linear_velocity;
  }

  //region Getters and setters
  public Vector2 getLinearVelocity() {
    return mLinearVelocity;
  }

  public boolean isRemovable() {
    return mIsRemovable;
  }

  public void setRemovable() {
    mIsRemovable = true;
  }
  //endregion
}
