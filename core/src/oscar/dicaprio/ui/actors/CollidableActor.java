package oscar.dicaprio.ui.actors;

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

  public void collideTo(RunnerActor runner) {
    collide(runner);
  }
}
