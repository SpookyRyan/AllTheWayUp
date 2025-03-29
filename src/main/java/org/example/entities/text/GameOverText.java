package org.example.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.entities.speler.Uppie;

public class GameOverText extends TextEntity {
    private Uppie uppie;

    public GameOverText(Coordinate2D initialLocation) {
        super(initialLocation);

        setText("Game Over\n" +
                "Behaalde score: " + Uppie.getFinalScore() + "\n" +
                "Upcoins: " + Uppie.getFinalUpcoinScore());

        setFill(Color.RED);
        setFont(Font.font("Roboto", FontWeight.BOLD, 35));
    }
}
