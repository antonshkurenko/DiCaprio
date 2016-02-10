package oscar.dicaprio.ui.actors.runnerstates;

import oscar.dicaprio.ui.actors.RunnerActor;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/10/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class JumpingState extends AbstractAliveState {

  @Override public void handleInput(RunnerActor runner, int inputType) {
    switch (inputType) {
      // todo(tonyshkurenko), 2/11/16: set Jumping -> Running in collider
    }
  }

  @Override public void handleEvent(RunnerActor runner, int eventType) {

    super.handleEvent(runner, eventType);

    switch (eventType) {
      case EVENT_TYPE_COLLISION_WITH_GROUND:
        land(runner);
        break;
    }
  }

  private void land(RunnerActor runner) {
    runner.setState(runner.getStatesHolder().getRunningState());
  }
}
