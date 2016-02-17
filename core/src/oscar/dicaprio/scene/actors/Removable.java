package oscar.dicaprio.scene.actors;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/16/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Since I can't delete items, while world is stepping
 * I have to mark them as removables, to remove them later
 */
public interface Removable {

  /**
   *  Mark as removable
   */
  void setRemovable();

  /**
   * Check if it's removable
   * @return removable
   */
  boolean isRemovable();
}
