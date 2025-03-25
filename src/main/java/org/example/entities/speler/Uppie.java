package org.example.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.entities.knoppen.StartKnop;

import java.util.List;
import java.util.Set;

public class Uppie extends DynamicSpriteEntity implements Collided, KeyListener, Newtonian, SceneBorderCrossingWatcher {
    protected Uppie(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {

    }

    @Override
    public void onCollision(List<Collider> list) {

    }
}
