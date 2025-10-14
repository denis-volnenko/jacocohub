package ru.volnenko.cloud.testhub.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArtifactServiceTest {

    @Autowired
    private ArtifactService artifactService;

    @Test
    public void test() {
//        artifactService.findByNameAndGroupId("hub");
    }

}
