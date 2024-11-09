package com.app.teledrink.Controller;

import com.app.teledrink.Dto.DetailDrinkDto;
import com.app.teledrink.Dto.ListDrinkDto;
import com.app.teledrink.Repository.DrinkFavoriteRepository;
import com.app.teledrink.Service.DrinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/drinks")
public class AppController {
    //Services
    private final DrinkService drinkService;
    private final DrinkFavoriteRepository drinkFavoriteRepository;

    public AppController(DrinkService drinkService, DrinkFavoriteRepository drinkFavoriteRepository) {
        this.drinkService = drinkService;
        this.drinkFavoriteRepository = drinkFavoriteRepository;
    }

    @GetMapping("/detail")
    public String detailDrink(Model model, Integer id) {
        DetailDrinkDto drink = drinkService.getDrinkDetail(id).block();
        Optional<ListDrinkDto> drinkFavorite = drinkFavoriteRepository.findById(id);

        int isFavorite = 0;
        if (drinkFavorite.isPresent()) {
            isFavorite = 1;
        }
        model.addAttribute("drink", drink);
        model.addAttribute("isFavorite", isFavorite);
        return "detail";
    }

    @GetMapping("/addFavorite")
    public String addFavorite(Integer id) {
        ListDrinkDto drinkFavorite = drinkService.getDrinks().filter(drink -> drink.getIdDrink().equals(id)).blockFirst();
        //Guardar en la base de datos
        assert drinkFavorite != null;
        Byte isFavorite = 1;
        drinkFavorite.setIsFavorite(isFavorite);
        drinkFavoriteRepository.save(drinkFavorite);
        return "redirect:/drinks/detail?id=" + id;
    }
}
