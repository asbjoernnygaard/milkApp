package se.salt.milkappbackend.model;

import lombok.Data;

@Data
public class AddProductDTO {
    String name;
    String type;
    Integer storage;
    String id;
}
