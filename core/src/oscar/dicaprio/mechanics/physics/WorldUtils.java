package oscar.dicaprio.mechanics.physics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import oscar.dicaprio.utils.Constants;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/8/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class WorldUtils {


  /**
   *
   * Physics coords
   *
   * /\ Y
   * |
   * |
   * |
   * |
   * |
   * |
   * |(0, 0)
   * ---------------------> X
   */

  public static World createWorld() {
    return new World(Constants.WORLD_GRAVITY, true);
  }

  public static Body createGround(World world) {

    final BodyDef bodyDef = new BodyDef();
    bodyDef.position.set(new Vector2(Constants.GROUND_X, Constants.GROUND_Y));

    final Body body = world.createBody(bodyDef);
    final PolygonShape shape = new PolygonShape();

    /**
     *
     * Ground position
     * /\
     * |
     * |---------------------| (50, 2)
     * |                     |
     * ----------------------->
     */
    shape.setAsBox(Constants.GROUND_WIDTH / 2f, Constants.GROUND_HEIGHT / 2f);
    body.createFixture(shape, Constants.GROUND_DENSITY);
    shape.dispose();
    return body;
  }
}
