package org.example.entities.platformen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

import java.util.List;

public class PlatformHitBox extends RectangleEntity implements Collider {
    protected PlatformHitBox(Coordinate2D initialLocation) {
        super(initialLocation);
        setWidth(60);
        setHeight(1);
        setFill(Color.TRANSPARENT);
    }

}
