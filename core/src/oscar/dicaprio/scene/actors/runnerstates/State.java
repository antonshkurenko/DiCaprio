package oscar.dicaprio.scene.actors.runnerstates;

import com.badlogic.gdx.scenes.scene2d.Actor;
import oscar.dicaprio.scene.actors.RunnerActor;
import oscar.dicaprio.utils.C;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/10/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Describes State pattern
 *
 * If {@link RunnerActor} will have overridden {@link Actor#act} method
 * Add another method to this interface
 */

public interface State {

  /**
   *
   * Handling different input in the state
   *
   * @param runner runner object
   * @param inputType type of the input
   * @see C
   */
  void handleInput(RunnerActor runner, int inputType);

  /**
   *
   * Handling event in the state
   *
   * @param runner runner object
   * @param eventType type of the event
   * @see C
   */
  void handleEvent(RunnerActor runner, int eventType);
}
