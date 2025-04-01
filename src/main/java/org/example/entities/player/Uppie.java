package org.example.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.AllTheWayUp;
import org.example.entities.UpcoinManager;
import org.example.entities.boosters.BoosterEntity;
import org.example.entities.enemy.Monster;
import org.example.entities.objects.Upcoin;
import org.example.entities.platforms.Platform;
import org.example.entities.platforms.PlatformSpawner;
import org.example.entities.text.ScoreText;
import org.example.entities.text.UpcoinScoreText;

import java.util.List;
import java.util.Set;

public class Uppie extends DynamicCompositeEntity implements SceneBorderCrossingWatcher, KeyListener, TimerContainer, Newtonian, Collided {
    private final AllTheWayUp game;
    private static boolean isInJump = false;
    private double currentGravity = 0;
    private final double jumpStartGravity = -2.7;
    private final double maxGravity = 2;
    private double gravityStep = 0.1;
    private List<Collider> platforms;
    private List<Collider> boosterList;
    private List<Collider> monsterList;
    private List<Upcoin> upcoinList;
    private double previousY;
    private static int score = 0;
    private ScoreText scoreText;
    private static UpcoinScoreText upcoinScoreText;
    private static int upcoinScore = 0;
    public static boolean isInLimit;
    public static int playerUpcoins = UpcoinManager.loadHighscore();

    public Uppie(Coordinate2D initialLocation, AllTheWayUp game) {
        super(initialLocation);
        this.game = game;

        setGravityConstant(1);
        setFrictionConstant(0.3);

        this.previousY = getAnchorLocation().getY();

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

    public void checkOfUppieBovenLimitIs(List<Collider> list){
        if (list == null) return;
        scoreText.setScoreText(score);
        double uppieY = getY();
        double limit = 230;

        if (uppieY < limit && uppieY < previousY) {
            double verschil = previousY - uppieY;
            gravityStep = 0.15;
            score += verschil/3;
            setAnchorLocationY(limit);
            isInLimit = true;

            if (platformSpawner != null) {
                platformSpawner.updatePlatformLocation(verschil);
            }


            for (Collider collider : platforms) {
                if (collider instanceof Platform) {
                    ((Platform) collider).moveDown(verschil);
                }
            }

            for (Collider collider : boosterList) {
                if (collider instanceof BoosterEntity) {
                    ((BoosterEntity) collider).moveDown(verschil);
                }
            }

            for (Collider collider : monsterList) {
                if (collider instanceof Monster) {
                    ((Monster) collider).moveDown(verschil);
                }
            }

            for (Collider collider : upcoinList) {
                if (collider instanceof Upcoin) {
                    ((Upcoin) collider).moveDown(verschil);
                }
            }

        } else {
            gravityStep = 0.1;
        }
        previousY = getY();
    }

    @Override
    public void onCollision(List<Collider> list) {
        /*
        for (Collider collider : list) {
            if(collider instanceof Upcoin){
                upcoinScore++;
                upcoinScoreText.setUpcoinScoreText(upcoinScore);
            }
        }
        */
    }

    public static void increaseUpcoinScore() {
        upcoinScore++;
        playerUpcoins++;
        UpcoinManager.saveHighscore(playerUpcoins);
        upcoinScoreText.setUpcoinScoreText(upcoinScore);
    }

    public static void setIsInLimit(boolean value) {
        isInLimit = value;
    }

    public void setPlatforms(List<Collider> platforms) {
        this.platforms = platforms;
    }

    public void setBoosters(List<Collider> boosters) {
        this.boosterList = boosters;
    }

    public void setMonsters(List<Collider> monsters) {
        this.monsterList = monsters;
    }

    public void setUpcoins(List<Upcoin> upcoins) {
        this.upcoinList = upcoins;
    }

    public void setScoreText(ScoreText scoreText) {
        this.scoreText = scoreText;
    }

    public void setUpcoinScoreText(UpcoinScoreText upcoinScoreText) {
        this.upcoinScoreText = upcoinScoreText;
    }

    public void setCurrentGravity(double gravity) {
        this.currentGravity = gravity;
        setGravityConstant(gravity);
    }

    public void setIsInJump(boolean isJumping) {
        isInJump = isJumping;
    }

    private PlatformSpawner platformSpawner;

    public void setPlatformSpawner(PlatformSpawner platformSpawner) {
        this.platformSpawner = platformSpawner;
    }


    public static boolean getIsInJump(){
        return isInJump;
    }

    public int getY(){
        return (int) getAnchorLocation().getY();
    }


    public static int getFinalScore() {
        return score;
    }

    public static int getFinalUpcoinScore() {
        return upcoinScore;
    }

    public static boolean getIsInLimit() {
        return isInLimit;
    }
}
