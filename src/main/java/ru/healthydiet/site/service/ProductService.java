package ru.healthydiet.site.service;

import ru.healthydiet.site.DTO.ProductDTO;
import ru.healthydiet.site.model.Product;
import ru.healthydiet.site.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse saveNewProduct(ProductDTO productDTO);
    ProductResponse getProductById(Integer id);
    List<Product> getAllProducts();
    ProductResponse deleteProductById(Integer id);
    ProductResponse updateProduct(Product product);
}
