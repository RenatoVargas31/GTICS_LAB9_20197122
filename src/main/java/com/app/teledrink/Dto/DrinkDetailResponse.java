package com.app.teledrink.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DrinkDetailResponse {
    @JsonProperty("drinks")
    private List<DetailDrinkDto> drinks;
}
