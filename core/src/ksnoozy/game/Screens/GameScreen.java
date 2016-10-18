package ksnoozy.game.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import ksnoozy.game.Artillery;
import ksnoozy.game.Objects.LandCube;

public class GameScreen extends AbstractScreen {

    Array<LandCube> land;
    private Artillery app;

    public GameScreen(final Artillery app) {
        super(app);
        this.app = app;
        land = new Array<>();
    }

    @Override
    public void show() {
        for (float x = 0; x < Gdx.graphics.getWidth(); x++){
            for (float y = 0; y < 50 + MathUtils.sin(x / 100 ) * 10; y++){
                land.add(new LandCube(app, x, y, 1, 1));
            }
        }
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        app.batch.begin();
        for (LandCube cube : land) {
            cube.render();
        }
        app.batch.end();

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
