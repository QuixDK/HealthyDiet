package ru.healthydiet.site.contoller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.healthydiet.site.DTO.ProductDTO;
import ru.healthydiet.site.model.Product;
import ru.healthydiet.site.service.ProductServiceImpl;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MenuController {

    private final ProductServiceImpl productServiceImpl;
    private final ObjectMapper objectMapper;

    @PostMapping("/api/add")
    public void addProduct(@RequestBody ProductDTO productDTO) {
        productServiceImpl.saveNewProduct(productDTO);
    }

    @SneakyThrows
    @GetMapping("/api/getProductContent")
    public String getProductContent(@RequestParam Integer id)
    {
        return productServiceImpl.getProductContentById(id);
    }

    @GetMapping("/api/getAll")
    public List<Product> getAllProducts() {
        return productServiceImpl.getAllProducts();
    }

    @DeleteMapping("/api/delete")
    public String deleteProduct(@RequestParam Integer id) {
        return productServiceImpl.deleteProductById(id);
    }

    @PutMapping("/api/update")
    public String updateProduct(@RequestBody Product product) {
        return productServiceImpl.updateProduct(product);
    }
}
