package se.salt.milkappbackend.product.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se.salt.milkappbackend.product.model.Product;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    int pageSize = 12;

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

    public Page<Product> getPaginatedProducts(int page) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return repo.findAll(pageable);
    }

    public Page<Product> getProductByType(int page, Set<String> type) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return repo.findAllProductsByTypes(type, pageable);
    }

    public Page<Product> getProductByQuery(int page, String query) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return repo.findAllByNameContainingIgnoreCase(query, pageable);

    }

    public Page<Product> getProductByQueryAndType(int page, Set<String> type, String query) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return repo.findAllByTypesAndNameContaining(
                type.stream().map(String::toLowerCase).collect(Collectors.toSet()),
                query.toLowerCase(),
                pageable);
    }
}
