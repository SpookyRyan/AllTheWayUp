package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.AllTheWayUp;
import org.example.entities.platformen.PlatformSpawner;
import org.example.entities.speler.Uppie;
import org.example.entities.speler.Uppie2;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
    private AllTheWayUp game;

    public GameLevel(AllTheWayUp game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
    setBackgroundAudio("audio/GameLevelTheme.mp3");
    setBackgroundAudioVolume(0.3);
    }

    @Override
    public void setupEntities() {
        Uppie uppie = new Uppie(new Coordinate2D(250, 700), new Size(50, 50), game);
//        Uppie2 uppie2 = new Uppie2(new Coordinate2D(100, 100));
        addEntity(uppie);
//        addEntity(uppie2);
//        uppie.AutomatischSpringen();
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new PlatformSpawner(10, getWidth(), getHeight()));


    }
}
