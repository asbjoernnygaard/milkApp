package se.salt.milkappbackend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.salt.milkappbackend.product.model.AddProductDTO;
import se.salt.milkappbackend.product.model.MilkTypeDTO;
import se.salt.milkappbackend.product.model.ProductListResDTO;
import se.salt.milkappbackend.product.model.Product;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/milkapi/products")
@CrossOrigin
public class Controller {

    @Autowired
    ProductService service;

    @GetMapping("/all")
    ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = service.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping
    ResponseEntity<ProductListResDTO> getPaginatedProducts(@RequestParam(required = false, defaultValue = "0") int page,
                                                           @RequestParam(required = false, defaultValue = "") String query,
                                                           @RequestParam(required = false, defaultValue = "") String... types) {

        Set<String> typesSet = new HashSet<>(List.of(types));
        ProductListResDTO products = service.getPaginatedProducts(page, typesSet, query);

        if (products.getProducts().isEmpty() && !products.isFirst()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(products);

    }

    @GetMapping("/{productId}")
    ResponseEntity<?> getProductById(@PathVariable String productId) {
        try {
            Product product = service.getProductById(productId);
            return ResponseEntity.ok(product);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity<?> secretWayToPostAllProducts(@RequestBody List<AddProductDTO> dtoList) {
        try {
            service.postProducts(dtoList);
            return ResponseEntity.created(URI.create("milkapi/productId")).build();
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }


    @GetMapping("/types")
    ResponseEntity<List<MilkTypeDTO>> getAllMilktypes() {
        List<MilkTypeDTO> types = service.getAllMilktypes();
        return ResponseEntity.ok(types);
    }

}
