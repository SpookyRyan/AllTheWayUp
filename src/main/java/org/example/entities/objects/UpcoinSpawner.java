package org.example.entities.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.entities.boosters.BoosterEntity;
import org.example.entities.boosters.Spring;
import org.example.entities.boosters.Trampoline;
import org.example.entities.speler.Uppie;

import java.util.List;
import java.util.Random;


public class UpcoinSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final Random random;
    private final List<Upcoin> upcoinLijst;

    public UpcoinSpawner(long intervalInMs, double sceneWidth, List<Upcoin> upcoinLijst) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.random = new Random();
        this.upcoinLijst = upcoinLijst;
    }

    @Override
    protected void spawnEntities() {
        if (random.nextDouble() < 0.4) {
            double x = random.nextDouble() * (sceneWidth - 60);
            double y = -50;

            Coordinate2D locatie = new Coordinate2D(x, y);
            Upcoin upcoin;

            upcoin = new Upcoin(locatie);

            upcoinLijst.add(upcoin);
            spawn(upcoin);
        }
    }
}
