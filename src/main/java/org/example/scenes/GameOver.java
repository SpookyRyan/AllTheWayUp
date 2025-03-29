package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.AllTheWayUp;
import org.example.entities.knoppen.HomeKnop;
import org.example.entities.knoppen.LockerKnop;
import org.example.entities.knoppen.PlayAgainKnop;
import org.example.entities.knoppen.StartKnop;
import org.example.entities.speler.Uppie;
import org.example.entities.text.GameOverText;

public class GameOver extends StaticScene {
    private AllTheWayUp game;

    public GameOver(AllTheWayUp game){
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("images/deathbackground.png");
        setBackgroundAudio("audio/GameLevelTheme.mp3");
        setBackgroundAudioVolume(0.2);
    }

    @Override
    public void setupEntities() {
        GameOverText gameOverText = new GameOverText(new Coordinate2D(110, 100));
        addEntity(gameOverText);
        addEntity(new PlayAgainKnop(new Coordinate2D(130, 400), game));

        addEntity(new HomeKnop(new Coordinate2D(133, 550), game));
    }
}
