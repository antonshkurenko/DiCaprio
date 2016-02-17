package oscar.dicaprio.scene.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.mechanics.map.MapGenerator;
import oscar.dicaprio.mechanics.userdata.UserData;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/8/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Actor, that consists of the physical body and physical params
 */
public abstract class BaseActor extends CollidableActor {

  private static final String TAG = BaseActor.class.getSimpleName();

  protected final Body mBody;
  protected UserData mUserData;

  public BaseActor(Body body) {
    this.mBody = body;
    this.mBody.setUserData(this);
  }

  public abstract UserData getUserData();

  public Body getBody() {
    return mBody;
  }

  @Override public void act(float delta) {
    super.act(delta);
    update();
  }

  public void update() {

  }

  @Override public boolean remove() {
    MapGenerator.getInstance().removeActor(this);
    return super.remove();
  }

  //region Collider
  @Override public void collide(CollidableActor c) {
    c.collideTo(this);
  }

  @Override public void collideTo(BaseActor base) {
    // base object and base object
    Gdx.app.log(TAG, "Collision: base to base");
  }
  //endregion
}
