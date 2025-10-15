package ru.volnenko.cloud.testhub.controller;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class ArtifactControllerTest {

    @Autowired
    private ArtifactController artifactController;

    @Test
    public void testArtifacts() {
        Assert.notNull(artifactController.artifacts(), "Not null model and view");
    }

    @Test
    public void testArtifact() {
        Assert.notNull(artifactController.artifact(""), "Not null model and view");
    }

}
