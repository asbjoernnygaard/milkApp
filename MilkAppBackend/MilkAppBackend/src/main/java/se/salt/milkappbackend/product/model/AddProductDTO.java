package se.salt.milkappbackend.product.model;

import lombok.Data;

@Data
public class AddProductDTO {
    String name;
    String type;
    Integer storage;
    String id;
}
