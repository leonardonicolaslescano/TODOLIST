package com.lescanapp.TODOList.items.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item {
    public Item() {
    }

    @EqualsAndHashCode.Include

    @Id @GeneratedValue
    private Long id;

    public Item(Long id, String name, boolean complete) {
        this.id = id;
        this.name = name;
        this.complete = complete;
    }

    @NotBlank
    private String name;
    private boolean complete;
}
