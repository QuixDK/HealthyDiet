package ru.healthydiet.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.healthydiet.site.model.dishes.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {
}
