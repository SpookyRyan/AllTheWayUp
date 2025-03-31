package org.example.entities.boosters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.entities.player.Uppie;

public class Spring extends BoosterEntity {

    public Spring(Coordinate2D location, Uppie uppie) {
        super(location, new Size(50, 50), "images/veer.png", uppie);
    }

    @Override
    public void boostUpwards() {
        uppie.setCurrentGravity(-5.5);
        uppie.setIsInJump(true);
    }

}
