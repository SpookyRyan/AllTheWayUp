package org.example.entities.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
//import com.github.hanyaeger.core.entities.motion.MotionApplier;
import javafx.scene.paint.Color;
import org.example.entities.player.UppieHitBox;
//import org.example.entities.speler.Uppie;

import java.util.List;

public class PlatformHitBox extends RectangleEntity implements Collider, Collided {
    private String platformType;

    protected PlatformHitBox(Coordinate2D initialLocation, String platformType) {
        super(initialLocation);
        setWidth(60);
        setHeight(1);
        setFill(Color.TRANSPARENT);

        this.platformType = platformType;
    }

    @Override
    public void onCollision(List<Collider> list) {
        for(Collider collider : list){
            if (collider instanceof UppieHitBox && platformType.equals("broken")){
                remove();
            }
        }
    }



}
