package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.AllTheWayUp;
import org.example.entities.boosters.BoosterSpawner;
import org.example.entities.enemy.EnemySpawner;
import org.example.entities.objects.Upcoin;
import org.example.entities.objects.UpcoinSpawner;
import org.example.entities.platforms.PlatformSpawner;
import org.example.entities.player.Uppie;
import org.example.entities.text.ScoreText;
import org.example.entities.text.UpcoinScoreText;

import java.util.ArrayList;
import java.util.List;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
    private AllTheWayUp game;
    private List<Collider> platformenList = new ArrayList<>();
    private List<Collider> boosterList = new ArrayList<>();
    private List<Collider> monsterList = new ArrayList<>();
    private List<Upcoin> upcoinList = new ArrayList<>();
    private Uppie uppie;

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
        scoreText.setViewOrder(2);

        var upcoinScoreText = new UpcoinScoreText(new Coordinate2D(30, 50));
        addEntity(upcoinScoreText);
        upcoinScoreText.setViewOrder(2);

        uppie = new Uppie(new Coordinate2D(250, 700), game);
        uppie.setViewOrder(1);
        uppie.setPlatforms(platformenList);
        uppie.setBoosters(boosterList);
        uppie.setMonsters(monsterList);
        uppie.setUpcoins(upcoinList);

        uppie.setScoreText(scoreText);
        uppie.setUpcoinScoreText(upcoinScoreText);
        addEntity(uppie);

    }

    @Override
    public void setupEntitySpawners() {
        PlatformSpawner spawner = new PlatformSpawner(10, getWidth(), getHeight(), platformenList);
        addEntitySpawner(spawner);
        uppie.setBoosters(boosterList);

        BoosterSpawner boosterSpawner = new BoosterSpawner(10, getWidth(), uppie, boosterList);
        addEntitySpawner(boosterSpawner);

        EnemySpawner enemySpawner = new EnemySpawner(10, getWidth(), getHeight(), monsterList, game);
        addEntitySpawner(enemySpawner);
        uppie.setMonsters(monsterList);

        UpcoinSpawner upcoinSpawner = new UpcoinSpawner(1000, getWidth(), upcoinList);
        addEntitySpawner(upcoinSpawner);
    }
}
