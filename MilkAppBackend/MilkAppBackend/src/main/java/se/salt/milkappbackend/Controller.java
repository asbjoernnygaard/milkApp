package se.salt.milkappbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.salt.milkappbackend.model.AddProductDTO;
import se.salt.milkappbackend.model.Product;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/milkapi")
@CrossOrigin
public class Controller {

    @Autowired
    ProductService service;

    @GetMapping
    ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = service.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    ResponseEntity<?> getProductByid(@PathVariable String productId) {
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

}
