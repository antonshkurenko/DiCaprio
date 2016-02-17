package oscar.dicaprio.mechanics.map;

import java.util.List;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/17/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public interface SequenceGenerator {

  /**
   * @return new sequence of the map parts
   */
  List<MapPart> createSequence();
}
