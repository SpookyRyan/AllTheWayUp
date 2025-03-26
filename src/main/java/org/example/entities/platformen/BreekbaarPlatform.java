package org.example.entities.platformen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import javafx.scene.Node;
import org.example.entities.speler.Uppie;

import java.util.List;
import java.util.Optional;


public class
BreekbaarPlatform extends Platform implements Collided {

    public BreekbaarPlatform(Coordinate2D initialLocation, Size grootte) {
        super("afbeeldingen/BreekbaarPlatform.png", initialLocation, grootte);

    }

    @Override
    public void onCollision(List<Collider> list) {
        for(Collider collider : list){
            if (collider instanceof Uppie){
                remove();
            }
        }
    }
}
