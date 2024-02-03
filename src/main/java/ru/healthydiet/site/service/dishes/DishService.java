package ru.healthydiet.site.service.dishes;

import ru.healthydiet.site.dto.ProductDto;
import ru.healthydiet.site.model.dishes.Dish;
import ru.healthydiet.site.model.products.Product;
import ru.healthydiet.site.response.DishResponse;
import ru.healthydiet.site.response.ProductResponse;

import java.util.List;

public interface DishService {
    DishResponse createNewDish();
    DishResponse getDishById(Integer id);
    List<Dish> getAllDishes();
    DishResponse deleteProductById(Integer id);
    DishResponse updateDish(Dish dish);
}
