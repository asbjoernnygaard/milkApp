package se.salt.milkappbackend.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.salt.milkappbackend.product.model.AddProductDTO;
import se.salt.milkappbackend.product.model.MilkTypeDTO;
import se.salt.milkappbackend.product.model.Product;
import se.salt.milkappbackend.product.repository.ProductRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    ModelMapper mapper = new ModelMapper();

    public List<Product> getAllProducts() {
        return repo.getAllProducts();
    }

    public Product getProductById(String productId) {
        return repo.getProductById(productId);
    }

    public void postProducts(List<AddProductDTO> dtoList) {
        List<Product> products =  Arrays.asList(mapper.map(dtoList, Product[].class));
        repo.postProducts(products);
    }

    // This is emberassing, there's far better ways to do this
    // However due to the small size of the task I'd just like to get going
    public List<MilkTypeDTO> getAllMilktypes() {
        List<Product> productList = getAllProducts();
        Set<String> productTypes = new HashSet<>();
        productList.forEach(product -> productTypes.add(product.getType()));
        return productTypes.stream().map(MilkTypeDTO::new).toList();
    }
}
