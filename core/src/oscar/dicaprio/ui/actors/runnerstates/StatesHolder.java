package oscar.dicaprio.ui.actors.runnerstates;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/11/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public final class StatesHolder {

  // todo(tonyshkurenko), 2/11/16: lazy or instantly final?
  private State mDodgingState;
  private State mHitState;
  private State mRunningState;
  private State mJumpingState;

  //region Lazy getters
  public State getDodgingState() {

    if(mDodgingState == null) {
      mDodgingState = new DodgingState();
    }

    return mDodgingState;
  }

  public State getHitState() {
    if(mHitState == null) {
      mHitState = new HitState();
    }

    return mHitState;
  }

  public State getRunningState() {
    if(mRunningState == null) {
      mRunningState = new RunningState();
    }

    return mRunningState;
  }

  public State getJumpingState() {
    if(mJumpingState == null) {
      mJumpingState = new JumpingState();
    }

    return mJumpingState;
  }
  //endregion
}
