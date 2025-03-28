package org.example.entities.boosters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.entities.speler.Uppie;

public class Trampoline extends BoosterEntity {

    public Trampoline(Coordinate2D location, Uppie uppie) {
        super(location, new Size(60, 40), "images/trampoline.png", uppie);
    }

        @Override
          public void boostUpwards() {
             uppie.setCurrentGravity(-4);
             uppie.setIsInJump(true);
     }
}
