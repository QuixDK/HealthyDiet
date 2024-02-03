package ru.healthydiet.site.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {
    String name;
    long calories;
    long proteins;
    long fats;
    long carbohydrates;
    long fibers;
    long sugar;
    long sodium;
    long cuprum;
    long iron;
    long folate;
    long potassium;
    long magnesium;
    long thiamine;
    long riboflavin;
    long vitaminB6;
    long vitaminC;
    long vitaminE;
}
