package oscar.dicaprio.ui.actors.runnerstates;

import oscar.dicaprio.ui.actors.RunnerActor;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/11/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public abstract class AbstractAliveState implements State {

  @Override public void handleEvent(RunnerActor runner, int eventType) {
    switch (eventType) {
      case EVENT_TYPE_COLLISION_WITH_ENEMY:
        die(runner);
        break;
    }
  }

  private void die(RunnerActor runner) {
    runner.getBody().applyAngularImpulse(runner.getUserData().getHitAngularImpulse(), true);
    runner.setState(runner.getStatesHolder().getHitState());
  }
}
