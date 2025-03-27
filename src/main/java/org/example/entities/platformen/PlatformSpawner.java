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
    private int amountOfPlatforms = 15;
    private boolean startOfGame = true;

    public PlatformSpawner(long intervalInMs, double sceneWidth, double sceneHeight) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.random = new Random();
    }

    @Override
    protected void spawnEntities() {


        if (startOfGame) {
            for (int x = 0; x <= sceneWidth; x += 60) {
                Coordinate2D locatie = new Coordinate2D(x, sceneHeight - 20);
                spawn(new NormalPlatform(locatie, new Size(60, 40)));
                spawn(new PlatformHitBox(locatie, "Normal"));
            }
            startOfGame = false;
        }

        while (platformGeplaatst < amountOfPlatforms) {
            double x = random.nextDouble() * (sceneWidth - 60 * 2) + 60;
            double y = random.nextDouble() * sceneHeight + 80;
            Coordinate2D nieuweLocatie = new Coordinate2D(x, y);


            if(!isOverlappend(nieuweLocatie)) {
                if (random.nextDouble() < 0.8) {
                    spawn(new NormalPlatform(new Coordinate2D(x, y), new Size(60, 40)));
                    spawn(new PlatformHitBox(new Coordinate2D(x, y), "Normal"));
                } else {
                    spawn(new BrokenPlatform(new Coordinate2D(x, y), new Size(60, 40), platformGeplaatst));
//                    spawn(new PlatformHitBox(new Coordinate2D(x, y), "Broken"));
                }
                platformLocaties.add(nieuweLocatie);
                platformGeplaatst++;
            }
        }
    }

    private boolean isOverlappend(Coordinate2D nieuweLocatie) {
        for (Coordinate2D locatie : platformLocaties) {
            if (locatie.distance(nieuweLocatie) < 120) {
                return true;
            }
        }
        return false;
    }
}
