package org.example.entities.boosters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entities.speler.Uppie;

public abstract class BoosterEntity extends SpriteEntity implements Collider {

    protected final Uppie uppie;

    public BoosterEntity(Coordinate2D location, Size size, String sprite, Uppie uppie) {
        super(sprite, location, size);
        this.uppie = uppie;
    }

    public abstract void boostUpwards();

    public void moveDown(double hoeveelheid) {
        setAnchorLocationY(getAnchorLocation().getY() + hoeveelheid);
    }
}
