package oscar.dicaprio.utils;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/7/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public final class C {

  public static class app {
    /**
     * Desktop window size
     */
    public static final int app_width = 800;
    public static final int app_height = 480;
  }

  public static class world {
    /**
     * World's gravity vector (g ~ 10)
     */
    public static final Vector2 world_gravity = new Vector2(0, -10);

    /**
     * Ground constants
     */
    public static final float ground_x = 0;
    public static final float ground_y = 0;
    public static final float ground_width = 50f; // in meters
    public static final float ground_height = 2f; // in meters
    public static final float ground_density = 0f;

    /**
     * Runner constants
     */
    public static final float runner_x = 2;
    public static final float runner_y = ground_y + ground_height;
    public static final float runner_width = 1f;
    public static final float runner_height = 2f;
    public static final float runner_density = 0.5f;
    // jumping constants
    public static final float runner_gravity_scale = 3f;
    public static final Vector2 runner_jumping_linear_impulse = new Vector2(0, 13f);
    // dodging constants
    public static final float runner_dodge_x = 2f;
    public static final float runner_dodge_y = 1.5f;
    // hit constants
    public static final float runner_hit_angular_impulse = 10f;

    /**
     * Enemy constants
     */
    public static final float enemy_x = 25f;
    public static final float enemy_density = runner_density;
    public static final float enemy_running_short_y = 1.5f;
    public static final float enemy_running_long_y = 2f;
    public static final float enemy_flying_y = 3f;
    public static final Vector2 enemy_linear_velocity = new Vector2(-10f, 0);

    /**
     * Coin constants
     */
    public static final float coin_x = 25f;
    public static final float coin_y = 1.5f;
    public static final float coin_density = runner_density;
    public static final float coin_diameter = 1f;
    public static final Vector2 coin_linear_velocity = new Vector2(-10f, 0);
  }

  public static class input {

    /**
     * Input constants
     */
    public static final int input_type_nothing = 0;
    public static final int input_left_touch_down = -1;
    public static final int input_left_touch_up = -2;
    public static final int input_right_touch_down = 1;
    public static final int input_right_touch_up = 2;
  }

  public static class event {

    /**
     * Event constants
     */
    public static final int event_collision_runner_with_ground = 1;
    public static final int event_collision_runner_with_enemy = 2;
    public static final int event_collision_runner_with_coin = 3;
  }

  private C() {
    // never instantiate
  }
}
