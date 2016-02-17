package oscar.dicaprio.utils;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/7/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Sad, that it's too long to implement own Annotation processor
 * Trying to make something like android.R file
 */

/**
 * !!! IMPORTANT !!!
 * Since I met this trouble already 2-3 times, I write this description:
 *
 * Vector2 is mutable type.
 * Constants here are only refs to the objects.
 * Never assign anything to this vectors.
 * Use only {@link Vector2#set} or {@link Vector2#Vector2(Vector2)}
 */
public final class C {

  public final static class app {
    /**
     * Desktop window size
     */
    public static final int app_width = 800;
    public static final int app_height = 480;
  }

  public final static class world {
    /**
     * World's gravity vector (g ~ 10)
     */
    public static final Vector2 world_gravity = new Vector2(0, -10); // read descr

    public static final int everything_mask = 0xFFFFFFFF;

    /**
     * Ground constants
     */
    public static final float ground_x = 0f;
    public static final float ground_y = 0f;
    public static final float ground_width = 50f; // in meters
    public static final float ground_height = 2f; // in meters
    public static final float ground_density = 0f;
    public static final int ground_mask = 0x00000001;

    /**
     * Iceberg constants
     */
    public static final float iceberg_x = 0f;
    public static final float iceberg_y = ground_y + ground_height;
    public static final float iceberg_width = 2f; // in meters
    public static final float iceberg_height = 7f; // in meters
    public static final float iceberg_density = 0f;
    public static final int iceberg_mask = 0x00000002;

    /**
     * Runner constants
     */
    public static final float runner_x = 6.5f;
    public static final float runner_y = ground_y + ground_height;
    public static final float runner_width = 1f;
    public static final float runner_height = 2f;
    public static final float runner_density = 0.5f;
    public static final Vector2 runner_linear_forward_velocity = new Vector2(2f, 0f); // read descr
    public static final Vector2 runner_linear_backward_velocity = new Vector2(2f, 0f); // read descr
    // jumping constants
    public static final float runner_gravity_scale = 3f;
    public static final Vector2 runner_jumping_linear_impulse = new Vector2(0, 13f); // read descr
    // dodging constants
    public static final float runner_dodge_x = 6.5f;
    public static final float runner_dodge_y = 1.5f;
    // hit constants
    public static final float runner_hit_angular_impulse = 10f;
    // frozen constants
    public static final Vector2 runner_max_slow_speed = new Vector2(0.25f, 0f); // read descr
    public static final int runner_mask = 0x00000004;

    /**
     * Enemy constants
     */
    public static final float enemy_x = 25f;
    public static final float enemy_density = runner_density;
    public static final float enemy_running_short_y = 1.5f;
    public static final float enemy_running_long_y = 2f;
    public static final float enemy_flying_y = 3f;
    public static final Vector2 enemy_linear_velocity = new Vector2(-10f, 0); // read descr
    public static final int enemy_mask = 0x00000008;

    /**
     * Coin constants
     */
    public static final float coin_x = 25f;
    public static final float coin_y = 1.5f;
    public static final float coin_density = runner_density;
    public static final float coin_diameter = 1f;
    public static final Vector2 coin_linear_velocity = new Vector2(-10f, 0); // read descr
    public static final int coin_mask = 0x00000010;

    /**
     * Snowball constants
     */
    public static final float snowball_x = 2f;
    public static final float snowball_y = 5f;
    public static final float snowball_density = runner_density;
    public static final float snowball_diameter = 0.5f;
    public static final Vector2 snowball_linear_velocity = new Vector2(1f, 1f); // read descr
    public static final int snowball_mask = 0x00000020;
  }

  public final static class input {

    /**
     * Input constants
     */
    public static final int input_type_nothing = 0;
    public static final int input_left_touch_down = -1;
    public static final int input_left_touch_up = -2;
    public static final int input_right_touch_down = 1;
    public static final int input_right_touch_up = 2;
  }

  public final static class event {

    /**
     * Event constants
     */
    public static final int event_collision_runner_with_ground = 1;
    public static final int event_collision_runner_with_enemy = 2;
    public static final int event_collision_runner_with_coin = 3;
    public static final int event_collision_runner_with_iceberg = 4;
    public static final int event_collision_runner_with_snowball = 5;
  }

  private C() {
    // never instantiate
  }
}
