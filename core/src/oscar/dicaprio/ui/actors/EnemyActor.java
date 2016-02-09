package oscar.dicaprio.ui.actors;

import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.mechanics.box2d.EnemyUserData;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class EnemyActor extends BaseActor {

  public EnemyActor(Body body) {
    super(body);
  }

  @Override public EnemyUserData getUserData() {
    return (EnemyUserData) mUserData;
  }

  @Override public void act(float delta) {
    super.act(delta);
    mBody.setLinearVelocity(getUserData().getLinearVelocity());
  }
}
