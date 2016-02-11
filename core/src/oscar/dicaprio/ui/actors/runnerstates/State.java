package oscar.dicaprio.ui.actors.runnerstates;

import oscar.dicaprio.ui.actors.RunnerActor;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/10/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public interface State {

  // todo(tonyshkurenko), 2/11/16: move inputs somewhere
  int INPUT_TYPE_NOTHING = 0;

  int INPUT_TYPE_LEFT_TOUCH_DOWN = -1;
  int INPUT_TYPE_LEFT_TOUCH_UP = -2;

  int INPUT_TYPE_RIGHT_TOUCH_DOWN = 1;
  int INPUT_TYPE_RIGHT_TOUCH_UP = 2;

  // todo(tonyshkurenko), 2/11/16: and events also

  int EVENT_TYPE_COLLISION_WITH_GROUND = 1;
  int EVENT_TYPE_COLLISION_WITH_ENEMY = 2;

  /**
   *
   * Handling input in the state
   *
   * @param runner runner object
   * @param inputType type of the input
   */
  void handleInput(RunnerActor runner, int inputType);

  /**
   *
   * Handling event in the state
   *
   * @param runner runner object
   * @param eventType type of the event
   */
  void handleEvent(RunnerActor runner, int eventType);
}
