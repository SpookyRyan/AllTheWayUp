package org.example.entities.platformen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;


public class NormalPlatform extends Platform implements Collider {
    public NormalPlatform(Coordinate2D initialLocation, Size grootte) {
        super("images/grassplatform.png", initialLocation, grootte);
    }
}
