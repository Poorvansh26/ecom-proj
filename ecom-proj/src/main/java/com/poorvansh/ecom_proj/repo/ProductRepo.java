package com.poorvansh.ecom_proj.repo;

import com.poorvansh.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p " +
            "WHERE p.name LIKE CONCAT('%', :keyword, '%') " +
            "OR p.description LIKE CONCAT('%', :keyword, '%') " +
            "OR p.brand LIKE CONCAT('%', :keyword, '%') " +
            "OR p.category LIKE CONCAT('%', :keyword, '%')")
    List<Product> searchProducts(String keyword);
}
