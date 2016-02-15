package oscar.dicaprio.scene.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.mechanics.box2d.IcebergUserData;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/15/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class IcebergActor extends BaseActor {

  private static final String TAG = IcebergActor.class.getSimpleName();

  public IcebergActor(Body body) {
    super(body);
  }

  @Override public IcebergUserData getUserData() {

    if (mUserData == null) {
      mUserData = new IcebergUserData();
    }

    return (IcebergUserData) mUserData;
  }

  //region Collider
  @Override public void collide(CollidableActor c) {
    c.collideTo(this);
  }

  @Override public void collideTo(BaseActor base) {

    // coin and base
    Gdx.app.log(TAG, "Collision: iceberg to base");
  }

  @Override public void collideTo(GroundActor ground) {

    // coin and ground
    Gdx.app.log(TAG, "Collision: iceberg to ground");
  }

  @Override public void collideTo(EnemyActor enemy) {

    // coin and enemy
    Gdx.app.log(TAG, "Collision: iceberg to enemy");
  }

  @Override public void collideTo(CoinActor coin) {

    // coin and coin
    // *should never happen
    Gdx.app.log(TAG, "Collision: iceberg to coin");
  }

  @Override public void collideTo(IcebergActor coin) {

    // coin and coin
    // *should never happen
    Gdx.app.log(TAG, "Collision: iceberg to iceberg");
  }
  //endregion
}
