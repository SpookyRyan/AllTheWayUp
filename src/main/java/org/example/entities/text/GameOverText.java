package org.example.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOverText extends TextEntity {
    public GameOverText(Coordinate2D initialLocation) {
        super(initialLocation);
        setText("Game Over");
        setFill(Color.RED);
        setFont(Font.font("Roboto", FontWeight.BOLD, 50));

        TextEntity scoreText = new TextEntity(initialLocation.add(new Coordinate2D(-20, 60)), "Behaalde score: ");
        scoreText.setFill(Color.WHITE);
        scoreText.setFont(Font.font("Roboto", FontWeight.NORMAL, 30));

    }
}
