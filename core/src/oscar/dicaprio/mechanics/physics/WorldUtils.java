package oscar.dicaprio.mechanics.physics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import oscar.dicaprio.mechanics.box2d.CoinUserData;
import oscar.dicaprio.mechanics.box2d.EnemyUserData;
import oscar.dicaprio.mechanics.box2d.GroundUserData;
import oscar.dicaprio.mechanics.box2d.RunnerUserData;
import oscar.dicaprio.mechanics.physics.enemies.Enemy;
import oscar.dicaprio.mechanics.physics.enemies.EnemyGenerator;
import oscar.dicaprio.utils.C;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/8/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class WorldUtils {

  /**
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
    return new World(C.world.world_gravity, true);
  }

  public static Body createGround(World world) {

    final BodyDef bodyDef = new BodyDef();
    bodyDef.position.set(new Vector2(C.world.ground_x, C.world.ground_y));

    final Body body = world.createBody(bodyDef);
    final PolygonShape shape = new PolygonShape();

    body.setUserData(new GroundUserData());

    /**
     *
     * Ground position
     * /\
     * |
     * |---------------------| (50, 2)
     * |                     |
     * ----------------------->
     */
    shape.setAsBox(C.world.ground_width / 2f, C.world.ground_height / 2f);
    body.createFixture(shape, C.world.ground_density);
    shape.dispose();
    return body;
  }

  public static Body createRunner(World world) {
    final BodyDef bodyDef = new BodyDef();
    bodyDef.type = BodyDef.BodyType.DynamicBody;
    bodyDef.position.set(new Vector2(C.world.runner_x, C.world.runner_y));

    final Body body = world.createBody(bodyDef);
    final PolygonShape shape = new PolygonShape();

    body.setUserData(new RunnerUserData(C.world.runner_width, C.world.runner_height));

    /**
     * /\
     * |
     * |
     * |     ---
     * |     | |
     * |----------Ground position
     * |
     * --------------------------->
     */
    shape.setAsBox(C.world.runner_width / 2, C.world.runner_height / 2);
    body.createFixture(shape, C.world.runner_density);
    body.setGravityScale(C.world.runner_gravity_scale);
    body.resetMassData();
    shape.dispose();
    return body;
  }

  public static Body createEnemy(World world) {
    final Enemy enemyType = new EnemyGenerator().getRandomEnemy();

    final BodyDef bodyDef = new BodyDef();
    bodyDef.type = BodyDef.BodyType.KinematicBody;
    bodyDef.position.set(new Vector2(enemyType.getX(), enemyType.getY()));

    final Body body = world.createBody(bodyDef);
    final PolygonShape shape = new PolygonShape();

    final float enemyWidth = enemyType.getWidth();
    final float enemyHeight = enemyType.getHeight();

    body.setUserData(new EnemyUserData(enemyWidth, enemyHeight));

    /**
     * Since enemies are pretty different, I can't draw any of them here.
     * Look inside the factories to see schemas.
     */

    shape.setAsBox(enemyWidth / 2, enemyHeight / 2);
    body.createFixture(shape, enemyType.getDensity());
    body.resetMassData();
    shape.dispose();
    return body;
  }

  public static Body createCoin(World world) {

    final BodyDef bodyDef = new BodyDef();
    bodyDef.type = BodyDef.BodyType.KinematicBody;
    bodyDef.position.set(new Vector2(C.world.coin_x, C.world.coin_y));

    final Body body = world.createBody(bodyDef);
    final CircleShape shape = new CircleShape();

    body.setUserData(new CoinUserData(C.world.coin_diameter));

    /**
     * Draw coin
     *
     * /**
     * /\   End of the screen
     * |          |
     * |          |
     * |          |     ___
     * |          |     |_|
     * |---------------------Ground position
     * |
     * --------------------------->
     */

    shape.setRadius(C.world.coin_diameter / 2);
    body.createFixture(shape, C.world.coin_density)
        .setSensor(true);
    body.resetMassData();
    shape.dispose();
    return body;
  }
}
