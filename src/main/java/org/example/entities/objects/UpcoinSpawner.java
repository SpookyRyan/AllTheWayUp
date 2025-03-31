package org.example.entities.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.List;
import java.util.Random;


public class UpcoinSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final Random random;
    private final List<Upcoin> upcoinList;
    private double previousY;

    public UpcoinSpawner(long intervalInMs, double sceneWidth, List<Upcoin> upcoinList) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.random = new Random();
        this.upcoinList = upcoinList;
    }

    @Override
    protected void spawnEntities() {
        if (random.nextDouble() < 0.4) {
            double x = random.nextDouble() * (sceneWidth - 60);
            double y = -50;

            if (y != previousY) {
                Coordinate2D locatie = new Coordinate2D(x, y);
                Upcoin upcoin;

                upcoin = new Upcoin(locatie);

                upcoinList.add(upcoin);
                spawn(upcoin);
                previousY = y;
            }
        }
    }
}
