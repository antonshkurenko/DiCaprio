package oscar.dicaprio.ui.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import oscar.dicaprio.mechanics.box2d.UserData;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/8/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public abstract class BaseActor extends Actor {

  protected final Body mBody;
  protected final UserData mUserData;

  public BaseActor(Body mBody) {
    this.mBody = mBody;
    this.mUserData = ((UserData) mBody.getUserData());
  }

  public abstract UserData getUserData();
}
