package oscar.dicaprio.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import oscar.dicaprio.ui.stages.MainGameStage;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/7/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

public class MainGameScreen implements Screen {

  private final MainGameStage mMainGameStage;

  public MainGameScreen() {
    mMainGameStage = new MainGameStage();
  }

  //region implements Screen
  @Override public void show() {

  }

  @Override public void render(float delta) {
    // Clear the screen
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    // Update stage view
    mMainGameStage.draw();
    // Update stage physical state
    mMainGameStage.act(delta);
  }

  @Override public void resize(int width, int height) {

  }

  @Override public void pause() {

  }

  @Override public void resume() {

  }

  @Override public void hide() {

  }

  @Override public void dispose() {

  }
  //endregion
}
