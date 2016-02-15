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
public abstract class ActionBuff extends TemporalAction {

  public ActionBuff(BaseActor actor, float duration) {
    this(actor, duration, Interpolation.linear);
  }

  public ActionBuff(BaseActor actor, float duration, Interpolation interpolation) {
    super(duration, interpolation);
    setActor(actor);
  }

  @Override protected void begin() {
    super.begin();

  }

  @Override protected void end() {
    super.end();

  }

  @Override protected void update(float percent) {

  }
}
