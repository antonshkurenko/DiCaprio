package oscar.dicaprio.scene.actors.timeactions;

import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import oscar.dicaprio.mechanics.utils.WorldUtils;
import oscar.dicaprio.scene.actors.SnowballActor;
import oscar.dicaprio.scene.stages.MainGameStage;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/18/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class SnowballCreatingAction extends TimeAction {

  public static final int DELAY = 3;

  /**
   * Shooting with snowballs every DELAY seconds
   * @param stage stage to apply
   */
  public SnowballCreatingAction(final MainGameStage stage) {
    super(RepeatAction.FOREVER, DELAY, () -> {
      final SnowballActor snowball =
          SnowballActor.createRandom(WorldUtils.createSnowball(stage.getWorld()));
      stage.addActor(snowball);
    });
  }
}
