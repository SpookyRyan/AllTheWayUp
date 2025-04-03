package org.example.entities.boosters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.entities.player.Uppie;


import java.util.List;
import java.util.Random;

public class BoosterSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final Random random;
    private final Uppie uppie;
    private final List<Collider> boosterList;

    public BoosterSpawner(long intervalInMs, double sceneWidth, Uppie uppie, List<Collider> boosterList) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.random = new Random();
        this.uppie = uppie;
        this.boosterList = boosterList;
    }

    @Override
    protected void spawnEntities() {
        if (random.nextDouble() < 0.005) {
            double x = random.nextDouble() * (sceneWidth - 60);
            double y = -50;

            Coordinate2D locatie = new Coordinate2D(x, y);
            BoosterEntity booster;

            if (Uppie.getIsInLimit()) {
                if (random.nextBoolean()) {
                    booster = new Spring(locatie, uppie);
                } else {
                    booster = new Trampoline(locatie, uppie);
                }

                boosterList.add(booster);
                spawn(booster);
                Uppie.setIsInLimit(false);
            }
        }
    }
}
