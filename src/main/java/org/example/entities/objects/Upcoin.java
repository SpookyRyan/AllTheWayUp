package org.example.entities.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import org.example.entities.speler.Uppie;

import java.util.List;

public class Upcoin extends DynamicCircleEntity implements Collider, Collided {

    protected Upcoin(Coordinate2D initialLocation) {
        super(initialLocation);
        setOpacity(0.5);
        setStrokeWidth(0.2);
    }

    @Override
    public void onCollision(List<Collider> list) {
        var shouldRemove = false;
        for (Collider collider : list) {
            if (collider instanceof Uppie) {
                shouldRemove = true;
                break;
            }
        }
        if (shouldRemove) {
            var coinSound = new SoundClip("audio/coin.mp3");
            coinSound.play();

            remove();
        }
    }

    public void moveDown(double hoeveelheid) {
        setAnchorLocationY(getAnchorLocation().getY() + hoeveelheid);
    }


}
