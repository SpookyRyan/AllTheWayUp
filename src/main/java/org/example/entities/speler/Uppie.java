package org.example.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.AllTheWayUp;
import org.example.entities.platformen.Platform;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.Timer;

import java.util.List;
import java.util.Set;

public class Uppie extends DynamicSpriteEntity implements Collided, KeyListener, SceneBorderCrossingWatcher, Newtonian, TimerContainer{
    private final AllTheWayUp game;;
    long prevMillis;
    private double currentGravity = 0;
    private boolean isInJump = false;
    private boolean isCollided = false;
    private final double jumpStartGravity = -4;  // <-- krachtiger omhoog
    private final double maxGravity = 2;     // <-- max valversnelling
    private final double gravityStep = 0.1;


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

    @Override
    public void setupTimers() {
        addTimer(new Timer(10) {
            @Override
            public void onAnimationUpdate(long timestamp) {
                jumpAutomatically();
            }
        });
    }

    @Override
    public void onCollision(List<Collider> list) {
        if (!isInJump) {
            isCollided = true;
        }
//        System.out.println("joepie");

    }


    public void jumpAutomatically() {
        long millis = System.currentTimeMillis();

        if (isCollided && !isInJump) {
            currentGravity = jumpStartGravity;
            setGravityConstant(currentGravity);
            prevMillis = millis;
            isInJump = true;
            isCollided = false;
        }
        if (currentGravity < maxGravity) {
            currentGravity += gravityStep;
            setGravityConstant(currentGravity);

            if (currentGravity > 0) {
//                System.out.println("joepie");
                isInJump = false;
            }
        }
    }




    public int getY(){
        return (int) getAnchorLocation().getY();
    }

    public void checkOfUppieBovenLimitIs(List<Collider> list){ //kan nog wel een betere naam krijgen
        double uppieY = getY();
        double limit = getHeight() - getHeight() / 3;

        if(uppieY < limit){
            double verschil = limit - uppieY;
            for(Collider collider : list)
                if(collider instanceof Platform){
                    ((Platform) collider).moveDown(verschil);
                }
        }
    }
}
