package com.nidaonder.entity;

import com.nidaonder.enums.CustomerType;

import java.time.LocalDate;

public class Customer extends BaseEntity {
    private String fullName;
    private LocalDate registrationDate;

    private CustomerType customerType;

    public Customer(Long id, String fullName, LocalDate registrationDate) {
        super(id);
        this.customerType = CustomerType.PERSONAL_CUSTOMER;
        this.fullName = fullName;
        this.registrationDate = registrationDate;
    }

    public Customer(Long id, String fullName, LocalDate registrationDate, CustomerType customerType) {
        super(id);
        this.fullName = fullName;
        this.registrationDate = registrationDate;
        this.customerType = customerType;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
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
                "fullName='" + fullName + '\'' +
                ", registrationDate=" + registrationDate +
                ", customerType=" + customerType +
                '}';
    }
}