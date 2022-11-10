package com.joaovanzuita.deliveryapi.DTO.input;

import javax.validation.constraints.NotBlank;

public class AddresseeInputDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String publicPlace;

    @NotBlank
    private String number;

    @NotBlank
    private String complement;

    @NotBlank
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
