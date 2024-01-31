package ru.healthydiet.site.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {
    String name;
    int calories;
    int proteins;
    int fats;
    int carbohydrates;
    int fibers;
    int sugar;
    int sodium;
    int cuprum;
    int iron;
    int folate;
    int potassium;
    int magnesium;
    int thiamine;
    int riboflavin;
    int vitaminB6;
    int vitaminC;
    int vitaminE;
}
