package oscar.dicaprio.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import oscar.dicaprio.OscarGame;
import oscar.dicaprio.utils.C;

public class DesktopLauncher {
	public static void main (String[] arg) {
    final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.width = C.app.app_width;
    config.height = C.app.app_height;
    new LwjglApplication(new OscarGame(), config);
	}
}
