package com.nidaonder.entity;

import com.nidaonder.enums.CustomerType;

import java.time.LocalDate;

public class CommercialCustomer extends Customer{

    private String sector;
    public CommercialCustomer(Long id, String fullName, LocalDate registrationDate, String sector) {
        super(id, fullName, registrationDate, CustomerType.COMMERCIAL_CUSTOMER);
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

}
