package org.example.entities.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;


public class UpcoinSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final double sceneHeight;
    int maxcoins = 5;

    protected UpcoinSpawner(double sceneWidth, double sceneHeight) {
        super(100);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        int coins = 0;
        while(coins < maxcoins) {
            Upcoin upcoin = new Upcoin(randomLocation());
            spawn(upcoin);
            coins++;
        }
    }

    private Coordinate2D randomLocation() {
        double x = Math.random() * sceneWidth;
        double y = Math.random() * (sceneHeight / 3);
        return new Coordinate2D(x, y);
    }
}
