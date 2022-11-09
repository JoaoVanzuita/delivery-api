package com.joaovanzuita.deliveryapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Addressee {

    @Column(name = "addressee_name")
    private String name;

    @Column(name = "addressee_public_place")
    private String publicPlace;

    @Column(name = "addressee_number")
    private String number;

    @Column(name = "addressee_complement")
    private String complement;

    @Column(name = "addressee_district")
    private String district;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
