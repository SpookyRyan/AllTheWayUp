package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.AllTheWayUp;
import org.example.entities.StartKnop;


public class VoorPagina extends StaticScene {
    private AllTheWayUp game;

    public VoorPagina(AllTheWayUp game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/MainMenuMuziek.mp3");
        setBackgroundAudioVolume(0.3);
        setBackgroundImage("afbeeldingen/cover.png");
    }

    @Override
    public void setupEntities() {
        addEntity(new StartKnop(new Coordinate2D(200, 400), game));
    }

}
