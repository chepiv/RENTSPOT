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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "marked")
    private boolean marked;
    @Column(name = "Date")
    private Date date;
    @Column(name = "photo")
    private BlobType photo;
    @Column(name = "header",nullable = false)
    private String header;
    @Column(name = "description",nullable = false)
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
    @JoinColumn(name = "landlord_userid")
    private Landlord landlord;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "renter_userid")
    private Renter renter;

    @Transient
    private String csvParam;
    @Transient
    private Long reserveId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getCsvParam() {
        return csvParam;
    }

    public void setCsvParam(String csvParam) {
        this.csvParam = csvParam;
    }

    public Long getReserveId() {
        return reserveId;
    }

    public void setReserveId(Long reserveId) {
        this.reserveId = reserveId;
    }
}
