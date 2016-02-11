package oscar.dicaprio.scene.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import oscar.dicaprio.mechanics.box2d.EnemyUserData;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Actor, that consists of the physical body and physical params of the enemy
 */
public class EnemyActor extends BaseActor {

  private static final String TAG = EnemyActor.class.getSimpleName();

  public EnemyActor(Body body) {
    super(body);
  }

  @Override public EnemyUserData getUserData() {
    return (EnemyUserData) mUserData;
  }

  /**
   * if {@link EnemyActor} will have different states (as {@link RunnerActor})
   * create act method for every state
   *
   * @param delta time after last {@link Actor#act}
   */
  @Override public void act(float delta) {
    super.act(delta);
    mBody.setLinearVelocity(getUserData().getLinearVelocity());
  }

  //region Collider
  @Override public void collide(CollidableActor c) {
    c.collideTo(this);
  }

  @Override public void collideTo(BaseActor base) {
    // enemy and base object
    Gdx.app.log(TAG, "Collision: enemy to base");
  }

  @Override public void collideTo(GroundActor ground) {
    // enemy and ground
    Gdx.app.log(TAG, "Collision: enemy to ground");
  }

  @Override public void collideTo(EnemyActor enemy) {
    // enemy and enemy
    Gdx.app.log(TAG, "Collision: enemy to enemy");
  }
  //endregion
}
