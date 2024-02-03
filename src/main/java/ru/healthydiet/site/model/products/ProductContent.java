package ru.healthydiet.site.model.products;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.healthydiet.site.model.products.Product;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor @NoArgsConstructor
@Getter@Setter
@Builder
@Entity
@Table(name = "product_content")
public class ProductContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_content_id")
    @JsonIgnore
    int id;

    @OneToOne(mappedBy = "productContent", cascade = CascadeType.ALL)
    @JsonBackReference
    Product product;

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

    @Override
    public String toString() {
        return "ProductContent{" +
                "id=" + id +
                ", calories=" + calories +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                ", fibers=" + fibers +
                ", sugar=" + sugar +
                ", sodium=" + sodium +
                ", cuprum=" + cuprum +
                ", iron=" + iron +
                ", folate=" + folate +
                ", potassium=" + potassium +
                ", magnesium=" + magnesium +
                ", thiamine=" + thiamine +
                ", riboflavin=" + riboflavin +
                ", vitaminB6=" + vitaminB6 +
                ", vitaminC=" + vitaminC +
                ", vitaminE=" + vitaminE +
                '}';
    }
}
