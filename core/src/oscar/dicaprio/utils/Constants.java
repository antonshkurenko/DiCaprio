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

  /**
   * Runner constants
   */
  public static final float RUNNER_X = 2;
  public static final float RUNNER_Y = GROUND_Y + GROUND_HEIGHT;
  public static final float RUNNER_WIDTH = 1f;
  public static final float RUNNER_HEIGHT = 2f;
  public static final float RUNNER_DENSITY = 0.5f;
  // jumping constants
  public static final float RUNNER_GRAVITY_SCALE = 3f;
  public static final Vector2 RUNNER_JUMPING_LINEAR_IMPULSE = new Vector2(0, 13f);
  // dodging constants
  public static final float RUNNER_DODGE_X = 2f;
  public static final float RUNNER_DODGE_Y = 1.5f;
  // hit constants
  public static final float RUNNER_HIT_ANGULAR_IMPULSE = 10f;

  /**
   * Enemy constants
   */
  public static final float ENEMY_X = 25f;
  public static final float ENEMY_DENSITY = RUNNER_DENSITY;
  public static final float RUNNING_SHORT_ENEMY_Y = 1.5f;
  public static final float RUNNING_LONG_ENEMY_Y = 2f;
  public static final float FLYING_ENEMY_Y = 3f;
  public static final Vector2 ENEMY_LINEAR_VELOCITY = new Vector2(-10f, 0);

  private Constants() {
    // never instantiate
  }
}
