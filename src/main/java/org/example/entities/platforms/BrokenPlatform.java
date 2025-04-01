package org.example.entities.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entities.player.Uppie;
import org.example.entities.player.UppieHitBox;

import java.util.List;


public class BrokenPlatform extends Platform implements Collided, Collider {

    public BrokenPlatform(Coordinate2D initialLocation, Size size) {
        super("images/BrokenPlatform.png", initialLocation, size);
    }

    @Override
    public void onCollision(List<Collider> list) {
        for(Collider collider : list){
            if (collider instanceof UppieHitBox && !Uppie.getIsInJump()){
                remove();
                setRemoved();
            }
        }
    }
}

