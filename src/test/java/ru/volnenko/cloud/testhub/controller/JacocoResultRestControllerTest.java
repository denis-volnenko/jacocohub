package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;
import ru.volnenko.cloud.testhub.dto.ResultDto;

@SpringBootTest
public class JacocoResultRestControllerTest {

    @Autowired
    private JacocoResultRestController controller;

    @Test
    public void testPublish() {
        @NonNull final JacocoResultDto dto = JacocoResultDto.create()
                .artifact("testhub")
                .build();
        @NonNull final ResultDto resultDto = controller.publish(dto);
        Assert.isTrue(resultDto.getSuccess(), resultDto.getMessage());
    }

}
