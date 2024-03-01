package com.nidaonder;

import com.nidaonder.entity.Customer;
import com.nidaonder.entity.Invoice;
import com.nidaonder.entity.Order;

import java.math.BigDecimal;
import java.util.*;

public class CommerceManager {
    private final List<Customer> customerList = new ArrayList<>();
    private final Set<Order> orderSet = new HashSet<>();
    private final Map<Long, Invoice> invoiceMap = new HashMap<>();

    public List<Customer> getCustomerList() {
        return this.customerList;
    }

    public Set<Order> getOrderSet() {
        return this.orderSet;
    }

    public Map<Long, Invoice> getInvoiceMap() {
        return this.invoiceMap;
    }

    public void addCustomer(Customer customer) {
        boolean exists = customerList.stream()
                .anyMatch(c -> c.getId().equals(customer.getId()));
        if (!exists) {
            customerList.add(customer);
            System.out.println("Customer added successfully");
        } else {
            System.out.println("The customer with this id already exists.");
        }
    }

    public void addOrder(Order order) {
        boolean exists = orderSet.stream().anyMatch(o -> o.getId().equals(order.getId()));
        if (!exists) {
            orderSet.add(order);
            System.out.println(("Order added successfully"));
        } else {
            System.out.println("The order with this id already exists.");
        }
    }

    public void addInvoice(Invoice invoice) {
        if (!invoiceMap.containsKey(invoice.getId())) {
            invoiceMap.put(invoice.getId(), invoice);
            System.out.println("Invoice added successfully");
        } else {
            System.out.println("The invoice with this id already exists.");
        }
    }

    public void listAllCustomers(){
        customerList.forEach(customer -> System.out.println(customer.toString()));
    }

    public void listAllOrders(){
        orderSet.forEach(order -> System.out.println(order.toString()));
    }

    public void listAllInvoices(){
        invoiceMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}