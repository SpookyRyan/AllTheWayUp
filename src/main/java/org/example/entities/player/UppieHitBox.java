package org.example.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;
import org.example.entities.boosters.BoosterEntity;
import org.example.entities.platforms.Platform;

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
        for (Collider collider : list) {
            if (collider instanceof BoosterEntity booster) {
                booster.boostUpwards();
                booster.remove();
            }
        }

        for (Collider collider : list) {
            if (collider instanceof Platform) {
                if (!Uppie.getIsInJump()) {
                    isCollided = true;
                }
            }
        }

    }

    public static void setIsCollided(boolean value){
        isCollided = value;
    }

    public static boolean getIsCollided(){
        return isCollided;
    }
}
