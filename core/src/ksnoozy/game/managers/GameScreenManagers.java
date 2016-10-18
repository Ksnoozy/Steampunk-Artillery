package ksnoozy.game.managers;

import ksnoozy.game.Artillery;
import ksnoozy.game.Screens.AbstractScreen;
import ksnoozy.game.Screens.GameScreen;
import ksnoozy.game.Screens.MainMenuScreen;

import java.util.HashMap;

public class GameScreenManagers {

    private final Artillery app;

    private HashMap<STATE, AbstractScreen> gameScreens;

    public enum STATE{
        MAIN_MENU,
        PLAY,
        SETTINGS,
    }

    public GameScreenManagers(final Artillery app){
        this.app = app;

        initGameScreens();
        setScreen(STATE.MAIN_MENU);
    }

    private void initGameScreens() {
        this.gameScreens = new HashMap<STATE, AbstractScreen>();
        this.gameScreens.put(STATE.PLAY, new GameScreen(app));
        this.gameScreens.put(STATE.MAIN_MENU, new MainMenuScreen(app));
    }

    public void setScreen(STATE nextScreen){
        app.setScreen(gameScreens.get(nextScreen));
    }

    public void dispose(){
        for(AbstractScreen Screen : gameScreens.values()){
            if(Screen != null){
                Screen.dispose();
            }
        }
    }

}
