package ru.healthydiet.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.healthydiet.site.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
