package com.app.teledrink.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drinkfavorite")
public class ListDrinkDto {
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    @JsonProperty("strDrink")
    private String strDrink;

    @Size(max = 200)
    @Column(name = "imagen", length = 200)
    @JsonProperty("strDrinkThumb")
    private String strDrinkThumb;

    @Id
    @Column(name = "idDrinkFavorite", nullable = false)
    @JsonProperty("idDrink")
    private Integer idDrink;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "isFavorite", nullable = false)
    private Byte isFavorite;

}
