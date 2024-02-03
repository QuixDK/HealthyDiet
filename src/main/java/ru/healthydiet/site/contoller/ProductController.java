package ru.healthydiet.site.contoller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.healthydiet.site.DTO.ProductDTO;
import ru.healthydiet.site.model.Product;
import ru.healthydiet.site.response.ProductResponse;
import ru.healthydiet.site.service.ProductServiceImpl;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductServiceImpl productServiceImpl;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @PostMapping("/")
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(objectMapper.writeValueAsString(productServiceImpl.saveNewProduct(productDTO)));
    }

    @SneakyThrows
    @GetMapping("/")
    public ResponseEntity<String> getProduct(@RequestParam Integer id) {
        ProductResponse productResponse = productServiceImpl.getProductById(id);
        if (productResponse.getStatus() == 200) {
            return ResponseEntity.ok(objectMapper.writeValueAsString(productResponse));
        }
        return ResponseEntity.status(404).body(objectMapper.writeValueAsString(productResponse));
    }

    @SneakyThrows
    @GetMapping("/all")
    public ResponseEntity<String> getAllProducts() {
        return ResponseEntity.ok(objectMapper.writeValueAsString(productServiceImpl.getAllProducts()));
    }

    @SneakyThrows
    @DeleteMapping("/")
    public ResponseEntity<String> deleteProduct(@RequestParam Integer id) {
        ProductResponse productResponse = productServiceImpl.deleteProductById(id);
        if (productResponse.getStatus() == 200) {
            return ResponseEntity.ok(objectMapper.writeValueAsString(productResponse));
        }
        return ResponseEntity.status(404).body(objectMapper.writeValueAsString(productResponse));
    }

//    @SneakyThrows
//    @PutMapping("/")
//    public String updateProduct(@RequestBody Product product) {
//        return objectMapper.writeValueAsString(productServiceImpl.updateProduct(product));
//    }
}
