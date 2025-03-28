package org.example.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class UpcoinScore extends TextEntity {

    public UpcoinScore(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.DARKCYAN);
    }

    public void setScoreText(int Score) {
        setText("Up-coins: " + Score);
    }
}
