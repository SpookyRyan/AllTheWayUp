package org.example.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Uppie2 extends DynamicCompositeEntity implements SceneBorderCrossingWatcher, KeyListener {


    public Uppie2(Coordinate2D initialLocation) {
        super(initialLocation);

        setMotion(1, 0D);
    }

    @Override
    protected void setupEntities() {
        addEntity(new UppieSprite(new Coordinate2D(200, 100), new Size(50, 50)));
        addEntity(new UppieHitBox(new Coordinate2D(200, 145)));
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.LEFT)){
            addToMotion(0.7,270d);
        } else if(pressedKeys.contains(KeyCode.RIGHT)) {
            addToMotion(0.7, 90d);
        }
    }
}
