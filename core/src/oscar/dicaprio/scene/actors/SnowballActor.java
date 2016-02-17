package oscar.dicaprio.scene.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import java.util.Random;
import oscar.dicaprio.mechanics.box2d.SnowballUserData;
import oscar.dicaprio.utils.C;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/16/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class SnowballActor extends BaseActor implements Removable {
  private static final String TAG = CoinActor.class.getSimpleName();

  private boolean mIsStriked = false;

  public static SnowballActor createRandom(Body body) {
    return new SnowballActor(body, new Random().nextInt(100) - 60f);
  }

  public SnowballActor(Body body, float angle) {
    super(body);
    mUserData = new SnowballUserData(C.world.snowball_diameter, angle);
  }

  @Override public SnowballUserData getUserData() {
    return (SnowballUserData) mUserData;
  }

  @Override public void act(float delta) {
    super.act(delta);
    mBody.setLinearVelocity(getUserData().getLinearVelocity());
  }

  //region Implements Removable
  @Override public void setRemovable() {
    mIsStriked = true;
  }

  @Override public boolean isRemovable() {
    return mIsStriked;
  }
  //endregion

  //region Collider
  @Override public void collide(CollidableActor c) {
    c.collideTo(this);
  }

  @Override public void collideTo(BaseActor base) {

    // snowball and base
    Gdx.app.log(TAG, "Collision: snowball to base");
  }

  @Override public void collideTo(GroundActor ground) {

    // snowball and ground
    Gdx.app.log(TAG, "Collision: snowball to ground");

    setRemovable();
  }

  @Override public void collideTo(EnemyActor enemy) {

    // snowball and enemy
    Gdx.app.log(TAG, "Collision: snowball to enemy");

    setRemovable();
  }

  @Override public void collideTo(CoinActor coin) {

    // snowball and coin
    Gdx.app.log(TAG, "Collision: snowball to coin");
  }

  @Override public void collideTo(IcebergActor iceberg) {

    // snowball and iceberg
    Gdx.app.log(TAG, "Collision: snowball to iceberg");
  }

  @Override public void collideTo(SnowballActor snowball) {

    // snowball and snowball
    Gdx.app.log(TAG, "Collision: snowball to snowball");
  }
  //endregion
}
