package se.salt.milkappbackend.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.salt.milkappbackend.product.model.Product;

public interface IProductRepository extends JpaRepository<Product, String> {
}
