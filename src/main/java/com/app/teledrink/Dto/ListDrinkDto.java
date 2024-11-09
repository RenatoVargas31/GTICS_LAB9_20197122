package com.app.teledrink.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ListDrinkDto {

    @JsonProperty("strDrink")
    private String strDrink;

    @JsonProperty("strDrinkThumb")
    private String strDrinkThumb;

    @JsonProperty("idDrink")
    private Integer idDrink;

}
