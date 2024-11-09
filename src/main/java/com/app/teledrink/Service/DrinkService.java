package com.app.teledrink.Service;

import com.app.teledrink.Dto.DrinkListResponse;
import com.app.teledrink.Dto.ListDrinkDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

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
}
