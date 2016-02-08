package oscar.dicaprio.ui.actors;

import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.mechanics.box2d.RunnerUserData;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/8/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class RunnerActor extends BaseActor {

  private boolean mJumping;

  public RunnerActor(Body body) {
    super(body);
  }

  @Override public RunnerUserData getUserData() {
    return ((RunnerUserData) mUserData);
  }

  // todo(tonyshkurenko), 2/9/16: after end of the tutorial rework this to State pattern
  public void jump() {

    if (!mJumping) {
      mBody.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), mBody.getWorldCenter(),
          true);
      mJumping = true;
    }
  }

  public void landed() {
    mJumping = false;
  }
}
