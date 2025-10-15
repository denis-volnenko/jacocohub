package ru.volnenko.cloud.testhub.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class IndexControllerTest {

    @Autowired
    private IndexController indexController;

    @Test
    public void indexTest() {
        Assert.notNull(indexController.index(), "Index Page");
        Assert.isTrue("index".equals(indexController.index().getViewName()), "Check view name");
    }

}
