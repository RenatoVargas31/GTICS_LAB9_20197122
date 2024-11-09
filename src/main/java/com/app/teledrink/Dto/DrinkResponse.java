package com.app.teledrink.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DrinkResponse {
    @JsonProperty("drinks")
    private List<ListDrinkDto> drinks;
}