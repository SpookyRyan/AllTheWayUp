package org.example.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

import java.util.List;

public class UppieHitBox extends RectangleEntity implements Collided {
    protected UppieHitBox(Coordinate2D initialLocation) {
        super(initialLocation);
        setWidth(1);
        setHeight(1);
        setFill(Color.TRANSPARENT);
    }

    @Override
    public void onCollision(List<Collider> list) {

    }
}
