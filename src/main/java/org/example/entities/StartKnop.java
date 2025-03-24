package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.AllTheWayUp;

public class StartKnop extends TextEntity implements MouseButtonPressedListener {
    private AllTheWayUp game;

    public StartKnop(Coordinate2D initialLocation, AllTheWayUp game){
        super(initialLocation,"Start Spel");
        this.game = game;
        setFill(Color.PURPLE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        game.setActiveScene(1);
    }
}
