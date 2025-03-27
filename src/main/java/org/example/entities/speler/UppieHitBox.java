package org.example.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

import java.util.List;

public class UppieHitBox extends RectangleEntity implements Collided, Collider {
    private static boolean isCollided = false;

    protected UppieHitBox(Coordinate2D initialLocation) {
        super(initialLocation);
        setWidth(50);
        setHeight(1);
        setFill(Color.TRANSPARENT);
    }

    @Override
    public void onCollision(List<Collider> list) {
        if (!Uppie2.getIsInJump()) {
            isCollided = true;
        }

    }

    public static void setIsCollided(boolean value){
        isCollided = value;
    }

    public static boolean getIsCollided(){
        return isCollided;
    }
}
