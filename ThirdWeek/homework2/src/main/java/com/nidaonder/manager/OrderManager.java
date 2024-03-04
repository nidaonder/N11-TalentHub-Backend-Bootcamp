package com.nidaonder.manager;

import com.nidaonder.entity.Order;

import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderManager {

    public CustomerManager customerManager;

    public InvoiceManager invoiceManager;

    private final Set<Order> orderSet = new HashSet<>();

    public OrderManager(CustomerManager customerManager, InvoiceManager invoiceManager) {
        this.customerManager = customerManager;
        this.invoiceManager = invoiceManager;
    }

    public OrderManager() {
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void addOrder(Order order) {
        boolean exists = orderSet.stream().anyMatch(o -> o.getId().equals(order.getId()));
        if (!exists) {
            orderSet.add(order);
        } else {
            System.out.println("The order with this id already exists.");
        }
    }

    public void listAllOrders(){
        orderSet.forEach(order -> System.out.println(order.toString()));
    }

    public List<Long> orderIdForJuneCustomer() {
        return orderSet.stream()
                .filter(order -> customerManager.customerIDsRegisteredInJune().contains(order.getCustomerId()))
                .map(Order::getId)
                .collect(Collectors.toList());
    }

    public List<Long> customerIdWhichOrdersInvoiceUnder500() {
        return orderSet.stream()
                .filter(order -> invoiceManager.getOrderIdWhichInvoiceUnder500().contains(order.getId()))
                .map(Order::getCustomerId)
                .collect(Collectors.toList());
    }

    public List<Long> getCustomerIdWhichIsOrderedInJune(){
        return orderSet.stream()
                .filter(order -> order.getOrderDate().getMonth() == Month.JUNE)
                .map(Order::getCustomerId)
                .collect(Collectors.toList());
    }
}
