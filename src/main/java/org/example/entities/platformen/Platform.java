package org.example.entities.platformen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Platform extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
    private PlatformHitBox hitbox;
    private boolean removed = false;
    private Coordinate2D locatie;

    public Platform(String afbeelding, Coordinate2D initialLocation, Size grootte) {
        super(afbeelding, initialLocation, grootte);
        this.locatie = initialLocation;
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

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved() {
        this.removed = true;
    }

    public Coordinate2D getLocatie() {
        return locatie;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if(sceneBorder.equals(SceneBorder.BOTTOM)) {
            removed = true;
            remove();
        }
    }
}

