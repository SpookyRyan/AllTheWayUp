package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.AllTheWayUp;
import org.example.entities.button.LockerButton;
import org.example.entities.button.StartButton;


public class MenuScene extends StaticScene {
    private AllTheWayUp game;

    public MenuScene(AllTheWayUp game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/MainMenuTheme.mp3");
        setBackgroundAudioVolume(0.3);
        setBackgroundImage("images/cover.png");
    }

    @Override
    public void setupEntities() {
        addEntity(new StartButton(new Coordinate2D(180, 200), game));
        addEntity(new LockerButton(new Coordinate2D(105, 300), game));
    }

}
