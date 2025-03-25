package org.example.entities.platformen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;



public class PlatformSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final double sceneHeight;

    public PlatformSpawner(long intervalInMs, double sceneWidth, double sceneHeight) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
            spawn(new BreekbaarPlatform(new Coordinate2D(200, 200)));
    }
}
