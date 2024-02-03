package ru.healthydiet.site.contoller;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.healthydiet.site.response.DishResponse;
import ru.healthydiet.site.response.ProductResponse;
import ru.healthydiet.site.service.dishes.DishService;

@RestController
@RequestMapping("/api/v1/dish")
@RequiredArgsConstructor
public class DishController {

    private final ObjectMapper objectMapper;
    private final DishService dishService;

    @SneakyThrows
    @PostMapping("/")
    public ResponseEntity<String> createDish() {
        return ResponseEntity.ok(objectMapper.writeValueAsString(dishService.createNewDish()));
    }

    @SneakyThrows
    @GetMapping("/")
    public ResponseEntity<String> getDish(@RequestParam Integer id) {
        DishResponse dishResponse = dishService.getDishById(id);
        if (dishResponse.getStatus() == 200) {
            return ResponseEntity.ok(objectMapper.writeValueAsString(dishResponse));
        }
        return ResponseEntity.status(404).body(objectMapper.writeValueAsString(dishResponse));
    }

    @SneakyThrows
    @GetMapping("/all")
    public ResponseEntity<String> getAllDishes() {
        return ResponseEntity.ok(objectMapper.writeValueAsString(dishService.getAllDishes()));
    }

    @SneakyThrows
    @DeleteMapping("/")
    public ResponseEntity<String> deleteDish(@RequestParam Integer id) {
        DishResponse dishResponse = dishService.deleteProductById(id);
        if (dishResponse.getStatus() == 200) {
            return ResponseEntity.ok(objectMapper.writeValueAsString(dishResponse));
        }
        return ResponseEntity.status(404).body(objectMapper.writeValueAsString(dishResponse));
    }
}
