package oscar.dicaprio.scene.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.mechanics.box2d.CoinUserData;
import oscar.dicaprio.utils.C;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/11/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class CoinActor extends BaseActor {

  private static final String TAG = CoinActor.class.getSimpleName();

  private boolean mIsCollected = false;

  public CoinActor(Body body) {
    super(body);
  }

  @Override public CoinUserData getUserData() {

    if (mUserData == null) {
      mUserData = new CoinUserData(C.world.coin_diameter);
    }

    return (CoinUserData) mUserData;
  }

  @Override public void act(float delta) {
    super.act(delta);
    mBody.setLinearVelocity(getUserData().getLinearVelocity());
  }

  public void collect() {
    mIsCollected = true;
    getUserData().setRemovable();
  }

  public boolean isCollected() {
    return mIsCollected;
  }

  //region Collider
  @Override public void collide(CollidableActor c) {
    c.collideTo(this);
  }

  @Override public void collideTo(BaseActor base) {

    // coin and base
    Gdx.app.log(TAG, "Collision: coin to base");
  }

  @Override public void collideTo(GroundActor ground) {

    // coin and ground
    Gdx.app.log(TAG, "Collision: coin to ground");
  }

  @Override public void collideTo(EnemyActor enemy) {

    // coin and enemy
    Gdx.app.log(TAG, "Collision: coin to enemy");
  }

  @Override public void collideTo(CoinActor coin) {

    // coin and coin
    // *should never happen
    Gdx.app.log(TAG, "Collision: coin to coin");
  }
  //endregion
}
