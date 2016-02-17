package oscar.dicaprio.mechanics.map;

import com.badlogic.gdx.Gdx;
import java.util.List;
import oscar.dicaprio.scene.actors.BaseActor;
import oscar.dicaprio.utils.C;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/17/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public final class GenerationUtils {

  private static final String TAG = GenerationUtils.class.getSimpleName();

  private static float sLastRightBound = C.world.start_generation_bound;

  public static float getRightBound(List<BaseActor> actors) {

    float rightBound = actors.get(actors.size() - 1).getBody().getPosition().x;

    /**
     * If we locate bodies to the same point
     * It causes a crash in the box2d
     */
    if(sLastRightBound == rightBound) {
      Gdx.app.log(TAG, "::getRightBound, same bounds occurred! Right bound = " + rightBound);
      rightBound += 0.0005f;
    }
    Gdx.app.log(TAG, "::getRightBound = " + rightBound);
    sLastRightBound = rightBound;
    return rightBound;
  }

  private GenerationUtils() {
    // never instantiate
  }
}
