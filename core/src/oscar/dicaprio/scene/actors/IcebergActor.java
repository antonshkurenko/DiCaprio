package oscar.dicaprio.scene.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.mechanics.userdata.IcebergUserData;

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
    mUserData = new IcebergUserData();
  }

  @Override public IcebergUserData getUserData() {
    return (IcebergUserData) mUserData;
  }

  //region Collider
  @Override public void collide(CollidableActor c) {
    c.collideTo(this);
  }

  @Override public void collideTo(BaseActor base) {

    // iceberg and base
    Gdx.app.log(TAG, "Collision: iceberg to base");
  }

  @Override public void collideTo(GroundActor ground) {

    // iceberg and ground
    Gdx.app.log(TAG, "Collision: iceberg to ground");
  }

  @Override public void collideTo(EnemyActor enemy) {

    // iceberg and enemy
    Gdx.app.log(TAG, "Collision: iceberg to enemy");
  }

  @Override public void collideTo(CoinActor coin) {

    // iceberg and coin
    Gdx.app.log(TAG, "Collision: iceberg to coin");
  }

  @Override public void collideTo(IcebergActor iceberg) {

    // iceberg and iceberg
    // *should never happen
    Gdx.app.log(TAG, "Collision: iceberg to iceberg");
  }
  //endregion
}
