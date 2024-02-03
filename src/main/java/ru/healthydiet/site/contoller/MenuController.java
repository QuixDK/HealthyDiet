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
@RequestMapping("/api/product")
public class MenuController {

    private final ProductServiceImpl productServiceImpl;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @PostMapping("/")
    public String createProduct(@RequestBody ProductDTO productDTO) {
        return objectMapper.writeValueAsString(productServiceImpl.saveNewProduct(productDTO));
    }

    @SneakyThrows
    @GetMapping("/")
    public String getProduct(@RequestParam Integer id) {
        return objectMapper.writeValueAsString(productServiceImpl.getProductById(id));
    }

    @SneakyThrows
    @GetMapping("/")
    public String getAllProducts() {
        return objectMapper.writeValueAsString(productServiceImpl.getAllProducts());
    }

    @SneakyThrows
    @DeleteMapping("/")
    public String deleteProduct(@RequestParam Integer id) {
        return objectMapper.writeValueAsString(productServiceImpl.deleteProductById(id));
    }

    @SneakyThrows
    @PutMapping("/")
    public String updateProduct(@RequestBody Product product) {
        return objectMapper.writeValueAsString(productServiceImpl.updateProduct(product));
    }
}
