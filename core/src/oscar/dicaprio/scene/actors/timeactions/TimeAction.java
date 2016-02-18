package oscar.dicaprio.scene.actors.timeactions;

import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/18/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class TimeAction extends RepeatAction {

  public TimeAction(int count, float delay, Runnable action) {
    super();
    setCount(count);

    // declaring delay before execution
    final DelayAction delayAction = new DelayAction(delay);

    // declaring what to execute
    final RunnableAction runnableAction = new RunnableAction();
    runnableAction.setRunnable(action);

    // matryoshka doll
    delayAction.setAction(runnableAction);
    setAction(delayAction);
  }
}
