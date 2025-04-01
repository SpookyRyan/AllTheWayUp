package org.example.entities.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.entities.player.Uppie;

import java.util.List;
import java.util.Random;


public class CoinSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final Random random;
    private final List<Upcoin> upcoinList;
    private double previousY;

    public CoinSpawner(long intervalInMs, double sceneWidth, List<Upcoin> upcoinList) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.random = new Random();
        this.upcoinList = upcoinList;
    }

    @Override
    protected void spawnEntities() {
        if (Uppie.getIsInLimit()) {
        if (random.nextDouble() < 0.4) {
            double x = random.nextDouble() * (sceneWidth - 60);
            double y = -50;

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
