package oscar.dicaprio.mechanics.physics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import oscar.dicaprio.mechanics.physics.enemies.Enemy;
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

    final Filter filter = new Filter();
    filter.categoryBits = C.world.ground_mask;
    filter.maskBits = C.world.runner_mask | C.world.snowball_mask;

    body.createFixture(shape, C.world.ground_density).setFilterData(filter);
    shape.dispose();
    return body;
  }

  public static Body createIceberg(World world) {

    final BodyDef bodyDef = new BodyDef();
    bodyDef.position.set(new Vector2(C.world.iceberg_x, C.world.iceberg_y));

    final Body body = world.createBody(bodyDef);
    final PolygonShape shape = new PolygonShape();

    /**
     *
     * Iceberg position
     * /\
     * |
     * |--
     * | |
     * | |
     * |---------------------|
     * |                     |
     * ----------------------->
     */
    shape.setAsBox(C.world.iceberg_width / 2f, C.world.iceberg_height / 2f);

    final Filter filter = new Filter();
    filter.categoryBits = C.world.iceberg_mask;
    filter.maskBits = C.world.runner_mask;

    final Fixture fixture = body.createFixture(shape, C.world.iceberg_density);
    fixture.setSensor(true);
    fixture.setFilterData(filter);

    shape.dispose();
    return body;
  }

  public static Body createSnowball(World world) {

    final BodyDef bodyDef = new BodyDef();
    bodyDef.type = BodyDef.BodyType.DynamicBody;
    bodyDef.position.set(new Vector2(C.world.snowball_x, C.world.snowball_y));

    final Body body = world.createBody(bodyDef);
    final CircleShape shape = new CircleShape();

    /**
     *
     * Iceberg position
     * /\
     * |
     * |--
     * | |() Snowball start position
     * | |
     * |---------------------|
     * |                     |
     * ----------------------->
     */
    shape.setRadius(C.world.snowball_diameter / 2f);

    final Filter filter = new Filter();
    filter.categoryBits = C.world.snowball_mask;
    filter.maskBits = C.world.runner_mask | C.world.ground_mask | C.world.enemy_mask;

    final Fixture fixture = body.createFixture(shape, C.world.snowball_density);
    fixture.setSensor(true);
    fixture.setFilterData(filter);

    shape.dispose();
    return body;
  }

  public static Body createRunner(World world) {
    final BodyDef bodyDef = new BodyDef();
    bodyDef.type = BodyDef.BodyType.DynamicBody;
    bodyDef.position.set(new Vector2(C.world.runner_x, C.world.runner_y));

    final Body body = world.createBody(bodyDef);
    final PolygonShape shape = new PolygonShape();

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

    final Filter filter = new Filter();
    filter.categoryBits = C.world.runner_mask;
    filter.maskBits = C.world.everything_mask;

    body.createFixture(shape, C.world.runner_density).setFilterData(filter);

    body.setGravityScale(C.world.runner_gravity_scale);
    body.resetMassData();
    shape.dispose();
    return body;
  }

  public static Body createEnemy(World world, Enemy enemyType) {

    final BodyDef bodyDef = new BodyDef();
    bodyDef.type = BodyDef.BodyType.KinematicBody;
    bodyDef.position.set(new Vector2(enemyType.getX(), enemyType.getY()));

    final Body body = world.createBody(bodyDef);
    final PolygonShape shape = new PolygonShape();

    final float enemyWidth = enemyType.getWidth();
    final float enemyHeight = enemyType.getHeight();

    /**
     * Since enemies are pretty different, I can't draw any of them here.
     * Look inside the factories to see schemas.
     */

    shape.setAsBox(enemyWidth / 2, enemyHeight / 2);

    final Filter filter = new Filter();
    filter.categoryBits = C.world.enemy_mask;
    filter.maskBits = C.world.runner_mask | C.world.snowball_mask;

    body.createFixture(shape, enemyType.getDensity()).setFilterData(filter);
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

    final Filter filter = new Filter();
    filter.categoryBits = C.world.coin_mask;
    filter.maskBits = C.world.runner_mask;

    final Fixture fixture = body.createFixture(shape, C.world.coin_density);
    fixture.setSensor(true);
    fixture.setFilterData(filter);

    body.resetMassData();
    shape.dispose();
    return body;
  }
}
