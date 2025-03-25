package org.example.entities.platformen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Random;


public class PlatformSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final double sceneHeight;
    private final Random random;

    public PlatformSpawner(long intervalInMs, double sceneWidth, double sceneHeight) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.random = new Random();
    }

    @Override
    protected void spawnEntities() {
        double x = random.nextDouble() * sceneWidth;
        double y = random.nextDouble() * sceneHeight;

        spawn(new BreekbaarPlatform(new Coordinate2D(x, y)));
    }
}
