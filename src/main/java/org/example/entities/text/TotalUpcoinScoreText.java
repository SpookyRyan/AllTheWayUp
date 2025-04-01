package org.example.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static org.example.entities.player.Uppie.playerUpcoins;

public class TotalUpcoinScoreText extends TextEntity {

    public TotalUpcoinScoreText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.GOLDENROD);
        setText("Up-coins: " + playerUpcoins);
    }
}
