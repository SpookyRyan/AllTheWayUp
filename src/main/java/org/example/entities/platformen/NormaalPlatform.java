package org.example.entities.platformen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

import com.github.hanyaeger.api.entities.impl.SpriteEntity;


public class NormaalPlatform extends SpriteEntity {
    public NormaalPlatform(Coordinate2D initialLocation, Size grootte) {
        super("afbeeldingen/grasplatform.png", initialLocation, grootte);
    }
}
