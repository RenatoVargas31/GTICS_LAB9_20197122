package com.app.teledrink.Service;

import com.app.teledrink.Dto.DetailDrinkDto;
import com.app.teledrink.Dto.DrinkDetailResponse;
import com.app.teledrink.Dto.DrinkListResponse;
import com.app.teledrink.Dto.ListDrinkDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DrinkService {
    private final WebClient webClient;

    public DrinkService(WebClient webClient) {
        this.webClient = webClient;
    }

    //Listar las bebidas
    public Flux<ListDrinkDto> getDrinks() {
        return webClient.get()
                .uri("/filter.php?c=Cocktail")
                .retrieve()
                .bodyToMono(DrinkListResponse.class)
                .flatMapMany(drinkListResponse -> Flux.fromIterable(drinkListResponse.getDrinks()))
                .take(12);
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
