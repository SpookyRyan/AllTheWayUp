package org.example.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class UpcoinScoreText extends TextEntity {

    public UpcoinScoreText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.BLUE);
    }

    public void setUpcoinScoreText(int Score) {

        setText("Up-coins: " + Score);
    }
}
