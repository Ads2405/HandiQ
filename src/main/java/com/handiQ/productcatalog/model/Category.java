package com.handiQ.productcatalog.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();

    public Category(){}
    @JsonCreator
    public Category(@JsonProperty String name){
        this.name = name;
    }
}
