package oscar.dicaprio.ui.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import oscar.dicaprio.mechanics.physics.WorldUtils;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/8/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class MainGameStage extends Stage {

  // This will be our viewport measurements while working with the debug renderer
  private static final int VIEWPORT_WIDTH = 20;
  private static final int VIEWPORT_HEIGHT = 13;

  private static final float TIME_STEP = 1 / 300f;

  private final World mWorld;
  private final Body mGround;
  private final Body mRunner;

  private final OrthographicCamera mCamera;
  private final Box2DDebugRenderer mRenderer;

  private float mAccumulator = 0f;

  public MainGameStage() {
    mWorld = WorldUtils.createWorld();
    mGround = WorldUtils.createGround(mWorld);
    mRunner = WorldUtils.createRunner(mWorld);
    mRenderer = new Box2DDebugRenderer();
    mCamera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
    setupCamera();
  }

  private void setupCamera() {
    mCamera.position.set(mCamera.viewportWidth / 2, mCamera.viewportHeight / 2, 0f);
    mCamera.update();
  }

  @Override
  public void act(float delta) {
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

  @Override
  public void draw() {
    super.draw();
    mRenderer.render(mWorld, mCamera.combined);
  }
}
