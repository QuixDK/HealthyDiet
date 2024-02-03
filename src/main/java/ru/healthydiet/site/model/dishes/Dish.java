package ru.healthydiet.site.model.dishes;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ru.healthydiet.site.model.products.Product;

import java.util.List;

@Entity
@Table
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonProperty("dish_name")
    String name;

    @JsonProperty("products")
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Product> products;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_content_id")
    @JsonProperty("dish_content")
    @JsonManagedReference
    DishContent dishContent;
}
