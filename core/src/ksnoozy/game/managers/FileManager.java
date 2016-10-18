package ksnoozy.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import ksnoozy.game.Artillery;

public class FileManager {
    private Artillery app;

    public FileManager(final Artillery app) {
        this.app = app;

        getAssets("tank", Texture.class);
        getAssets("Fireworks", Texture.class);
    }

    private void getAssets(String folder, Class type) {
        FileHandle[] fileHandles = Gdx.files.internal(folder).list();
        for (FileHandle fh : fileHandles) {
            if (fh.isDirectory()) {
                getAssets(folder + "/" + fh.name(), type);
            } else {
                Gdx.app.log("A fm", fh.path());
                app.assets.load(fh.path(), type);
            }
        }
    }

}
