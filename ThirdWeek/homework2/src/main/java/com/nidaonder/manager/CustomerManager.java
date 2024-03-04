package com.nidaonder.manager;

import com.nidaonder.entity.Customer;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerManager {

    public OrderManager orderManager;
    
    private final List<Customer> customerList = new ArrayList<>();

    public CustomerManager(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public CustomerManager() {
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void addCustomer(Customer customer) {
        boolean exists = customerList.stream()
                .anyMatch(c -> c.getId().equals(customer.getId()));
        if (!exists) {
            customerList.add(customer);
        } else {
            System.out.println("The customer with this id already exists.");
        }
    }
    
    public void listAllCustomers(){
        customerList.forEach(customer -> System.out.println(customer.toString()));
    }

    public void listCustomerWithC(){
        List<Customer> filteredList = customerList.stream()
                .filter(customer -> customer.getFullName().toLowerCase().contains("c"))
                .collect(Collectors.toList());
        filteredList.forEach(customer -> System.out.println(customer.getFullName()));
    }

    public List<Long> customerIDsRegisteredInJune() {
        return customerList.stream()
                .filter(customer -> customer.getRegistrationDate().getMonth() == Month.JUNE)
                .map(Customer::getId)
                .collect(Collectors.toList());
    }

    public void printCustomerWhichInvoiceUnder500(){
        customerList.stream()
                .filter(customer -> orderManager.customerIdWhichOrdersInvoiceUnder500().contains(customer.getId()))
                .forEach(customer -> System.out.println(customer.getFullName()));
    }
}