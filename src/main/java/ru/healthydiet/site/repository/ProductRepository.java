package ru.healthydiet.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.healthydiet.site.model.products.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
