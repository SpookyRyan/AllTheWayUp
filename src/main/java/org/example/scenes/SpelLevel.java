package org.example.scenes;

import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.entities.platformen.PlatformSpawner;

public class SpelLevel extends DynamicScene implements EntitySpawnerContainer {
    @Override
    public void setupScene() {
    setBackgroundAudio("audio/SpelLevelMuziek.mp3");
    setBackgroundAudioVolume(0.3);
    }

    @Override
    public void setupEntities() {

    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new PlatformSpawner(100, getWidth(), getHeight()));
    }
}
