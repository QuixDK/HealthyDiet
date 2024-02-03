package ru.healthydiet.site.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.healthydiet.site.model.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@JsonPropertyOrder({"product"})
public class ProductResponse {

    @JsonProperty("product")
    Product product;
    String message;
    int status;
}
