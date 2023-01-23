package se.salt.milkappbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    String id;

    @Column
    String name;

    @Column
    String type;

    @Column
    Integer storage;

}
