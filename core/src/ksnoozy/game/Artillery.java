package ksnoozy.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import ksnoozy.game.managers.FileManager;
import ksnoozy.game.managers.GameScreenManagers;

public class Artillery extends Game {

    public static String APP_TITLE = "Steampunk Artillery";
    public static double APP_VERSION = 0.1;
    public static int APP_WIDTH = 720;
    public static int APP_HIGHT = 480;
    public static int APP_FPS = 60;

    // GameScreen Vars
    public static int V_WIDTH = 720;
    public static int V_HEIGHT = 280;

    //Managers
    public GameScreenManagers gsm;
    public AssetManager assets;
    public FileManager fileManager;

    //Batches
    public SpriteBatch batch;
    public ShapeRenderer shapebatch;
    public BitmapFont font;
    public BitmapFont font2;

    @Override
    public void create() {
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        batch = new SpriteBatch();
        shapebatch = new ShapeRenderer();
        font = new BitmapFont(Gdx.files.internal("fonts/Steampunk.fnt"));
        font2 = new BitmapFont(Gdx.files.internal("fonts/Multiplayer.fnt"));
        assets = new AssetManager();
        fileManager = new FileManager(this);
        gsm = new GameScreenManagers(this);
    }

    @Override
    public void render() {
        super.render();
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        shapebatch.dispose();
        assets.dispose();
        gsm.dispose();
    }
}
