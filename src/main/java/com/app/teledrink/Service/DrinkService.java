package com.app.teledrink.Service;

import com.app.teledrink.Dto.DetailDrinkDto;
import com.app.teledrink.Dto.DrinkDetailResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DrinkService {
    private final WebClient webClient;

    public DrinkService(WebClient webClient) {
        this.webClient = webClient;
    }

    //Obtener detalle de una bebida
    public Mono<DetailDrinkDto> getDrinkDetail(Integer id) {
        return webClient.get()
                .uri("/lookup.php?i={id}", id)
                .retrieve()
                .bodyToMono(DrinkDetailResponse.class)
                .map(drinkDetailResponse -> drinkDetailResponse.getDrinks().get(0));
    }
}
