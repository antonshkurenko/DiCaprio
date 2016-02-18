package oscar.dicaprio.mechanics.map;

import java.util.List;
import oscar.dicaprio.scene.actors.BaseActor;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/17/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public final class GenerationUtils {

  private static final String TAG = GenerationUtils.class.getSimpleName();

  public static float getRightBound(List<BaseActor> actors) {
    return actors.get(actors.size() - 1).getBody().getPosition().x;
  }

  private GenerationUtils() {
    // never instantiate
  }
}
