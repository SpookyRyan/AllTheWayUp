package org.example.entities.platformen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;


public class NormalPlatform extends Platform {
    public NormalPlatform(Coordinate2D initialLocation, Size grootte) {
        super("images/grassplatform.png", initialLocation, grootte);
    }
}
