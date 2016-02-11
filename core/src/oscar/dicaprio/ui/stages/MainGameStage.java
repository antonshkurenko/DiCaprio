package oscar.dicaprio.ui.stages;

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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;
import java.util.List;
import oscar.dicaprio.mechanics.physics.BodyUtils;
import oscar.dicaprio.mechanics.physics.WorldUtils;
import oscar.dicaprio.mechanics.physics.enemies.Enemy;
import oscar.dicaprio.ui.actors.BaseActor;
import oscar.dicaprio.ui.actors.EnemyActor;
import oscar.dicaprio.ui.actors.GroundActor;
import oscar.dicaprio.ui.actors.RunnerActor;
import oscar.dicaprio.ui.actors.runnerstates.HitState;
import oscar.dicaprio.ui.actors.runnerstates.State;

/**
 * Created by: Anton Shkurenko (cullycross) Project: DiCaprio Date: 2/8/16 Code style:
 * SquareAndroid
 * (https://github.com/square/java-code-styles) Follow me: @tonyshkurenko
 */
public class MainGameStage extends Stage implements ContactListener {

  // This will be our viewport measurements while working with the debug renderer
  private static final int VIEWPORT_WIDTH = 20;
  private static final int VIEWPORT_HEIGHT = 13;

  private static final float TIME_STEP = 1 / 300f;

  private static final int VELOCITY_ITERATIONS = 8;
  private static final int POSITION_ITERATIONS = 3;

  private final Box2DDebugRenderer mRenderer = new Box2DDebugRenderer();

  private OrthographicCamera mCamera;

  private World mWorld;
  private GroundActor mGround;
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

  @Override public void act(float delta) {
    super.act(delta);

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

    int inputType = State.INPUT_TYPE_NOTHING;
    if (rightSideTouched(touchPoint.x, touchPoint.y)) {
      inputType = State.INPUT_TYPE_RIGHT_TOUCH_DOWN;
    } else if (leftSideTouched(touchPoint.x, touchPoint.y)) {
      inputType = State.INPUT_TYPE_LEFT_TOUCH_DOWN;
    }

    mRunner.handleInput(inputType);

    return super.touchDown(x, y, pointer, button);
  }

  @Override public boolean touchUp(int x, int y, int pointer, int button) {

    final Vector3 touchPoint = translateScreenToWorldCoordinates(x, y);

    int inputType = State.INPUT_TYPE_NOTHING;
    if (rightSideTouched(touchPoint.x, touchPoint.y)) {
      inputType = State.INPUT_TYPE_RIGHT_TOUCH_UP;
    } else if (leftSideTouched(touchPoint.x, touchPoint.y)) {
      inputType = State.INPUT_TYPE_LEFT_TOUCH_UP;
    }

    mRunner.handleInput(inputType);

    return super.touchUp(x, y, pointer, button);
  }

  //endregion

  //region Implements ContactListener
  @Override public void beginContact(Contact contact) {

    final Body a = contact.getFixtureA().getBody();
    final Body b = contact.getFixtureB().getBody();

    BaseActor aActor = null;
    BaseActor bActor = null;

    final Array<Actor> actors = getActors();
    for (Actor actor : actors) {

      try {

        final BaseActor baseActor = (BaseActor) actor;
        if (baseActor.getBody().equals(a)) {
          aActor = baseActor;
        } else if (baseActor.getBody().equals(b)) {
          bActor = baseActor;
        }
      } catch (ClassCastException ignored) {
        // ClassCast > instanceof
      }

      if(aActor != null && bActor != null) {
        aActor.collide(bActor);
        break;
      }
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
    setUpRunner();
  }

  private void setUpGround() {
    mGround = new GroundActor(WorldUtils.createGround(mWorld));
    addActor(mGround);
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
    if (!BodyUtils.bodyInBounds(body)) {
      if (BodyUtils.bodyIsEnemy(body)
          && !(mRunner.getState() instanceof HitState)) { // todo(tonyshkurenko), 2/11/16: rework "instance of"
        createEnemy();
      }
      mWorld.destroyBody(body);
    }
  }

  private void createEnemy() {
    final EnemyActor enemy = new EnemyActor(WorldUtils.createEnemy(mWorld));
    addActor(enemy);
  }
  //endregion
}
