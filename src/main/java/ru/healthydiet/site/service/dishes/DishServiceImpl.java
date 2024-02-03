package ru.healthydiet.site.service.dishes;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.healthydiet.site.model.dishes.Dish;
import ru.healthydiet.site.model.dishes.DishContent;
import ru.healthydiet.site.model.products.Product;
import ru.healthydiet.site.model.products.ProductContent;
import ru.healthydiet.site.repository.DishRepository;
import ru.healthydiet.site.repository.ProductRepository;
import ru.healthydiet.site.response.DishResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final ProductRepository productRepository;

    @Override
    public DishResponse createNewDish() {
        Dish dish = new Dish();
        DishContent dishContent = new DishContent();
        List<Product> dishProducts = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        Random rand = new Random();
        dish.setName("");
        for (int i = 0; i < 3; i++) {
            int randomInt = (rand.nextInt(products.size()));
            Product product = products.get(randomInt);
            dish.setName(dish.getName() + product.getName());
            dishProducts.add(product);
            setDishContent(dishContent, product.getProductContent());
        }
        dish.setProducts(dishProducts);
        dish.setDishContent(dishContent);
        dishRepository.save(dish);
        return DishResponse.builder()
                .dish(dish)
                .message("Success to create new dish!")
                .build();
    }

    private void setDishContent(DishContent dishContent, ProductContent productContent) {
        dishContent.setCalories(dishContent.getCalories() + productContent.getCalories());
        dishContent.setCarbohydrates(dishContent.getCarbohydrates() + productContent.getCarbohydrates());
        dishContent.setFats(dishContent.getFats() + productContent.getFats());
    }

    @Override
    public DishResponse getDishById(Integer id) {
        return null;
    }

    @Override
    public List<Dish> getAllDishes() {
        return null;
    }

    @Override
    public DishResponse deleteProductById(Integer id) {
        return null;
    }

    @Override
    public DishResponse updateDish(Dish dish) {
        return null;
    }
}
