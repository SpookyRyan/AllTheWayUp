package org.example.entities.platformen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PlatformSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final double sceneHeight;
    private final Random random;
    private int platformGeplaatst = 0;
    private final List<Coordinate2D> platformLocaties = new ArrayList<>();

    public PlatformSpawner(long intervalInMs, double sceneWidth, double sceneHeight) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.random = new Random();
    }

    @Override
    protected void spawnEntities() {

        while (platformGeplaatst < 10) {
            double x = random.nextDouble() * (sceneWidth - 60 * 2) + 60;
            double y = random.nextDouble() * sceneHeight + 10;
            Coordinate2D nieuweLocatie = new Coordinate2D(x, y);

            if(!isOverlappend(nieuweLocatie)) {
                if (random.nextDouble() < 0.7) {
                    spawn(new NormalPlatform(new Coordinate2D(x, y), new Size(60, 40)));
                    spawn(new PlatformHitBox(new Coordinate2D(x, y)));
                } else {
                    spawn(new BrokenPlatform(new Coordinate2D(x, y), new Size(60, 40)));
                    spawn(new PlatformHitBox(new Coordinate2D(x, y)));
                }
                platformLocaties.add(nieuweLocatie);
                platformGeplaatst++;
            }
        }
    }

    private boolean isOverlappend(Coordinate2D nieuweLocatie) {
        for (Coordinate2D locatie : platformLocaties) {
            if (locatie.distance(nieuweLocatie) < 60) {
                return true;
            }
        }
        return false;
    }
}
