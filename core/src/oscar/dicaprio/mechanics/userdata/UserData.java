package oscar.dicaprio.mechanics.userdata;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Physical parameters
 */
public abstract class UserData {

  protected float mWidth;
  protected float mHeight;

  public UserData(float width, float height) {
    mWidth = width;
    mHeight = height;
  }

  //region Getters and setters
  public float getWidth() {
    return mWidth;
  }

  public float getHeight() {
    return mHeight;
  }
  //endregion
}
