package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.entities.platformen.PlatformSpawner;
import org.example.entities.speler.Uppie;

public class SpelLevel extends DynamicScene implements EntitySpawnerContainer {
    @Override
    public void setupScene() {
    setBackgroundAudio("audio/SpelLevelMuziek.mp3");
    setBackgroundAudioVolume(0.3);
    }

    @Override
    public void setupEntities() {
        Uppie uppie = new Uppie(new Coordinate2D(100, 100), new Size(50, 50));
        addEntity(uppie);
        uppie.AutomatischSpringen();
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new PlatformSpawner(10, getWidth(), getHeight()));

    }
}
