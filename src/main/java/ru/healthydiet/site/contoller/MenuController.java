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
import ru.healthydiet.site.service.ProductService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MenuController {

    private final ProductService productService;
    private final ObjectMapper objectMapper;

    @PostMapping("/api/add")
    public void addProduct(@RequestBody ProductDTO productDTO) {
        productService.saveNewProduct(productDTO);
    }

    @SneakyThrows
    @GetMapping("/api/getProductContent")
    public String getProductContent(@RequestParam Integer id)
    {
        return productService.getProductContent(id);
    }

    @GetMapping("/api/getAll")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/api/delete")
    public String deleteProduct(@RequestParam Integer id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/api/update")
    public String updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
}
