package ru.healthydiet.site.service.products;

import ru.healthydiet.site.dto.ProductDto;
import ru.healthydiet.site.model.products.Product;
import ru.healthydiet.site.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductDto productDTO);
    ProductResponse getProductById(Integer id);
    List<Product> getAllProducts();
    ProductResponse deleteProductById(Integer id);
    ProductResponse updateProduct(Product product);
}
