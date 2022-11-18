package com.redis.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@AllArgsConstructor
public class SelectRequest {

    @PositiveOrZero(message = "db should be greater than or equal zero.")
    @NotNull(message = "db can't be null")
    private Integer db;
}
