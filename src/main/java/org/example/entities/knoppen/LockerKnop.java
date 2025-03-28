package org.example.entities.knoppen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.AllTheWayUp;

public class LockerKnop extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private AllTheWayUp game;

    public LockerKnop(Coordinate2D initialLocation, AllTheWayUp game){
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
