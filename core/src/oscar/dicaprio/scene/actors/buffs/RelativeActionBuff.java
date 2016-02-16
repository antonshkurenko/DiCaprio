package oscar.dicaprio.scene.actors.buffs;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.RelativeTemporalAction;
import oscar.dicaprio.scene.actors.BaseActor;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/16/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Buff, which gives you percent delta in the update method
 */
public abstract class RelativeActionBuff extends RelativeTemporalAction {

  public RelativeActionBuff(BaseActor actor, float duration) {
    this(actor, duration, Interpolation.linear);
  }

  public RelativeActionBuff(BaseActor actor, float duration, Interpolation interpolation) {
    setDuration(duration);
    setInterpolation(interpolation);
    setActor(actor);
  }
}
