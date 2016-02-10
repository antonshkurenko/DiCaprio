package oscar.dicaprio.ui.actors;

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
}
