package se.salt.milkappbackend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.salt.milkappbackend.model.Product;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    IProductRepository repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(String productId) {
        return repo.findById(productId).orElseThrow();
    }

    public void postProducts(List<Product> products) {
        repo.saveAll(products);
    }
}
