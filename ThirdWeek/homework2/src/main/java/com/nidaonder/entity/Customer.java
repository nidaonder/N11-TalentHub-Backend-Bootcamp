package com.nidaonder.entity;

import java.time.LocalDate;

public class Customer extends BaseEntity {
    private String fullName;
    private LocalDate registrationDate;

    public Customer(Long id, String fullName, LocalDate registrationDate) {
        super(id);
        this.fullName = fullName;
        this.registrationDate = registrationDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "fullName='" + fullName + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}