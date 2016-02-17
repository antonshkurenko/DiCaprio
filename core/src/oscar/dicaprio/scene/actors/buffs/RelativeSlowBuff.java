package oscar.dicaprio.scene.actors.buffs;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import oscar.dicaprio.mechanics.box2d.RunnerUserData;
import oscar.dicaprio.scene.actors.RunnerActor;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/16/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class RelativeSlowBuff extends RelativeActionBuff {

  private static final String TAG = RelativeSlowBuff.class.getSimpleName();

  private final Vector2 mMaxSlow;

  //region Constructors
  public RelativeSlowBuff(Vector2 slow) {
    this(slow, 3, Interpolation.linear);
  }

  public RelativeSlowBuff(Vector2 slow, float duration) {
    this(slow, duration, Interpolation.linear);
  }

  public RelativeSlowBuff(Vector2 slow, float duration, Interpolation interpolation) {
    super(duration, interpolation);
    mMaxSlow = new Vector2(slow);
  }
  //endregion

  //region Extends RelativeActionBuff
  @Override protected void updateRelative(float percentDelta) {
    try {
      final RunnerUserData runner = ((RunnerActor) actor).getUserData();
      final Vector2 slow = new Vector2(mMaxSlow).scl(percentDelta);

      runner.setBackwardLinearVelocity(runner.getBackwardLinearVelocity().sub(slow));
    } catch (ClassCastException e) {
      throw new RuntimeException("SlowBuff if applicable only to the RunnerActor.");
    }
  }

  @Override protected void begin() {
    super.begin();

    try {
      final RunnerUserData runner = ((RunnerActor) actor).getUserData();
      runner.setBackwardLinearVelocity(runner.getBackwardLinearVelocity().add(mMaxSlow));
    } catch (ClassCastException e) {
      throw new RuntimeException("SlowBuff if applicable only to the RunnerActor.");
    }
  }
  //endregion
}
