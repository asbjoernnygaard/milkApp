package se.salt.milkappbackend.product.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.salt.milkappbackend.product.model.Product;

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
