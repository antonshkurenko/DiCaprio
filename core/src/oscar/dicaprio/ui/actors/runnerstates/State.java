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

  void handleInput(RunnerActor runner, int inputType);
}
