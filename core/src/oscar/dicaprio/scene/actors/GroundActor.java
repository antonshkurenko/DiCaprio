package oscar.dicaprio.scene.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.mechanics.box2d.GroundUserData;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/8/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Actor, that consists of the physical body and physical params of the ground
 */
public class GroundActor extends BaseActor {

  private static final String TAG = GroundActor.class.getSimpleName();

  public GroundActor(Body body) {
    super(body);
  }

  @Override public GroundUserData getUserData() {
    return ((GroundUserData) mUserData);
  }

  //region Collider
  @Override public void collide(CollidableActor c) {
    c.collideTo(this);
  }

  @Override public void collideTo(BaseActor base) {
    // ground and base
    Gdx.app.log(TAG, "Collision: ground to base");
  }

  @Override public void collideTo(GroundActor ground) {
    // ground and ground
    // *should never happen
    Gdx.app.log(TAG, "Collision: ground to ground");
  }
  //endregion
}
