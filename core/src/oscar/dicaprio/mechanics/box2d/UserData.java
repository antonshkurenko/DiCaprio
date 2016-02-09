package oscar.dicaprio.mechanics.box2d;

import oscar.dicaprio.utils.UserDataType;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public abstract class UserData {

  protected float mWidth;
  protected float mHeight;

  public UserData(float width, float height) {
    mWidth = width;
    mHeight = height;
  }

  public abstract UserDataType getUserDataType();

  //region Getters and setters
  public float getWidth() {
    return mWidth;
  }

  public float getHeight() {
    return mHeight;
  }
  //endregion
}
