package ksnoozy.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ksnoozy.game.Artillery;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Artillery.APP_TITLE;
		config.width = Artillery.APP_WIDTH;
		config.height = Artillery.APP_HIGHT;
		config.backgroundFPS = Artillery.APP_FPS;
		config.foregroundFPS = Artillery.APP_FPS;
		new LwjglApplication(new Artillery(), config);
	}
}
