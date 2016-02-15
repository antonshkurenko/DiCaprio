package oscar.dicaprio.scene.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import oscar.dicaprio.mechanics.physics.BodyUtils;
import oscar.dicaprio.mechanics.physics.WorldUtils;
import oscar.dicaprio.mechanics.physics.enemies.Enemy;
import oscar.dicaprio.mechanics.physics.enemies.EnemyGenerator;
import oscar.dicaprio.scene.actors.BaseActor;
import oscar.dicaprio.scene.actors.CoinActor;
import oscar.dicaprio.scene.actors.EnemyActor;
import oscar.dicaprio.scene.actors.GroundActor;
import oscar.dicaprio.scene.actors.IcebergActor;
import oscar.dicaprio.scene.actors.RunnerActor;
import oscar.dicaprio.utils.C;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/8/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class MainGameStage extends Stage implements ContactListener {

  private static final String TAG = MainGameStage.class.getSimpleName();

  // This will be our viewport measurements while working with the debug renderer
  private static final int VIEWPORT_WIDTH = 20;
  private static final int VIEWPORT_HEIGHT = 13;

  // Each Box2d step will simulate TIME_STEP seconds step in real life
  private static final float TIME_STEP = 1 / 300f;

  private static final int VELOCITY_ITERATIONS = 8;
  private static final int POSITION_ITERATIONS = 3;

  // Temp renderer
  private final Box2DDebugRenderer mRenderer = new Box2DDebugRenderer();

  private final EnemyGenerator mEnemyGenerator = new EnemyGenerator();

  private OrthographicCamera mCamera;

  private World mWorld;
  private GroundActor mGround;
  private IcebergActor mIceberg;
  private RunnerActor mRunner;

  private float mAccumulator = 0f;

  private Rectangle mScreenRightSide;
  private Rectangle mScreenLeftSide;

  public MainGameStage() {
    setUpWorld();
    setUpCamera();
    setUpTouchControlAreas();

    createEnemy();
  }

  // todo(tonyshkurenko), 2/11/16: never do the same
  // just for testing coins
  private float counter;
  private static final float MORE = 0.5f;

  @Override public void act(float delta) {
    super.act(delta);

    counter += delta;
    if (counter >= MORE) {
      //Gdx.app.log(TAG, "::act(delta), coin creation.");
      createCoin();
      counter -= MORE;
    }

    final Array<Body> bodies = new Array<>(mWorld.getBodyCount());
    mWorld.getBodies(bodies);

    for (Body body : bodies) {
      update(body);
    }

    // Fixed timestep
    mAccumulator += delta;

    while (mAccumulator >= delta) {

      mWorld.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
      mAccumulator -= TIME_STEP;
    }

    //TODO: Implement interpolation
  }

  @Override public void draw() {
    super.draw();
    mRenderer.render(mWorld, mCamera.combined);
  }

  //region Implements InputProcessor

  /**
   * Stage itself extends from the InputProcessor
   */
  @Override public boolean touchDown(int x, int y, int pointer, int button) {

    // Need to get the actual coordinates
    final Vector3 touchPoint = translateScreenToWorldCoordinates(x, y);

    int inputType = C.input.input_type_nothing;
    if (rightSideTouched(touchPoint.x, touchPoint.y)) {
      inputType = C.input.input_right_touch_down;
    } else if (leftSideTouched(touchPoint.x, touchPoint.y)) {
      inputType = C.input.input_left_touch_down;
    }

    mRunner.handleInput(inputType);

    return super.touchDown(x, y, pointer, button);
  }

  @Override public boolean touchUp(int x, int y, int pointer, int button) {

    final Vector3 touchPoint = translateScreenToWorldCoordinates(x, y);

    int inputType = C.input.input_type_nothing;
    if (rightSideTouched(touchPoint.x, touchPoint.y)) {
      inputType = C.input.input_right_touch_up;
    } else if (leftSideTouched(touchPoint.x, touchPoint.y)) {
      inputType = C.input.input_left_touch_up;
    }

    mRunner.handleInput(inputType);

    return super.touchUp(x, y, pointer, button);
  }

  //endregion

  //region Implements ContactListener
  @Override public void beginContact(Contact contact) {

    final Body a = contact.getFixtureA().getBody();
    final Body b = contact.getFixtureB().getBody();

    try {

      final BaseActor aActor = ((BaseActor) a.getUserData());
      final BaseActor bActor = ((BaseActor) b.getUserData());
      if (aActor != null && bActor != null) {
        Gdx.app.log(TAG,
            "Before collision: aActor = " + aActor.getClass().getSimpleName() + ", bActor = "
                + bActor.getClass().getSimpleName());

        aActor.collide(bActor);
      }
    } catch (ClassCastException ignored) {

    }
  }

  @Override public void endContact(Contact contact) {

  }

  @Override public void preSolve(Contact contact, Manifold oldManifold) {

  }

  @Override public void postSolve(Contact contact, ContactImpulse impulse) {

  }
  //endregion

  //region Gesture util functions
  private boolean rightSideTouched(float x, float y) {
    return mScreenRightSide.contains(x, y);
  }

  private boolean leftSideTouched(float x, float y) {
    return mScreenLeftSide.contains(x, y);
  }

  /**
   * Helper function to get the actual coordinates in my world
   */
  private Vector3 translateScreenToWorldCoordinates(int x, int y) {
    final Vector3 touchPoint = new Vector3();
    getCamera().unproject(touchPoint.set(x, y, 0));
    return touchPoint;
  }
  //endregion

  //region Set up methods
  private void setUpWorld() {
    mWorld = WorldUtils.createWorld();
    mWorld.setContactListener(this);
    setUpGround();
    setUpIceberg();
    setUpRunner();
  }

  private void setUpGround() {
    mGround = new GroundActor(WorldUtils.createGround(mWorld));
    addActor(mGround);
  }

  private void setUpIceberg() {
    mIceberg = new IcebergActor(WorldUtils.createIceberg(mWorld));
    addActor(mIceberg);
  }

  private void setUpRunner() {
    mRunner = new RunnerActor(WorldUtils.createRunner(mWorld));
    addActor(mRunner);
  }

  private void setUpCamera() {
    mCamera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
    mCamera.position.set(mCamera.viewportWidth / 2, mCamera.viewportHeight / 2, 0f);
    mCamera.update();
  }

  private void setUpTouchControlAreas() {
    mScreenLeftSide =
        new Rectangle(0, 0, getCamera().viewportWidth / 2, getCamera().viewportHeight);
    mScreenRightSide =
        new Rectangle(getCamera().viewportWidth / 2, 0, getCamera().viewportWidth / 2,
            getCamera().viewportHeight);
    Gdx.input.setInputProcessor(this);
  }
  //endregion

  //region Util step methods
  private void update(Body body) {

    boolean destroy = false;

    if (!BodyUtils.bodyInLeftBound(body)) {
      if (mRunner.isAlive() && BodyUtils.bodyIsEnemy(body)) {
        createEnemy();
      }

      destroy = true;
    }

    if (BodyUtils.bodyIsCoin(body) && ((CoinActor) body.getUserData()).getUserData()
        .isRemovable()) {
      destroy = true;
    }

    if (destroy) {
      try {
        // Idk why, I caught the exception below
        //noinspection ConstantConditions
        final BaseActor actor = ((BaseActor) body.getUserData());

        mWorld.destroyBody(body);
        getActors().removeValue(actor, false);
      } catch (ClassCastException ignored) {

      }
    }
  }

  private void createEnemy() {

    final Enemy enemyType = mEnemyGenerator.getRandomEnemy();
    final EnemyActor enemy = new EnemyActor(WorldUtils.createEnemy(mWorld, enemyType),
        enemyType); // todo(tonyshkurenko), 2/15/16: remove doubling
    addActor(enemy);
  }

  private void createCoin() {
    final CoinActor coin = new CoinActor(WorldUtils.createCoin(mWorld));
    addActor(coin);
  }
  //endregion
}
