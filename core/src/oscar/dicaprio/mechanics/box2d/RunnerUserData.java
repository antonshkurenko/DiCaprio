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

  /**
   * to speed up not from zero, but from some value
   */
  private Vector2 mForwardLinearVelocity = C.world.runner_linear_forward_velocity;
  /**
   * to slow up not from zero, but from some value
   */
  private Vector2 mBackwardLinearVelocity = C.world.runner_linear_backward_velocity;

  private Vector2 mJumpingLinearImpulse;

  public RunnerUserData(float width, float height) {
    super(width, height);
    mJumpingLinearImpulse = new Vector2(C.world.runner_jumping_linear_impulse);
  }

  public void resetSpeed() {
    mForwardLinearVelocity = C.world.runner_linear_forward_velocity;
    mBackwardLinearVelocity = C.world.runner_linear_backward_velocity;
  }

  //region Getters and setters

  public Vector2 getLinearVelocity() {

    final Vector2 velocity = new Vector2(mForwardLinearVelocity);
    return velocity.sub(mBackwardLinearVelocity);
  }

  public Vector2 getForwardLinearVelocity() {
    return mForwardLinearVelocity;
  }

  public void setForwardLinearVelocity(Vector2 forwardLinearVelocity) {
    mForwardLinearVelocity.set(forwardLinearVelocity);
  }

  public Vector2 getBackwardLinearVelocity() {
    return mBackwardLinearVelocity;
  }

  public void setBackwardLinearVelocity(Vector2 backwardLinearVelocity) {
    mBackwardLinearVelocity.set(backwardLinearVelocity);
  }

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

  public float getRunningY() {
    return C.world.runner_y;
  }

  public float getDodgingY() {
    return C.world.runner_dodge_y;
  }
  //endregion
}
