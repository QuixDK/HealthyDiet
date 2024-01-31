package ru.healthydiet.site.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.healthydiet.site.DTO.ProductDTO;
import ru.healthydiet.site.model.Product;
import ru.healthydiet.site.model.ProductContent;
import ru.healthydiet.site.repository.ProductRepo;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepo productRepo;

    public void saveNewProduct(ProductDTO productDTO) {
        log.info(
                "Add new product: " + productRepo.save(
                        Product.builder()
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
                                .build())
        );
    }

    public String getProductContentById(Integer id) {
        if (!productRepo.existsById(id)) {
            return "No such product";
        }
        return productRepo.findById(id).get().getProductContent().toString();
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public String deleteProductById(Integer id) {
        if (!productRepo.existsById(id)) {
            return "No such product";
        }
        productRepo.deleteById(id);
        log.info("Delete product with id: " + id);
        return "Delete product with id: " + id;
    }

    public String updateProduct(Product product) {
        if (!productRepo.existsById(product.getId())) {
            return "No such product";
        }
        log.info("Update product: " + productRepo.save(product));
        return "Update product: " + productRepo.findById(product.getId());
    }
}
