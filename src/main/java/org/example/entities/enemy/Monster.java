package org.example.entities.enemy;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import org.example.AllTheWayUp;
import org.example.entities.IMoveable;
import org.example.entities.player.UppieHitBox;

import java.util.List;

public class Monster extends DynamicSpriteEntity implements Collided, Collider, IMoveable {
    private final AllTheWayUp game;

    protected Monster(Coordinate2D initialLocation, AllTheWayUp game) {
        super("images/monster.png", initialLocation, new Size(50, 50));
        this.game = game;
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof UppieHitBox) {
                game.setActiveScene(2);
            }
        }
    }

    @Override
    public void moveDown(double amount) {
        setAnchorLocationY(getAnchorLocation().getY() + amount);
    }

}