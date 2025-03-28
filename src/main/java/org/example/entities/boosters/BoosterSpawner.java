package org.example.entities.boosters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.entities.speler.Uppie;

import java.util.List;
import java.util.Random;

public class BoosterSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final Random random;
    private final Uppie uppie;
    private final List<Collider> boosterLijst;

    public BoosterSpawner(long intervalInMs, double sceneWidth, Uppie uppie, List<Collider> boosterLijst) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.random = new Random();
        this.uppie = uppie;
        this.boosterLijst = boosterLijst;
    }

    @Override
    protected void spawnEntities() {
        if (random.nextDouble() < 0.1) {
            double x = random.nextDouble() * (sceneWidth - 60);
            double y = -50;

            Coordinate2D locatie = new Coordinate2D(x, y);
            BoosterEntity booster;

            if (random.nextBoolean()) {
                booster = new Spring(locatie, uppie);
            } else {
                booster = new Trampoline(locatie, uppie);
            }

            boosterLijst.add(booster);
            spawn(booster);
        }
    }
}
