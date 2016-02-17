package oscar.dicaprio.mechanics.box2d;

import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.List;
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

  private final List<OnVelocityChangeObserver> mVelocityChangeObservers = new ArrayList<>();

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

  //region Velocity change observers
  public void attachVelocityChangeObserver(OnVelocityChangeObserver obs) {
    mVelocityChangeObservers.add(obs);
  }

  public void detachVelocityChangeObserver(OnVelocityChangeObserver obs) {
    mVelocityChangeObservers.remove(obs);
  }

  public void notifyVelocityObservers(Vector2 delta, boolean forward) {

    // two cycles to avoid if statement in cycle
    if (forward) {
      for (OnVelocityChangeObserver o : mVelocityChangeObservers) {
        o.onForwardSpeedChanged(this, delta);
      }
    } else {
      for (OnVelocityChangeObserver o : mVelocityChangeObservers) {
        o.onBackwardSpeedChanged(this, delta);
      }
    }
  }
  //endregion

  //region Getters and setters
  public Vector2 getLinearVelocity() {

    final Vector2 velocity = new Vector2(mForwardLinearVelocity);
    return velocity.sub(mBackwardLinearVelocity);
  }

  public Vector2 getForwardLinearVelocity() {
    return new Vector2(mForwardLinearVelocity);
  }

  /**
   * Sets new forward speed and notifies about it
   *
   * @param forwardLinearVelocity new speed
   */
  public void setForwardLinearVelocity(Vector2 forwardLinearVelocity) {
    notifyVelocityObservers(new Vector2(mForwardLinearVelocity).sub(forwardLinearVelocity), true);
    mForwardLinearVelocity.set(forwardLinearVelocity);
  }

  public Vector2 getBackwardLinearVelocity() {
    return new Vector2(mBackwardLinearVelocity);
  }

  /**
   * Sets new backward speed and notifies about it
   *
   * @param backwardLinearVelocity new speed
   */
  public void setBackwardLinearVelocity(Vector2 backwardLinearVelocity) {
    notifyVelocityObservers(new Vector2(mBackwardLinearVelocity).sub(backwardLinearVelocity),
        false);
    mBackwardLinearVelocity.set(backwardLinearVelocity);
  }

  public Vector2 getJumpingLinearImpulse() {
    return new Vector2(mJumpingLinearImpulse);
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

  /**
   * Fires before actual changing speed
   */
  public interface OnVelocityChangeObserver {

    void onForwardSpeedChanged(RunnerUserData runnerData, Vector2 delta);

    void onBackwardSpeedChanged(RunnerUserData runnerData, Vector2 delta);
  }
}
