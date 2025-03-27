package org.example.entities.platformen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entities.speler.Uppie;
import org.example.entities.speler.Uppie2;
import org.example.entities.speler.UppieHitBox;

import java.util.List;


public class BrokenPlatform extends Platform implements Collided, Collider {

    public BrokenPlatform(Coordinate2D initialLocation, Size size, int platformsPlaced) {
        super("images/BrokenPlatform.png", initialLocation, size);
    }

    @Override
    public void onCollision(List<Collider> list) {
        for(Collider collider : list){
            if (collider instanceof UppieHitBox && !Uppie2.getIsInJump()){
                remove();
                setRemoved();
            }
        }
    }
}

