package oscar.dicaprio.mechanics.map.partgenerators;

import java.util.List;
import oscar.dicaprio.scene.actors.BaseActor;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/17/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public interface MapPartGenerator<T extends BaseActor> {

  /**
   * Generate list of smth to the map.
   * Enemy, coin, sequence w/e
   *
   * @param rightBound start X position for this Map Part
   * @return list of the generated actors
   */
  List<T> generate(float rightBound);
}
