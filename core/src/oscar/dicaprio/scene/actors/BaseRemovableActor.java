package oscar.dicaprio.scene.actors;

import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/17/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public abstract class BaseRemovableActor extends BaseActor implements Removable {

  protected boolean mIsRemovable = false;

  public BaseRemovableActor(Body body) {
    super(body);
  }

  @Override public void setRemovable() {
    mIsRemovable = true;
  }

  @Override public boolean isRemovable() {
    return mIsRemovable;
  }
}
