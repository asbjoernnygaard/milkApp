package se.salt.milkappbackend;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.salt.milkappbackend.model.AddProductDTO;
import se.salt.milkappbackend.model.Product;
import se.salt.milkappbackend.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public List<Product> getAllProducts() {
        return repo.getAllProducts();
    }

    public Product getProductById(String productId) {
        return repo.getProductById(productId);
    }

    public void postProducts(List<AddProductDTO> dtoList) {
        ModelMapper mapper = new ModelMapper();
        List<Product> products =  Arrays.asList(mapper.map(dtoList, Product[].class));
        repo.postProducts(products);
    }
}
