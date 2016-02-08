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
import com.badlogic.gdx.scenes.scene2d.Stage;
import oscar.dicaprio.mechanics.physics.BodyUtils;
import oscar.dicaprio.mechanics.physics.WorldUtils;
import oscar.dicaprio.ui.actors.GroundActor;
import oscar.dicaprio.ui.actors.RunnerActor;

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

  private final Box2DDebugRenderer mRenderer = new Box2DDebugRenderer();

  private OrthographicCamera mCamera;

  private World mWorld;
  private GroundActor mGround;
  private RunnerActor mRunner;

  private float mAccumulator = 0f;

  // todo(tonyshkurenko), 2/9/16: aint sure we really need this, think about recreating, and delete global instance
  private Rectangle mScreenRightSide;

  public MainGameStage() {
    setUpWorld();
    setUpCamera();
    setUpTouchControlAreas();
  }

  @Override public void act(float delta) {
    super.act(delta);

    // Fixed timestep
    mAccumulator += delta;

    while (mAccumulator >= delta) {

      // todo(tonyshkurenko), 2/8/16: check info about 6 and 2, I don't remember what is this
      mWorld.step(TIME_STEP, 6, 2);
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

    if (rightSideTouched(touchPoint.x, touchPoint.y)) {
      mRunner.jump();
    }

    return super.touchDown(x, y, pointer, button);
  }
  //endregion

  //region Implements ContactListener
  @Override public void beginContact(Contact contact) {

    // todo(tonyshkurenko), 2/9/16: looks shitty, rework it, to avoid lots of "ifs" later

    final Body a = contact.getFixtureA().getBody();
    final Body b = contact.getFixtureB().getBody();

    if ((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsGround(b)) || (BodyUtils.bodyIsGround(a)
        && BodyUtils.bodyIsRunner(b))) {
      mRunner.landed();
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
    mScreenRightSide =
        new Rectangle(getCamera().viewportWidth / 2, 0, getCamera().viewportWidth / 2,
            getCamera().viewportHeight);
    Gdx.input.setInputProcessor(this);
  }
  //endregion
}
