package oscar.dicaprio.scene.actors.runnerstates;

import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.mechanics.box2d.RunnerUserData;
import oscar.dicaprio.scene.actors.RunnerActor;
import oscar.dicaprio.utils.C;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/10/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class DodgingState extends AbstractAliveState {

  @Override public void handleInput(RunnerActor runner, int inputType) {
    switch (inputType) {
      case C.input.input_left_touch_up:
        run(runner);
        break;
    }
  }

  protected void run(RunnerActor runner) {
    final Body body = runner.getBody();
    final RunnerUserData userData = runner.getUserData();

    body.setTransform(body.getPosition().x, userData.getRunningY(), 0f);
    runner.setState(runner.getStatesHolder().getRunningState());
  }
}
