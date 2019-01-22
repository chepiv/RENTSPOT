package com.chepiv.rentspot.domain_core;

import javax.persistence.*;
import java.util.List;

/**
 * Created by chepiv on 20.01.2019.
 * Contact: chepurin.ivan@gmail.com
 * Github:chepiv
 */
@Entity
@Table(name = "Parameter")
public class Parameter {
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Value")
    private String value;
    @ManyToMany(mappedBy = "parameters")
    private List<Offer> offers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
