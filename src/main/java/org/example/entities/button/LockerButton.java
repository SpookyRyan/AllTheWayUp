package org.example.entities.button;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.AllTheWayUp;

public class LockerButton extends Button {
    private AllTheWayUp game;

    public LockerButton(Coordinate2D initialLocation, AllTheWayUp game){
        super(initialLocation,"Locker (Work in Progress)");
        this.game = game;
        setFill(Color.PURPLE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 25));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){

    }

    @Override
    public void onMouseEntered(){
        setFill(Color.DARKRED);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setFill(Color.RED);
        setCursor(Cursor.DEFAULT);
    }

}
