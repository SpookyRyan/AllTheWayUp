package org.example.entities;

import java.io.*;
import java.nio.file.*;

// Deze code is een manager voor het opslaan en laden van de highscore van het spel, deze is van het internet door verschillende StackOverflow
// code gemaakt en met AI verbeterd.

public class UpcoinManager {
    private static final String FILENAME = System.getProperty("user.home") + "/.uppie_upcoin.txt";

    public static int loadHighscore() {
        try {
            if (!Files.exists(Paths.get(FILENAME))) {
                return 0;
            }
            String content = Files.readString(Paths.get(FILENAME)).trim();
            return Integer.parseInt(content);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void saveHighscore(int score) {
        try {
            Files.writeString(Paths.get(FILENAME), String.valueOf(score));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
