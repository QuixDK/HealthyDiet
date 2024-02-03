package ru.healthydiet.site.service.products;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.healthydiet.site.dto.ProductDto;
import ru.healthydiet.site.model.products.Product;
import ru.healthydiet.site.model.products.ProductContent;
import ru.healthydiet.site.repository.ProductRepository;
import ru.healthydiet.site.response.ProductResponse;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductDto productDTO) {
        Product product = Product.builder()
                .name(productDTO.getName())
                .productContent(ProductContent.builder()
                        .calories(productDTO.getCalories())
                        .proteins(productDTO.getProteins())
                        .fats(productDTO.getFats())
                        .carbohydrates(productDTO.getCarbohydrates())
                        .fibers(productDTO.getFibers())
                        .sugar(productDTO.getSugar())
                        .sodium(productDTO.getSodium())
                        .cuprum(productDTO.getCuprum())
                        .iron(productDTO.getIron())
                        .folate(productDTO.getFolate())
                        .potassium(productDTO.getPotassium())
                        .magnesium(productDTO.getMagnesium())
                        .thiamine(productDTO.getThiamine())
                        .riboflavin(productDTO.getRiboflavin())
                        .vitaminB6(productDTO.getVitaminB6())
                        .vitaminC(productDTO.getVitaminC())
                        .vitaminE(productDTO.getVitaminE())
                        .build())
                .build();
        log.info("Add new product: " + productRepository.save(product));
        return ProductResponse.builder()
                .product(product)
                .message("Success created Product")
                .status(200)
                .build();
    }

    public ProductResponse getProductById(Integer id) {
        if (!productRepository.existsById(id)) {
            return ProductResponse.builder()
                    .product(null)
                    .message("No such product")
                    .status(404)
                    .build();
        }
        Product product = productRepository.findById(id).get();
        return ProductResponse.builder()
                .product(product)
                .message("Success created Product")
                .status(200)
                .build();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductResponse deleteProductById(Integer id) {
        if (!productRepository.existsById(id)) {
            return ProductResponse.builder()
                    .product(null)
                    .message("No such product")
                    .status(404)
                    .build();
        }
        productRepository.deleteById(id);
        log.info("Delete product with id: " + id);
        return ProductResponse.builder()
                .product(null)
                .message("Delete product with id: " + id)
                .status(200)
                .build();
    }

    public ProductResponse updateProduct(Product product) {
        if (!productRepository.existsById(product.getId())) {
            return ProductResponse.builder()
                    .product(null)
                    .message("No such product")
                    .status(404)
                    .build();
        }
        log.info("Update product: " + productRepository.save(product));
        return ProductResponse.builder()
                .product(product)
                .message("Success updated product")
                .status(200)
                .build();
    }
}
