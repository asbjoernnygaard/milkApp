package se.salt.milkappbackend.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.salt.milkappbackend.product.model.Product;

import java.util.Set;


public interface IProductRepository extends JpaRepository<Product, String> {
    Page<Product> findAllByNameContainingIgnoreCase(String query, Pageable page);

    @Query("SELECT p FROM Product p WHERE lower(p.type) IN :types")
    Page<Product> findAllProductsByTypes(@Param("types") Set<String> types, Pageable pageable);

    // CAVEAT: 'lower' loses table indexing, HIGHLY ineffective for large databases
    @Query("SELECT p FROM Product p WHERE lower(p.type) IN :types AND lower(p.name) LIKE %:query%")
    Page<Product> findAllByTypesAndNameContaining(@Param("types") Set<String> types, @Param("query") String query, Pageable pageable);

}
