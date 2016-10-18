package ksnoozy.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import ksnoozy.game.Artillery;
import ksnoozy.game.managers.GameScreenManagers;

public class MainMenuScreen extends AbstractScreen {

    int Stage = 1;
    int slow = 0;
    int x = 0;
    int Stage2 = 1;
    Texture img;

    public MainMenuScreen(final Artillery app) {
        super(app);
    }

    @Override
    public void show() {
        img = new Texture("grass tile.png");
    }
    @Override
    public void update(float delta) {
        app.assets.update();
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER))
            app.gsm.setScreen(GameScreenManagers.STATE.PLAY);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (app.assets.getQueuedAssets() <= 0) {
            app.batch.begin();
            app.batch.draw(img, -100, 0, Gdx.graphics.getWidth() + 100, Gdx.graphics.getHeight() - 705);
            app.batch.draw(app.assets.get("Fireworks/Fireworks" + Stage2 + ".png", Texture.class), 10, 400);
            app.batch.draw(app.assets.get("Fireworks/Fireworks" + Stage2 + ".png", Texture.class), 1050, 400);
            app. batch.draw(app.assets.get("tank/Tank" + Stage + ".png", Texture.class), x, 50);
            app.font.draw(app.batch, "Steampunk Artillery", 325, 650);
            app.font2.draw(app.batch, "Multiplayer", 325, 500);
            app.font2.draw(app.batch, "Singleplayer", 650, 500);
            app.font2.draw(app.batch, "Options", 950, 500);
            app.batch.end();

            if (slow %9 == 0) {
                Stage2 = ((Stage2 + 1) % 14) + 1;

            }
            if (slow %5 == 0) {
                Stage = ((Stage + 1) % 24) + 1;
            }
            x = x< Gdx.graphics.getWidth() ? x+2 : -220;
            slow++;
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
