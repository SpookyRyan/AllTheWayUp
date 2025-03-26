package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.entities.text.GameOverText;

public class GameOver extends StaticScene {
    @Override
    public void setupScene() {
        setBackgroundImage("images/deathbackground.png");
        setBackgroundAudio("audio/GameLevelTheme.mp3");
        setBackgroundAudioVolume(0.2);
    }

    @Override
    public void setupEntities() {
        GameOverText gameOverText = new GameOverText(new Coordinate2D(100, 100));
        addEntity(gameOverText);
    }
}
