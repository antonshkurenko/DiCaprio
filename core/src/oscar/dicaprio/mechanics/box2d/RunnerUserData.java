package oscar.dicaprio.mechanics.box2d;

import com.badlogic.gdx.math.Vector2;
import oscar.dicaprio.utils.C;

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

  private final Vector2 mRunningPosition = new Vector2(C.world.runner_x, C.world.runner_y);

  private final Vector2 mDodgePosition =
      new Vector2(C.world.runner_dodge_x, C.world.runner_dodge_y);

  private Vector2 mJumpingLinearImpulse;

  public RunnerUserData(float width, float height) {
    super(width, height);
    mJumpingLinearImpulse = new Vector2(C.world.runner_jumping_linear_impulse);
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
    return C.world.runner_hit_angular_impulse;
  }

  public Vector2 getRunningPosition() {
    return mRunningPosition;
  }

  public Vector2 getDodgePosition() {
    return mDodgePosition;
  }
  //endregion
}
