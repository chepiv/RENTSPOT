package com.chepiv.rentspot.domain_core;

import org.hibernate.type.BlobType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by chepiv on 20.01.2019.
 * Contact: chepurin.ivan@gmail.com
 * Github:chepiv
 */
@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "marked")
    private boolean marked;
    @Column(name = "Date")
    private Date date;
    @Column(name = "photo")
    private BlobType photo;
    @Column(name = "header")
    private String header;
    @Column(name = "description")
    private String description;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "parameter_offer",
            joinColumns = @JoinColumn(name = "OfferID"),
            inverseJoinColumns = @JoinColumn(name = "ParameterID")
    )
    private List<Parameter> parameters;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "renter_userid")
    private Landlord landlord;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "landlord_userid")
    private Renter renter;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BlobType getPhoto() {
        return photo;
    }

    public void setPhoto(BlobType photo) {
        this.photo = photo;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}