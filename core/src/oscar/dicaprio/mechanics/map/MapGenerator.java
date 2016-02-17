package oscar.dicaprio.mechanics.map;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import oscar.dicaprio.mechanics.enemies.Enemy;
import oscar.dicaprio.mechanics.enemies.EnemyGenerator;
import oscar.dicaprio.mechanics.utils.WorldUtils;
import oscar.dicaprio.scene.actors.CoinActor;
import oscar.dicaprio.scene.actors.EnemyActor;
import oscar.dicaprio.scene.actors.RunnerActor;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/17/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class MapGenerator {

  private final EnemyGenerator mEnemyGenerator = new EnemyGenerator();

  private final World mWorld;

  public MapGenerator(World world) {
    mWorld = world;
  }

  protected EnemyActor createEnemy(World world, Vector2 startVelocity,
      EnemyGenerator enemyGenerator) {

    final Enemy enemyType = enemyGenerator.getRandomEnemy();
    /*final EnemyActor enemy = new EnemyActor(WorldUtils.createEnemy(world, enemyType), enemyType,
        new Vector2(C.world.enemy_linear_velocity).sub(runner.getUserData()
            .getLinearVelocity()));*/

    //runner.getUserData().attachVelocityChangeObserver(enemy.getUserData());
    return new EnemyActor(WorldUtils.createEnemy(world, enemyType), enemyType,
        new Vector2(startVelocity));
  }

  protected CoinActor createCoin(World world, Vector2 startVelocity) {

    //mRunner.getUserData().attachVelocityChangeObserver(coin.getUserData());
    return new CoinActor(WorldUtils.createCoin(world), new Vector2(startVelocity));
  }
}
