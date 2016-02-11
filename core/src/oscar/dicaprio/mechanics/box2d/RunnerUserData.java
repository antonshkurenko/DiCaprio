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

/**
 * Class, that describes physical behavior and parameters of the runner
 */
public class RunnerUserData extends UserData {

  private final Vector2 mRunningPosition = new Vector2(Constants.RUNNER_X, Constants.RUNNER_Y);

  private final Vector2 mDodgePosition =
      new Vector2(Constants.RUNNER_DODGE_X, Constants.RUNNER_DODGE_Y);

  private Vector2 mJumpingLinearImpulse;

  public RunnerUserData(float width, float height) {
    super(width, height);
    mJumpingLinearImpulse = Constants.RUNNER_JUMPING_LINEAR_IMPULSE;
  }

  @Override public UserDataType getUserDataType() {
    return UserDataType.RUNNER;
  }

  //region Getters and setters
  public Vector2 getJumpingLinearImpulse() {
    return mJumpingLinearImpulse;
  }

  public float getDodgeAngle() {
    // In radians
    return (float) (-90f * (Math.PI / 180f));
  }

  public float getHitAngularImpulse() {
    return Constants.RUNNER_HIT_ANGULAR_IMPULSE;
  }

  public Vector2 getRunningPosition() {
    return mRunningPosition;
  }

  public Vector2 getDodgePosition() {
    return mDodgePosition;
  }
  //endregion
}
