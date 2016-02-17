package oscar.dicaprio.scene.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/11/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Collider class, double dispatch, Visitor:
 * http://www.quizful.net/post/multiple-typecasting-problems
 *
 * Every new subclass of the {@link CollidableActor}
 * has to be added with new method collideTo(? extends {@link CollidableActor} smth) in this class and
 * has to override {@link CollidableActor#collide} method as c.collideTo(this) and
 * has to override all methods collideTo(? extends {@link CollidableActor})
 */
public abstract class CollidableActor extends Actor {

  public void collide(CollidableActor c) {
    // Must be overloaded correctly
  }

  public void collideTo(BaseActor base) {
    collide(base);
  }

  public void collideTo(GroundActor ground) {
    collide(ground);
  }

  public void collideTo(EnemyActor enemy) {
    collide(enemy);
  }

  public void collideTo(CoinActor coin) {
    collide(coin);
  }

  public void collideTo(IcebergActor iceberg) {
    collide(iceberg);
  }

  public void collideTo(SnowballActor snowball) {
    collide(snowball);
  }

  public void collideTo(RunnerActor runner) {
    collide(runner);
  }
}
