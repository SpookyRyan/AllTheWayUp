package org.example.entities.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.entities.player.Uppie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PlatformSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final double sceneHeight;
    private final Random random;
    private int platformsPlaced = 0;
    private final List<Coordinate2D> platformLocaties = new ArrayList<>();
    private int amountOfPlatforms = 15;
    private boolean startOfGame = true;
    private final List<Collider> platformenList;

    public PlatformSpawner(long intervalInMs, double sceneWidth, double sceneHeight, List<Collider> platformenList) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.random = new Random();
        this.platformenList = platformenList;
    }

    @Override
    protected void spawnEntities() {
        if (startOfGame) {
            for (int x = 0; x <= sceneWidth; x += 60) {
                Coordinate2D locatie = new Coordinate2D(x, sceneHeight - 20);

                NormalPlatform platform = new NormalPlatform(locatie, new Size(60, 40));
                spawn(platform);
                platformenList.add(platform);

                PlatformHitBox hitbox = new PlatformHitBox(locatie, "Normal");
                platform.setHitbox(hitbox);
                spawn(hitbox);


            }
            startOfGame = false;
        }

        while (platformsPlaced < amountOfPlatforms) {
            double x = random.nextDouble() * (sceneWidth - 60 * 2) + 60;
            double y = random.nextDouble() * (sceneHeight - 80);

            Coordinate2D nieuweLocatie = new Coordinate2D(x, y);

            if (!isOverLapping(nieuweLocatie)) {
                if (random.nextDouble() < 0.8) {
                    NormalPlatform platform = new NormalPlatform(nieuweLocatie, new Size(60, 40));
                    spawn(platform);
                    platformenList.add(platform);

                    PlatformHitBox hitbox = new PlatformHitBox(nieuweLocatie, "Normal");
                    platform.setHitbox(hitbox);
                    spawn(hitbox);
                } else {
                    BrokenPlatform platform = new BrokenPlatform(nieuweLocatie, new Size(60, 40));
                    spawn(platform);
                    platformenList.add(platform);
                }
                platformLocaties.add(nieuweLocatie);
                platformsPlaced++;
            }
        }

        if(Uppie.getIsInLimit()){
            double x = random.nextDouble() * (sceneWidth - 60 * 2) + 60;
            double y = -50 - random.nextDouble() * 100;


            Coordinate2D nieuweLocatie = new Coordinate2D(x, y);
            if (!isOverLapping(nieuweLocatie)) {
                if (random.nextDouble() < 0.8) {
                    NormalPlatform platform = new NormalPlatform(nieuweLocatie, new Size(60, 40));
                    spawn(platform);
                    platformenList.add(platform);

                    PlatformHitBox hitbox = new PlatformHitBox(nieuweLocatie, "Normal");
                    platform.setHitbox(hitbox);
                    spawn(hitbox);
                } else {
                    BrokenPlatform platform = new BrokenPlatform(nieuweLocatie, new Size(60, 40));
                    spawn(platform);
                    platformenList.add(platform);
                }
                platformLocaties.add(nieuweLocatie);
                platformsPlaced++;
            }

        }

        for(int i = 0; i < platformLocaties.size(); i++) {
            Coordinate2D locatie = platformLocaties.get(i);
            if (locatie.getY() > sceneHeight) {
                platformLocaties.remove(i);
                platformsPlaced--;
                break;
            }
        }
    }

    private boolean isOverLapping(Coordinate2D nieuweLocatie) {
        for (Coordinate2D locatie : platformLocaties) {
            if (locatie.distance(nieuweLocatie) < 120) {
                return true;
            }
        }
        return false;
    }

    public void updatePlatformLocation(double verschil) {
        for (int i = 0; i < platformLocaties.size(); i++) {
            Coordinate2D oldLocatie = platformLocaties.get(i);
            Coordinate2D newLocation = new Coordinate2D(oldLocatie.getX(), oldLocatie.getY() + verschil);
            platformLocaties.set(i, newLocation);
        }
    }
}
