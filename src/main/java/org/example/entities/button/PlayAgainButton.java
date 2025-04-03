package org.example.entities.button;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.AllTheWayUp;

public class PlayAgainButton extends Button {
    private final AllTheWayUp game;

    public PlayAgainButton(Coordinate2D initialLocation, AllTheWayUp game){
        super(initialLocation,"Speel opnieuw");
        this.game = game;
        setFill(Color.PURPLE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        game.setActiveScene(1);
    }

    @Override
    public void onMouseEntered(){
        setFill(Color.VIOLET);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setFill(Color.PURPLE);
        setCursor(Cursor.DEFAULT);
    }

}
