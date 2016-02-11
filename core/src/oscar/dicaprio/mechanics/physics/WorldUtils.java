package oscar.dicaprio.mechanics.physics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import oscar.dicaprio.mechanics.box2d.EnemyUserData;
import oscar.dicaprio.mechanics.box2d.GroundUserData;
import oscar.dicaprio.mechanics.box2d.RunnerUserData;
import oscar.dicaprio.mechanics.physics.enemies.Enemy;
import oscar.dicaprio.mechanics.physics.enemies.EnemyGenerator;
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
    shape.setAsBox(Constants.GROUND_WIDTH / 2f, Constants.GROUND_HEIGHT / 2f);
    body.createFixture(shape, Constants.GROUND_DENSITY);
    shape.dispose();
    return body;
  }

  public static Body createRunner(World world) {
    final BodyDef bodyDef = new BodyDef();
    bodyDef.type = BodyDef.BodyType.DynamicBody;
    bodyDef.position.set(new Vector2(Constants.RUNNER_X, Constants.RUNNER_Y));

    final Body body = world.createBody(bodyDef);
    final PolygonShape shape = new PolygonShape();

    body.setUserData(new RunnerUserData(Constants.RUNNER_WIDTH, Constants.RUNNER_HEIGHT));

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
    shape.setAsBox(Constants.RUNNER_WIDTH / 2, Constants.RUNNER_HEIGHT / 2);
    body.createFixture(shape, Constants.RUNNER_DENSITY);
    body.setGravityScale(Constants.RUNNER_GRAVITY_SCALE);
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
    bodyDef.position.set(new Vector2(Constants.COIN_X, Constants.COIN_Y));

    final Body body = world.createBody(bodyDef);
    final PolygonShape shape = new PolygonShape();

    body.setUserData(new EnemyUserData(Constants.COIN_WIDTH, Constants.COIN_HEIGHT));

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

    shape.setAsBox(Constants.COIN_WIDTH / 2, Constants.COIN_HEIGHT / 2);
    body.createFixture(shape, Constants.COIN_DENSITY);
    body.setGravityScale(Constants.COIN_GRAVITY_SCALE);
    body.resetMassData();
    shape.dispose();
    return body;
  }
}
