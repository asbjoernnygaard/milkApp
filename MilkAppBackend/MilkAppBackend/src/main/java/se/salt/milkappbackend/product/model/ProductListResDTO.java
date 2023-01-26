package se.salt.milkappbackend.product.model;

import lombok.Data;

import java.util.List;

@Data
public class ProductListResDTO {
    // This would typically be its own dto
    List<Product> products;
    int pageSize;
    int totalPages;
    int totalElements;
    int numberOfElements;
    boolean first;
    boolean last;
}
