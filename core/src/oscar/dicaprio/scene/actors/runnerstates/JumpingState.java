package oscar.dicaprio.scene.actors.runnerstates;

import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.scene.actors.RunnerActor;
import oscar.dicaprio.utils.Constants;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/10/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class JumpingState extends AbstractInAirState {

  @Override public void handleInput(RunnerActor runner, int inputType) {
    switch (inputType) {
      case Constants.INPUT_TYPE_RIGHT_TOUCH_DOWN:
        jump(runner);
        break;
    }
  }

  protected void jump(final RunnerActor runner) {

    final Body body = runner.getBody();

    /**
     * Remove speed, to make him like jump from the platform in the air
     * Because:
     * if fast double jump it jumps very high (double linear velocity),
     * but if next jump is near the ground, it's low
     *
     * (Y velocity is low (falling down) and impulse does nothing)
     */
    body.setLinearVelocity(0f, 0f);
    body.applyLinearImpulse(runner.getUserData().getJumpingLinearImpulse(), body.getWorldCenter(),
        true);

    runner.setState(runner.getStatesHolder().getDoubleJumpingState());
  }
}
