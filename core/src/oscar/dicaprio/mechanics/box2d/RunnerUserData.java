package oscar.dicaprio.mechanics.box2d;

import com.badlogic.gdx.math.Vector2;
import oscar.dicaprio.utils.Constants;
import oscar.dicaprio.utils.UserDataType;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class RunnerUserData extends UserData {

  private Vector2 mJumpingLinearImpulse;

  public RunnerUserData() {
    mJumpingLinearImpulse = Constants.RUNNER_JUMPING_LINEAR_IMPULSE;
  }

  @Override public UserDataType getUserDataType() {
    return UserDataType.RUNNER;
  }

  //region Getters and setters
  public Vector2 getJumpingLinearImpulse() {
    return mJumpingLinearImpulse;
  }

  public void setJumpingLinearImpulse(Vector2 jumpingLinearImpulse) {
    this.mJumpingLinearImpulse = jumpingLinearImpulse;
  }
  //endregion
}
