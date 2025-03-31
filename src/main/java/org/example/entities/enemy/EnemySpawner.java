package org.example.entities.enemy;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.AllTheWayUp;

import java.util.List;
import java.util.Random;

public class EnemySpawner extends EntitySpawner {
    private final AllTheWayUp game;
    private final double sceneWidth;
    private final double sceneHeight;
    private final Random random = new Random();
    private final int maxAmountOfEnemies = 4;
    private int amountOfEnemiesPlaced = 0;
    private final List<Collider> monsterList;

    public EnemySpawner(long intervalInMs, double sceneWidth, double sceneHeight, List<Collider> monsterList, AllTheWayUp game ) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.monsterList = monsterList;
        this.game = game;
    }

    @Override
    protected void spawnEntities() {
        double x = random.nextDouble() * (sceneWidth - 60 * 2) + 60;
        double y = -5000 + random.nextDouble() * (sceneHeight + 5000 - 80);

        Coordinate2D newLocation = new Coordinate2D(x, y);

        if (amountOfEnemiesPlaced < maxAmountOfEnemies) {
            Monster monster = new Monster(newLocation, game);
            spawn(monster);
            amountOfEnemiesPlaced++;
            monsterList.add(monster);
        }


    }
}
