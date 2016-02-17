package oscar.dicaprio.mechanics.map;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import oscar.dicaprio.mechanics.map.partgenerators.FirstSequenceGenerator;
import oscar.dicaprio.mechanics.map.partgenerators.MapPartGenerator;
import oscar.dicaprio.mechanics.map.partgenerators.PrimitivesMapGenerator;
import oscar.dicaprio.scene.actors.BaseActor;
import oscar.dicaprio.scene.actors.RunnerActor;
import oscar.dicaprio.scene.stages.MainGameStage;
import oscar.dicaprio.utils.C;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Generates random sequence for map, based on generators in the list
 */
public final class MapGenerator {

  private final List<MapPartGenerator<BaseActor>> mMapPartGenerators = new ArrayList<>();

  private final Random mRandom = new Random();
  private final List<BaseActor> mActors = new ArrayList<>();
  private final MainGameStage mStage;

  private static MapGenerator sInstance;

  public static MapGenerator getInstance() {

    if (sInstance == null) {
      throw new IllegalStateException(
          "Map generator wasn't initialized, call #init(World, RunnerActor) before.");
    }

    return sInstance;
  }

  public static void init(MainGameStage stage) {

    if (sInstance != null) {
      throw new IllegalStateException("Trying to initialize Map Generator for the second time.");
    }

    sInstance = new MapGenerator(stage);
  }

  private MapGenerator(MainGameStage stage) {

    mStage = stage;

    final World world = mStage.getWorld();
    final RunnerActor runner = mStage.getRunner();

    final PrimitivesMapGenerator.CoinMapPartGenerator coinGenerator =
        new PrimitivesMapGenerator.CoinMapPartGenerator(world, runner);

    final PrimitivesMapGenerator.EnemyMapPartGenerator enemyGenerator =
        new PrimitivesMapGenerator.EnemyMapPartGenerator(world, runner);

    mMapPartGenerators.add(new FirstSequenceGenerator(coinGenerator, enemyGenerator));
  }

  public void generateRandomActors() {
    final MapPartGenerator<BaseActor> randomGenerator =
        mMapPartGenerators.get(mRandom.nextInt(mMapPartGenerators.size()));
    final List<BaseActor> actors = randomGenerator.generate(getRightBound());
    mActors.addAll(actors);

    for(BaseActor actor : actors) {
      mStage.addActor(actor);
    }
  }

  public void removeActor(BaseActor actor) {
    mActors.remove(actor);
  }

  public float getRightBound() {
    if (mActors.size() > 0) {
      return GenerationUtils.getRightBound(mActors);
    } else {
      return C.world.start_generation_bound;
    }
  }
}
