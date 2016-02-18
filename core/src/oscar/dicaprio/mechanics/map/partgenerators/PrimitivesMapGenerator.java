package oscar.dicaprio.mechanics.map.partgenerators;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import java.util.Collections;
import java.util.List;
import oscar.dicaprio.mechanics.enemies.Enemy;
import oscar.dicaprio.mechanics.enemies.EnemyGenerator;
import oscar.dicaprio.mechanics.utils.WorldUtils;
import oscar.dicaprio.scene.actors.CoinActor;
import oscar.dicaprio.scene.actors.EnemyActor;
import oscar.dicaprio.scene.actors.RunnerActor;
import oscar.dicaprio.utils.C;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/17/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public final class PrimitivesMapGenerator {

  private PrimitivesMapGenerator() {
    // never instantiate
  }

  public static final class EnemyMapPartGenerator implements MapPartGenerator<EnemyActor> {

    private final EnemyGenerator mEnemyGenerator = new EnemyGenerator();
    private final World mWorld;
    private final RunnerActor mRunnerActor;

    public EnemyMapPartGenerator(World world, RunnerActor runner) {
      mWorld = world;
      mRunnerActor = runner;
    }

    @Override public List<EnemyActor> generate(float rightBound) {
      final EnemyActor enemy = createEnemy(mWorld, new Vector2(C.world.enemy_linear_velocity).sub(
          mRunnerActor.getUserData().getLinearVelocity()), rightBound, mEnemyGenerator);

      mRunnerActor.getUserData().attachVelocityChangeObserver(enemy.getUserData());
      return Collections.singletonList(enemy);
    }

    private EnemyActor createEnemy(World world, Vector2 startVelocity, float xPosition,
        EnemyGenerator enemyGenerator) {

      final Enemy enemyType = enemyGenerator.getRandomEnemy();
      return new EnemyActor(WorldUtils.createEnemy(world, enemyType, xPosition), enemyType,
          new Vector2(startVelocity));
    }
  }

  public static final class CoinMapPartGenerator implements MapPartGenerator<CoinActor> {

    private final World mWorld;
    private final RunnerActor mRunnerActor;

    public CoinMapPartGenerator(World world, RunnerActor runner) {
      mWorld = world;
      mRunnerActor = runner;
    }

    @Override public List<CoinActor> generate(float rightBound) {
      final CoinActor coin = createCoin(mWorld, new Vector2(C.world.coin_linear_velocity).sub(
          mRunnerActor.getUserData().getLinearVelocity()), rightBound);

      mRunnerActor.getUserData().attachVelocityChangeObserver(coin.getUserData());
      return Collections.singletonList(coin);
    }

    private CoinActor createCoin(World world, Vector2 startVelocity, float xPosition) {
      return new CoinActor(WorldUtils.createCoin(world, xPosition), new Vector2(startVelocity));
    }
  }
}
