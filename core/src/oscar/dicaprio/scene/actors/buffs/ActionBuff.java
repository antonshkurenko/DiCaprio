package oscar.dicaprio.scene.actors.buffs;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;
import oscar.dicaprio.scene.actors.BaseActor;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/15/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Buff, which gives you percent amount in the update method
 */
public abstract class ActionBuff extends TemporalAction {

  public ActionBuff(float duration) {
    this(duration, Interpolation.linear);
  }

  public ActionBuff(float duration, Interpolation interpolation) {
    super(duration, interpolation);
  }
}
