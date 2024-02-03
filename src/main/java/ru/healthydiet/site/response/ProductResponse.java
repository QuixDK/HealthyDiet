package ru.healthydiet.site.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {

    @JsonProperty("product_id")
    int id;

    @JsonProperty("product")
    String name;

    @JsonProperty
    String message;
}
