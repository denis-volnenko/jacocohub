package ru.volnenko.cloud.testhub.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ResultDto {

    @NonNull
    @JsonProperty("success")
    private Boolean success = true;

    @NonNull
    @JsonProperty("message")
    private String message = "";

    public ResultDto(@NonNull final Exception e) {
        this.success = false;
        this.message = e.getMessage();
    }

}
