package com.app.teledrink.Controller;

import com.app.teledrink.Dto.DetailDrinkDto;
import com.app.teledrink.Service.DrinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drinks")
public class AppController {
    //Services
    private final DrinkService drinkService;

    public AppController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping("/detail")
    public String detailDrink(Model model, Integer id) {
        DetailDrinkDto drink = drinkService.getDrinkDetail(id).block();
        model.addAttribute("drink", drink);
        return "detail";
    }
}
