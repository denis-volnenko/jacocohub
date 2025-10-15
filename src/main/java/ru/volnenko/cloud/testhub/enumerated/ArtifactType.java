package ru.volnenko.cloud.testhub.enumerated;

import lombok.NonNull;

public enum ArtifactType {

    MANIFEST("МАНИФЕСТ"),
    APPLICATION("ПРИЛОЖЕНИЕ"),
    LIBRARY("БИБЛИОТЕКА");

    @NonNull
    private final String displayName;

    ArtifactType(@NonNull final String displayName) {
        this.displayName = displayName;
    }

    @NonNull
    public String getDisplayName() {
        return displayName;
    }

}
