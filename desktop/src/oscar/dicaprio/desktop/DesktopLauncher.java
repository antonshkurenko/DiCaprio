package oscar.dicaprio.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import oscar.dicaprio.OscarGame;
import oscar.dicaprio.utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
    final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.width = Constants.APP_WIDTH;
    config.height = Constants.APP_HEIGHT;
    new LwjglApplication(new OscarGame(), config);
	}
}
