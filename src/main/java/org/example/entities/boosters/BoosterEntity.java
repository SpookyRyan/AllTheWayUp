package org.example.entities.boosters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.entities.Collider;
//import com.github.hanyaeger.core.entities.motion.Movable;
import org.example.entities.Moveable;
import org.example.entities.player.Uppie;

public abstract class BoosterEntity extends SpriteEntity implements Collider, Moveable {

    protected final Uppie uppie;

    public BoosterEntity(Coordinate2D location, Size size, String sprite, Uppie uppie) {
        super(sprite, location, size);
        this.uppie = uppie;
    }

    public abstract void boostUpwards();

    @Override
    public void moveDown(double amount) {
        setAnchorLocationY(getAnchorLocation().getY() + amount);
    }
}
