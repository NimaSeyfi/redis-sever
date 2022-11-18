package com.redis.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class SetRequest {

    @NotNull(message = "key can't be null")
    @NotBlank(message = "key can't be blank")
    @NotEmpty(message = "key can't be empty")
    @Size(min = 1, max = 500, message = "key content size should fit in 1 to 500 characters")
    private String key;

    @NotNull(message = "value can't be null")
    @NotBlank(message = "value can't be blank")
    @NotEmpty(message = "value can't be empty")
    private String value;

}
