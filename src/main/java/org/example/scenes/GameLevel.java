package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.AllTheWayUp;
import org.example.entities.boosters.BoosterSpawner;
import org.example.entities.platformen.PlatformSpawner;
//import org.example.entities.speler.Uppie;
import org.example.entities.speler.Uppie;
import org.example.entities.text.ScoreText;

import java.util.ArrayList;
import java.util.List;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
    private AllTheWayUp game;
    private List<Collider> platformenLijst = new ArrayList<>();
    private List<Collider> boosterLijst = new ArrayList<>();
    private Uppie uppie2;

    public GameLevel(AllTheWayUp game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
    setBackgroundAudio("audio/GameLevelTheme.mp3");
    setBackgroundAudioVolume(0.4);
    setBackgroundImage("images/GameBackground.png");
    }

    @Override
    public void setupEntities() {
        var scoreText = new ScoreText(new Coordinate2D(30, 20));
        addEntity(scoreText);

        uppie2 = new Uppie(new Coordinate2D(250, 700), game);
        uppie2.setViewOrder(1);
        uppie2.setPlatforms(platformenLijst);
        uppie2.setBoosters(boosterLijst);

        uppie2.setScoreText(scoreText);
        addEntity(uppie2);

    }

    @Override
    public void setupEntitySpawners() {
        PlatformSpawner spawner = new PlatformSpawner(10, getWidth(), getHeight(), platformenLijst);
        addEntitySpawner(spawner);
        uppie2.setBoosters(boosterLijst);

        BoosterSpawner boosterSpawner = new BoosterSpawner(500, getWidth(), uppie2, boosterLijst);
        addEntitySpawner(boosterSpawner);
    }
}
