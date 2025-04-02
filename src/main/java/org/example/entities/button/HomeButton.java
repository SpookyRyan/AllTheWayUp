package org.example.entities.button;

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

public class HomeButton extends Button {
    private AllTheWayUp game;

    public HomeButton(Coordinate2D initialLocation, AllTheWayUp game){
        super(initialLocation,"Terug naar menu");
        this.game = game;
        setFill(Color.GREEN);
        setFont(Font.font("Roboto", FontWeight.BOLD, 25));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        game.setActiveScene(0);
    }

    @Override
    public void onMouseEntered(){
        setFill(Color.GREENYELLOW);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setFill(Color.GREEN);
        setCursor(Cursor.DEFAULT);
    }

}
