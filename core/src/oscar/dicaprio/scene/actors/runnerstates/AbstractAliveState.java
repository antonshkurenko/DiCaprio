package oscar.dicaprio.scene.actors.runnerstates;

import oscar.dicaprio.scene.actors.RunnerActor;
import oscar.dicaprio.utils.Constants;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/11/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * State to handle live -> dead
 */
public abstract class AbstractAliveState implements State {

  @Override public void handleEvent(RunnerActor runner, int eventType) {
    switch (eventType) {
      case Constants.EVENT_TYPE_COLLISION_RUNNER_WITH_ENEMY:
        die(runner);
        break;
    }
  }

  protected void die(RunnerActor runner) {
    runner.getBody().applyAngularImpulse(runner.getUserData().getHitAngularImpulse(), true);
    runner.setState(runner.getStatesHolder().getHitState());
  }
}
