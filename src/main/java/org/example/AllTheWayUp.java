package org.example;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.example.scenes.GameLevel;
import org.example.scenes.GameOver;
import org.example.scenes.MenuScene;

public class AllTheWayUp extends YaegerGame
{
    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("All The Way Up!");
        setSize(new Size(500,800));

    }

    @Override
    public void setupScenes() {
        addScene(0, new MenuScene(this));
        addScene(1, new GameLevel(this));
        addScene(2, new GameOver());
    }
}
