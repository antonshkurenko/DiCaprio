package oscar.dicaprio.scene.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.mechanics.box2d.RunnerUserData;
import oscar.dicaprio.scene.actors.runnerstates.AbstractAliveState;
import oscar.dicaprio.scene.actors.runnerstates.State;
import oscar.dicaprio.scene.actors.runnerstates.StatesHolder;
import oscar.dicaprio.utils.Bank;
import oscar.dicaprio.utils.Constants;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/8/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Actor, that consists of the physical body and physical params of the runner
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

  //region Handling by state
  public void handleInput(int inputType) {
    mState.handleInput(this, inputType);
  }

  public void handleEvent(int eventType) {
    mState.handleEvent(this, eventType);
  }
  //endregion

  //region Getters and setters
  public void setState(State state) {
    mState = state;
  }

  public StatesHolder getStatesHolder() {
    return mStatesHolder;
  }

  public boolean isAlive() {
    return mState instanceof AbstractAliveState;
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

    handleEvent(Constants.EVENT_TYPE_COLLISION_RUNNER_WITH_GROUND);
  }

  @Override public void collideTo(EnemyActor enemy) {
    // runner and enemy
    Gdx.app.log(TAG, "Collision: runner to enemy");

    handleEvent(Constants.EVENT_TYPE_COLLISION_RUNNER_WITH_ENEMY);
  }

  @Override public void collideTo(RunnerActor runner) {
    // runner and runner
    // *should never happen
    Gdx.app.log(TAG, "Collision: runner to runner");
  }

  @Override public void collideTo(CoinActor coin) {
    // runner and coin
    Gdx.app.log(TAG, "Collision: runner to coin");

    // collect coin inside, because it's related to state
    handleEvent(Constants.EVENT_TYPE_COLLISION_RUNNER_WITH_COIN);

    // remove coin here
    Bank.getInstance().incrementCoins();
    // todo(tonyshkurenko), 2/11/16: coin can not be deleted, while world is stepping
    /**
     * https://www.iforce2d.net/b2dtut/sensors
     * http://www.iforce2d.net/b2dtut/collision-filtering
     * http://www.emanueleferonato.com/2010/02/25/box2d-flash-game-creation-tutorial-part-2/
     * http://code.tutsplus.com/tutorials/build-a-physics-based-platformer-in-under-an-hour--active-7324
     */
    coin.getBody().getWorld().destroyBody(coin.getBody());
  }
  //endregion
}
