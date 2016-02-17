package oscar.dicaprio.mechanics.map.partgenerators;

import java.util.ArrayList;
import java.util.List;
import oscar.dicaprio.mechanics.map.GenerationUtils;
import oscar.dicaprio.scene.actors.BaseActor;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/17/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 *
 * - 1.5 - Coin - 1.5 - Coin - 1.5 - Coin - 4 - Enemy
 *
 */
public class AnastasiaSequenceGenerator implements MapPartGenerator<BaseActor> {

  private final PrimitivesMapGenerator.CoinMapPartGenerator mCoinGenerator;
  private final PrimitivesMapGenerator.EnemyMapPartGenerator mEnemyGenerator;

  public AnastasiaSequenceGenerator(PrimitivesMapGenerator.CoinMapPartGenerator coinGenerator,
      PrimitivesMapGenerator.EnemyMapPartGenerator enemyGenerator) {
    mCoinGenerator = coinGenerator;
    mEnemyGenerator = enemyGenerator;
  }

  @Override public List<BaseActor> generate(float rightBound) {

    final List<BaseActor> actors = new ArrayList<>();

    actors.addAll(mCoinGenerator.generate(rightBound + 2f));
    actors.addAll(mCoinGenerator.generate(GenerationUtils.getRightBound(actors) + 1.5f));
    actors.addAll(mCoinGenerator.generate(GenerationUtils.getRightBound(actors) + 1.5f));
    actors.addAll(mCoinGenerator.generate(GenerationUtils.getRightBound(actors) + 1.5f));
    actors.addAll(mEnemyGenerator.generate(GenerationUtils.getRightBound(actors) + 4f));

    return actors;
  }
}
