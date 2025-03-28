package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.AllTheWayUp;
import org.example.entities.platformen.PlatformSpawner;
//import org.example.entities.speler.Uppie;
import org.example.entities.speler.Uppie;

import java.util.ArrayList;
import java.util.List;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
    private AllTheWayUp game;
    private List<Collider> platformenLijst = new ArrayList<>();

    public GameLevel(AllTheWayUp game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
    setBackgroundAudio("audio/GameLevelTheme.mp3");
    setBackgroundAudioVolume(0.3);
    setBackgroundImage("images/GameBackground.png");
    }

    @Override
    public void setupEntities() {
//        Uppie uppie = new Uppie(new Coordinate2D(250, 700), new Size(50, 50), game);
//        uppie.setPlatforms(platformenLijst);
//        addEntity(uppie);

        Uppie uppie2 = new Uppie(new Coordinate2D(250, 700), game);
        uppie2.setViewOrder(1);
        uppie2.setPlatforms(platformenLijst);
        addEntity(uppie2);

    }

    @Override
    public void setupEntitySpawners() {
     //   addEntitySpawner(new PlatformSpawner(10, getWidth(), getHeight()));
        PlatformSpawner spawner = new PlatformSpawner(10, getWidth(), getHeight(), platformenLijst);
        addEntitySpawner(spawner);

    }
}
