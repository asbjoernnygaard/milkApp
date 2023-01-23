package se.salt.milkappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.salt.milkappbackend.model.Product;

public interface IProductRepository extends JpaRepository<Product, String> {
}
