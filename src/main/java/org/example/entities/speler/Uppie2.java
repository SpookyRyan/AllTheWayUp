package org.example.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Uppie2 extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {


    public Uppie2(Coordinate2D initialLocation) {
        super(initialLocation);

        setMotion(1, 0D);
    }

    @Override
    protected void setupEntities() {
        addEntity(new UppieSprite(new Coordinate2D(200, 100), new Size(50, 50)));
        addEntity(new UppieHitBox(new Coordinate2D(200, 145)));
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }
}
