package oscar.dicaprio.mechanics.physics.enemies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public final class EnemyGenerator {

  /**
   * todo(tonyshkurenko), 2/9/16: Hope I'll invent something better
   */

  private final List<EnemyFactory> mEnemyFactories = new ArrayList<>();

  private final Random mRandom = new Random();

  public EnemyGenerator() {
    initFactories();
  }

  public Enemy getRandomEnemy() {
    final EnemyFactory randomFactory = mEnemyFactories.get(mRandom.nextInt(mEnemyFactories.size()));
    return randomFactory.getEnemy();
  }

  //region Init methods
  private void initFactories() {
    mEnemyFactories.add(new SmallEnemyFactory());
    mEnemyFactories.add(new LongEnemyFactory());
    mEnemyFactories.add(new WideEnemyFactory());
    mEnemyFactories.add(new BigEnemyFactory());
    mEnemyFactories.add(new SmallFlyingEnemyFactory());
    mEnemyFactories.add(new WideFlyingEnemyFactory());
  }
  //endregion
}
