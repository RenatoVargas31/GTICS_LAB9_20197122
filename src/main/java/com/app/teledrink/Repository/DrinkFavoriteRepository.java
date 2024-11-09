package com.app.teledrink.Repository;

import com.app.teledrink.Dto.ListDrinkDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkFavoriteRepository extends JpaRepository <ListDrinkDto, Integer> {
}
