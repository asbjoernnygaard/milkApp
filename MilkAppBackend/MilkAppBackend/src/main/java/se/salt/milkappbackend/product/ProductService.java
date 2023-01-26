package se.salt.milkappbackend.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se.salt.milkappbackend.product.model.AddProductDTO;
import se.salt.milkappbackend.product.model.MilkTypeDTO;
import se.salt.milkappbackend.product.model.ProductListResDTO;
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

    // TODO: Reconsider, unnecessary overhead
    public List<MilkTypeDTO> getAllMilktypes() {
        List<Product> productList = getAllProducts();
        Set<String> productTypes = new HashSet<>();
        productList.forEach(product -> productTypes.add(product.getType()));
        return productTypes.stream().map(MilkTypeDTO::new).toList();
    }

    public ProductListResDTO getPaginatedProducts(int page, Set<String> type, String query) {
        Page<Product> products = getPaginatedProductsController(page, type, query);
        ProductListResDTO dto = mapper.map(products, ProductListResDTO.class);
        dto.setProducts(products.getContent());
        return dto;
    }

    public Page<Product> getPaginatedProductsController(int page, Set<String> type, String query) {
        // No filter
        if (type.isEmpty() && query.isEmpty()){
            return repo.getPaginatedProducts(page);
        }

        // Type
        if (query.isEmpty()) {
            return repo.getProductByType(page, type);
        }

        // Query
        if(type.isEmpty()) {
            return repo.getProductByQuery(page, query);
        }

        // Type and Query
        return repo.getProductByQueryAndType(page, type, query);
    }
}
