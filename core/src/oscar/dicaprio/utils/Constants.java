package oscar.dicaprio.utils;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/7/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class Constants {

  /**
   * Desktop window size
   */
  public static final int APP_WIDTH = 800;
  public static final int APP_HEIGHT = 480;

  /**
   * World's gravity vector (g ~ 10)
   */
  public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);

  /**
   * Ground constants
   */
  public static final float GROUND_X = 0;
  public static final float GROUND_Y = 0;
  public static final float GROUND_WIDTH = 50f; // in meters
  public static final float GROUND_HEIGHT = 2f; // in meters
  public static final float GROUND_DENSITY = 0f;

  private Constants() {
    // never instantiate
  }
}
