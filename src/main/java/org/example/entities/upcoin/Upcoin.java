package org.example.entities.upcoin;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import org.example.entities.Moveable;
import org.example.entities.player.Uppie;
import org.example.entities.player.UppieHitBox;

import java.util.List;

public class Upcoin extends DynamicSpriteEntity implements Collider, Collided, Coin, Moveable {
    private boolean collected = false;

    protected Upcoin(Coordinate2D initialLocation) {
        super("images/bitcoin.png", initialLocation, new Size(40, 40));
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        if (collected) return;

        for (Collider collider : colliders) {
            if (collider instanceof UppieHitBox) {
                collect();
                break;
            }
        }
    }

    @Override
    public void collect() {
        collected = true;
        var coinSound = new SoundClip("audio/coin.mp3");
        coinSound.play();
        Uppie.increaseUpcoinScore();
        remove();
    }

    @Override
    public boolean isCollected() {
        return collected;
    }

    @Override
    public void moveDown(double amount) {
        setAnchorLocationY(getAnchorLocation().getY() + amount);
    }

}
