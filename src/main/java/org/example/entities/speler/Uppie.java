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

import java.util.List;
import java.util.Set;

public class Uppie extends DynamicSpriteEntity implements Collided, KeyListener, Newtonian, SceneBorderCrossingWatcher {
    private long vorigeSprongTijd;
    private boolean isInSprong = false;


    protected Uppie(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.LEFT)){
            setMotion(3,270d);
            setCurrentFrameIndex(0);
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(3,90d);
            setCurrentFrameIndex(1);
        }
    }

    public void AutomatischSpringen(){
        long tijd = System.currentTimeMillis();
        long sprongDuur = 1000;
        if (!isInSprong) {
            setMotion(10, 0d);
            isInSprong = true;
            vorigeSprongTijd = tijd;
        } else if(tijd - vorigeSprongTijd > sprongDuur) {
            setMotion(10, 180d);
            isInSprong = false;
            vorigeSprongTijd = tijd;
        }
    }

    @Override
    public void onCollision(List<Collider> list) {

    }
}
