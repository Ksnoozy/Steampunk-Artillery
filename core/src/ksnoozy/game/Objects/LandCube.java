package ksnoozy.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import ksnoozy.game.Artillery;

public class LandCube {

    private Artillery app;
    Texture pixel;
    float x,y,width,height;

    public LandCube(Artillery app, float x, float y, float width, float height){
        this.app = app;
        pixel = app.assets.get("Cube/Pixel.png",Texture.class);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public void render(){
        app.batch.draw(pixel, x, y, width, height);
    }

    public void update(){

    }

    public void dispose(){
        pixel.dispose();
    }
}
