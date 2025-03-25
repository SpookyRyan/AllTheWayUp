package org.example;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.example.scenes.SpelLevel;
import org.example.scenes.SpelOver;
import org.example.scenes.VoorPagina;

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
        addScene(0, new VoorPagina(this));
        addScene(1, new SpelLevel());
        addScene(2, new SpelOver());
    }
}
