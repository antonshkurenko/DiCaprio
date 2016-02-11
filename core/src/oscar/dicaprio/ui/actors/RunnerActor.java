package oscar.dicaprio.ui.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.mechanics.box2d.RunnerUserData;
import oscar.dicaprio.ui.actors.runnerstates.State;
import oscar.dicaprio.ui.actors.runnerstates.StatesHolder;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/8/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class RunnerActor extends BaseActor {

  private static final String TAG = RunnerActor.class.getSimpleName();

  protected final StatesHolder mStatesHolder = new StatesHolder();

  protected State mState = mStatesHolder.getRunningState();

  public RunnerActor(Body body) {
    super(body);
  }

  @Override public RunnerUserData getUserData() {
    return ((RunnerUserData) mUserData);
  }

  public void handleInput(int inputType) {
    mState.handleInput(this, inputType);
  }

  public void handleEvent(int eventType) {
    mState.handleEvent(this, eventType);
  }

  //region Getters and setters
  public void setState(State state) {
    mState = state;
  }

  public State getState() {
    return mState;
  }

  public StatesHolder getStatesHolder() {
    return mStatesHolder;
  }
  //endregion

  //region Collider
  @Override public void collide(CollidableActor c) {
    c.collideTo(this);
  }

  @Override public void collideTo(BaseActor base) {
    // runner and base
    Gdx.app.log(TAG, "Collision: runner to base");
  }

  @Override public void collideTo(GroundActor ground) {
    // runner and ground
    Gdx.app.log(TAG, "Collision: runner to ground");

    handleEvent(State.EVENT_TYPE_COLLISION_WITH_GROUND);
  }

  @Override public void collideTo(EnemyActor enemy) {
    // runner and enemy
    Gdx.app.log(TAG, "Collision: runner to enemy");

    handleEvent(State.EVENT_TYPE_COLLISION_WITH_ENEMY);
  }

  @Override public void collideTo(RunnerActor runner) {
    // runner and runner
    // *should never happen
    Gdx.app.log(TAG, "Collision: runner to runner");
  }
  //endregion
}
