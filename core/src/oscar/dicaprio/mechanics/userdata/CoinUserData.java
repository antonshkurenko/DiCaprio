package oscar.dicaprio.mechanics.userdata;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/11/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

import com.badlogic.gdx.math.Vector2;

/**
 * Class, that describes physical behavior and parameters of the enemy
 */
public class CoinUserData extends UserData implements RunnerUserData.OnVelocityChangeObserver {

  private Vector2 mLinearVelocity;

  public CoinUserData(float diameter, Vector2 startSpeed) {
    super(diameter, diameter);
    mLinearVelocity = new Vector2(startSpeed);
  }

  //region Getters and setters
  public Vector2 getLinearVelocity() {
    return new Vector2(mLinearVelocity);
  }
  //endregion

  //region Implements RunnerUserData.OnVelocityChangeObserver
  @Override public void onForwardSpeedChanged(RunnerUserData runnerData, Vector2 delta) {
    // ignored
  }

  @Override public void onBackwardSpeedChanged(RunnerUserData runnerData, Vector2 delta) {
    mLinearVelocity.sub(delta);
  }
  //endregion
}
