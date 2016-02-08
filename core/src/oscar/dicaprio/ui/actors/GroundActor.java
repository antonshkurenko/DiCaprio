package oscar.dicaprio.ui.actors;

import com.badlogic.gdx.physics.box2d.Body;
import oscar.dicaprio.mechanics.box2d.GroundUserData;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/8/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class GroundActor extends BaseActor {

  public GroundActor(Body body) {
    super(body);
  }

  @Override public GroundUserData getUserData() {
    return ((GroundUserData) mUserData);
  }
}
