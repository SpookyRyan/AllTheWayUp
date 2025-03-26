package org.example.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.AllTheWayUp;

import java.util.List;
import java.util.Set;

public class Uppie extends DynamicSpriteEntity implements Collided, KeyListener, SceneBorderCrossingWatcher, Newtonian {
    private AllTheWayUp game;
    private long vorigeSprongTijd;
    private boolean isInSprong = false;


    public Uppie(Coordinate2D positie, Size grootte, AllTheWayUp game) {
        super("Sprites/Uppie.png", positie, grootte);
        this.game = game;

        setGravityConstant(1);
        setFrictionConstant(0.3);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if (sceneBorder == SceneBorder.BOTTOM) {
            game.setActiveScene(2);
        }

        switch(sceneBorder){
            case LEFT:
                setAnchorLocationX(getSceneWidth() - getWidth() + 30);
                break;
            case RIGHT:
                setAnchorLocationX(-30);
            default:
                break;
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.LEFT)){
            setMotion(3,270d);
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(3,90d);
        } else if(pressedKeys.contains(KeyCode.UP)){
            setMotion(3,180d);
        } else if(pressedKeys.contains(KeyCode.DOWN)){
            setMotion(3,0d);
        } else {
            setMotion(0,0d);
        }
    }

    public void AutomatischSpringen(){
        long tijd = System.currentTimeMillis();
        long sprongDuur = 1000;

        if (!isInSprong) {
            setMotion(1, 0d);
            isInSprong = true;
            vorigeSprongTijd = tijd;
        }
        else if(tijd - vorigeSprongTijd > sprongDuur) {
            setMotion(10, 0d);
            isInSprong = false;
            vorigeSprongTijd = tijd;
        }

    }

    @Override
    public void onCollision(List<Collider> list) {
        setMotion(50,180d);

    }

    public int getY(){
        return (int) getAnchorLocation().getY();
    }

    public void checkOfUppieBovenLimitIs(){
        double uppieY = getY();
        double limit = getHeight() - getHeight() / 3;

        if(uppieY < limit){
            double verschil = limit - uppieY;
            // platform y --
        }
    }
}
