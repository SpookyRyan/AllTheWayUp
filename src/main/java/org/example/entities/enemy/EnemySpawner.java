package org.example.entities.enemy;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.AllTheWayUp;
import org.example.entities.player.Uppie;

import java.util.List;
import java.util.Random;

public class EnemySpawner extends EntitySpawner {
    private final AllTheWayUp game;
    private final double sceneWidth;
    private final Random random = new Random();
    private final List<Collider> monsterList;

    public EnemySpawner(long intervalInMs, double sceneWidth, List<Collider> monsterList, AllTheWayUp game ) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.monsterList = monsterList;
        this.game = game;
    }

    @Override
    protected void spawnEntities() {
        double x = random.nextDouble() * (sceneWidth - 60 * 2) + 60;
        double y = -50 - random.nextDouble() * 100;

        Coordinate2D newLocation = new Coordinate2D(x, y);

        if (Uppie.getIsInLimit() && random.nextDouble() < 0.003) {
            Monster monster = new Monster(newLocation, game);
            spawn(monster);
            monsterList.add(monster);
        }


    }
}
