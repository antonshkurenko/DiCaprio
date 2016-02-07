package oscar.dicaprio;

import com.badlogic.gdx.Game;
import oscar.dicaprio.ui.screens.MainGameScreen;

public class OscarGame extends Game {

  @Override
  public void create() {
    setScreen(new MainGameScreen());
  }
}
