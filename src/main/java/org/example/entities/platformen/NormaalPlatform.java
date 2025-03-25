package org.example.entities.platformen;

import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.core.entities.EntityCollection;
import com.google.inject.Injector;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Optional;

public class NormaalPlatform implements IPlatformSpawner, Collider, EntitySpawnerContainer {
    @Override
    public void onCollision() {

    }

    @Override
    public Optional<? extends Node> getNode() {
        return Optional.empty();
    }

    @Override
    public void setupEntitySpawners() {

    }

    @Override
    public Injector getInjector() {
        return null;
    }

    @Override
    public Pane getRootPane() {
        return null;
    }

    @Override
    public EntityCollection getEntityCollection() {
        return null;
    }

    @Override
    public List<EntitySpawner> getSpawners() {
        return List.of();
    }
}
