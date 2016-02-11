package oscar.dicaprio.scene.actors.runnerstates;

import oscar.dicaprio.scene.actors.RunnerActor;
import oscar.dicaprio.utils.Constants;

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
      case Constants.INPUT_TYPE_LEFT_TOUCH_UP:
        run(runner);
        break;
    }
  }

  protected void run(RunnerActor runner) {
    runner.getBody().setTransform(runner.getUserData().getRunningPosition(), 0f);
    runner.setState(runner.getStatesHolder().getRunningState());
  }
}
