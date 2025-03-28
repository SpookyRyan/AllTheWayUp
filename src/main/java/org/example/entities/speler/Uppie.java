package org.example.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.AllTheWayUp;
import org.example.entities.boosters.BoosterEntity;
import org.example.entities.platformen.Platform;
import org.example.entities.text.ScoreText;

import java.util.List;
import java.util.Set;

public class Uppie extends DynamicCompositeEntity implements SceneBorderCrossingWatcher, KeyListener, TimerContainer, Newtonian {
    private final AllTheWayUp game;
    private static boolean isInJump = false;
    private double currentGravity = 0;
    private final double jumpStartGravity = -2.7;
    private final double maxGravity = 2;
    private double gravityStep = 0.1;
    private List<Collider> platforms;
    private List<Collider> boosterLijst;
    private double vorigeY;
    private int score = 0;
    private ScoreText scoreText;


    public Uppie(Coordinate2D initialLocation, AllTheWayUp game) {
        super(initialLocation);
        this.game = game;

        setGravityConstant(1);
        setFrictionConstant(0.3);
    }


    @Override
    protected void setupEntities() {
        addEntity(new UppieSprite(new Coordinate2D(0, 0), new Size(50, 50)));
        addEntity(new UppieHitBox(new Coordinate2D(0, 45)));
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
                break;
            default:
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.LEFT)){
            addToMotion(0.7,270d);
        } else if(pressedKeys.contains(KeyCode.RIGHT)) {
            addToMotion(0.7, 90d);
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

    public void jumpAutomatically() {
        if (UppieHitBox.getIsCollided() && !isInJump) {
            currentGravity = jumpStartGravity;
            setGravityConstant(currentGravity);
            isInJump = true;
            UppieHitBox.setIsCollided(false);
        }
        if (currentGravity < maxGravity) {
            currentGravity += gravityStep;
            setGravityConstant(currentGravity);

            if (currentGravity > 0) {
                isInJump = false;
            }
        }
        checkOfUppieBovenLimitIs(platforms);
    }

    public static boolean getIsInJump(){
        return isInJump;
    }

    public void setPlatforms(List<Collider> platforms) {
        this.platforms = platforms;
    }

    public void setBoosters(List<Collider> boosters) {
        this.boosterLijst = boosters;
    }

    public int getY(){
        return (int) getAnchorLocation().getY();
    }

    public void checkOfUppieBovenLimitIs(List<Collider> list){
        if (list == null) return;
        scoreText.setScoreText(score);

        double uppieY = getY();
        double limit = 300;

        if (uppieY < limit && uppieY < vorigeY) {
            double verschil = vorigeY - uppieY;
            gravityStep = 0.15;
            score += verschil/3;

            for (Collider collider : platforms) {
                if (collider instanceof Platform) {
                    ((Platform) collider).moveDown(verschil);
                }
            }

            for (Collider collider : boosterLijst) {
                if (collider instanceof BoosterEntity) {
                    ((BoosterEntity) collider).moveDown(verschil);
                }
            }

        } else {
            gravityStep = 0.1;
        }
        vorigeY = uppieY;
    }

    public void setScoreText(ScoreText scoreText) {
        this.scoreText = scoreText;
    }


    public void setCurrentGravity(double gravity) {
        this.currentGravity = gravity;
        setGravityConstant(gravity);
    }

    public void setIsInJump(boolean isJumping) {
        isInJump = isJumping;
    }

}
