package ru.healthydiet.site.contoller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.healthydiet.site.DTO.ProductDTO;
import ru.healthydiet.site.model.Product;
import ru.healthydiet.site.model.ProductContent;
import ru.healthydiet.site.repository.ProductRepo;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MenuController {

    @Autowired
    private final ProductRepo productRepo;
    private final ObjectMapper objectMapper;

    @PostMapping("/api/add")
    public void addProduct(@RequestBody ProductDTO productDTO) {
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

    @SneakyThrows
    @GetMapping("/api/getProductContent")
    public String getProductContent(@RequestParam Integer id)
    {
        if (!productRepo.existsById(id)) {
            return "No such product";
        }
        return objectMapper.writeValueAsString(productRepo.findById(id).get().getProductContent());
    }

    @GetMapping("/api/getAll")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @DeleteMapping("/api/delete")
    public String deleteProduct(@RequestParam Integer id) {
        if (!productRepo.existsById(id)) {
            return "No such product";
        }
        productRepo.deleteById(id);
        log.info("Delete product with id: " + id);
        return "Delete product with id: " + id;
    }

    @PutMapping("/api/update")
    public String updateProduct(@RequestBody Product product) {
        if (!productRepo.existsById(product.getId())) {
            return "No such product";
        }
        log.info("Update product: " + productRepo.save(product));
        return "Update product: " + productRepo.findById(product.getId());
    }
}
