package ru.healthydiet.site.service;

import ru.healthydiet.site.DTO.ProductDTO;
import ru.healthydiet.site.model.Product;

import java.util.List;

public interface ProductService {

    String saveNewProduct(ProductDTO productDTO);
    String getProductById(Integer id);
    List<Product> getAllProducts();
    String deleteProductById(Integer id);
}
