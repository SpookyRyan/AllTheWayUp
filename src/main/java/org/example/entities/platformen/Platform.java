package org.example.entities.platformen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Platform extends DynamicSpriteEntity implements Collider {
    private PlatformHitBox hitbox;

    public Platform(String afbeelding, Coordinate2D initialLocation, Size grootte) {
        super(afbeelding, initialLocation, grootte);

    }

    public void moveDown(double hoeveelheid) {
        setAnchorLocationY(getAnchorLocation().getY() + hoeveelheid);

        if (hitbox != null) {
            hitbox.setAnchorLocationY(hitbox.getAnchorLocation().getY() + hoeveelheid);
        }
    }

    public void setHitbox(PlatformHitBox hitbox) {
        this.hitbox = hitbox;
    }
}

