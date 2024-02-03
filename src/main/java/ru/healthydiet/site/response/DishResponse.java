package ru.healthydiet.site.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.healthydiet.site.model.dishes.Dish;
import ru.healthydiet.site.model.products.Product;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@JsonPropertyOrder({"dish", "products"})
public class DishResponse {

    @JsonProperty("dish")
    Dish dish;

    String message;
    int status;
}