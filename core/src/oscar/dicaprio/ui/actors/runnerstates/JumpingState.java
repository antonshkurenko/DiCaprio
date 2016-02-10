package oscar.dicaprio.ui.actors.runnerstates;

import oscar.dicaprio.ui.actors.RunnerActor;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/10/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class JumpingState implements State {
  
  @Override public void handleInput(RunnerActor runner, int inputType) {
    switch (inputType) {
      // todo(tonyshkurenko), 2/11/16: set Jumping -> Running in collider
    }
  }
}
