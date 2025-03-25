package org.example.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class UppieSprite extends SpriteEntity {
    protected UppieSprite(final Coordinate2D location, Size size) {
        super("Sprites/Uppie.png", location, size);
    }
}
