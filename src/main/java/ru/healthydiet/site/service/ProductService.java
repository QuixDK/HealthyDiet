package ru.healthydiet.site.service;

import ru.healthydiet.site.DTO.ProductDTO;
import ru.healthydiet.site.model.Product;

import java.util.List;

public interface ProductService {

    void saveNewProduct(ProductDTO productDTO);
    String getProductContentById(Integer id);
    List<Product> getAllProducts();
    String deleteProductById(Integer id);
}
