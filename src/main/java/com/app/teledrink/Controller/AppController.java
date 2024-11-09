package com.app.teledrink.Controller;

import com.app.teledrink.Dto.ListDrinkDto;
import com.app.teledrink.Service.DrinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/drinks")
public class AppController {
    private final DrinkService drinkService;

    public AppController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping("/list")
    public String listDrinks(Model model) {
        List<ListDrinkDto> drinks = drinkService.getDrinks().collectList().block();
        model.addAttribute("drinks", drinks);
        return "index";
    }
}
