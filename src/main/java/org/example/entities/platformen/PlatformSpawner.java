package org.example.entities.platformen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Random;


public class PlatformSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final double sceneHeight;
    private final Random random;
    private int platformGeplaatst = 0;

    public PlatformSpawner(long intervalInMs, double sceneWidth, double sceneHeight) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.random = new Random();
    }

    @Override
    protected void spawnEntities() {

        while (platformGeplaatst < 10) {
            double x = random.nextDouble() * sceneWidth;
            double y = random.nextDouble() * sceneHeight;

            if (random.nextDouble() < 0.7) {
                spawn(new NormaalPlatform(new Coordinate2D(x, y), new Size(60, 40)));
            } else {
                spawn(new BreekbaarPlatform(new Coordinate2D(x, y)));
            }
            platformGeplaatst++;
        }
    }
}
