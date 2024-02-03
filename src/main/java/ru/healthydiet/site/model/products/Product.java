package ru.healthydiet.site.model.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.healthydiet.site.model.dishes.Dish;

@Entity
@Table
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@JsonPropertyOrder({"product_id", "product"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("product_id")
    int id;

    @Column(unique = true)
    @JsonProperty("product")
    String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_content_id")
    @JsonManagedReference
    @JsonProperty("product_content")
    ProductContent productContent;

    @ManyToOne
    @JsonIgnore
    Dish dish;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productContent=" + productContent +
                '}';
    }
}
