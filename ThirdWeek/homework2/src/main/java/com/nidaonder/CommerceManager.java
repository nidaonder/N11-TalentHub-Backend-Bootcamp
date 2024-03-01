package com.nidaonder;

import com.nidaonder.entity.Customer;
import com.nidaonder.entity.Invoice;
import com.nidaonder.entity.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        } else {
            System.out.println("The customer with this id already exists.");
        }
    }

    public void addOrder(Order order) {
        boolean exists = orderSet.stream().anyMatch(o -> o.getId().equals(order.getId()));
        if (!exists) {
            orderSet.add(order);
        } else {
            System.out.println("The order with this id already exists.");
        }
    }

    public void addInvoice(Invoice invoice) {
        if (!invoiceMap.containsKey(invoice.getId())) {
            invoiceMap.put(invoice.getId(), invoice);
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

    public void listCustomerWithC(){
        List<Customer> filteredList = customerList.stream()
                .filter(customer -> customer.getFullName().toLowerCase().contains("c"))
                .collect(Collectors.toList());
        filteredList.forEach(customer -> System.out.println(customer.getFullName()));
    }

    public void sumJuneCustomerInvoices() {
        List<Long> customerIdInJune = customerList.stream()
                .filter(customer -> customer.getRegistrationDate().getMonth() == Month.JUNE)
                .map(Customer::getId)
                .collect(Collectors.toList());
        List<Long> orderIdForJuneCustomer = orderSet.stream()
                .filter(order -> customerIdInJune.contains(order.getCustomerId()))
                .map(Order::getId)
                .collect(Collectors.toList());

        BigDecimal totalAmount = invoiceMap.values().stream()
                .filter(invoice -> orderIdForJuneCustomer.contains(invoice.getOrderId()))
                .map(Invoice::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(totalAmount);
    }

    public void listInvoicesOver1500(){
        invoiceMap.values().stream()
                .filter(invoice -> invoice.getAmount().compareTo(new BigDecimal("1500.00")) > 0)
                .forEach(System.out::println);
    }

    public void averageOfInvoicesOver1500(){
        List<BigDecimal> filteredAmountList = invoiceMap.values().stream()
                .map(Invoice::getAmount)
                .filter(amount -> amount.compareTo(new BigDecimal("1500.00")) > 0)
                .collect(Collectors.toList());
        int size = filteredAmountList.size();
        BigDecimal totalAmount = filteredAmountList.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal averageOfAmount = totalAmount.divide(new BigDecimal(size), 2, RoundingMode.HALF_UP);
        System.out.println(averageOfAmount);
    }

    public void customerOfInvoiceUnder500(){
        List<Long> filteredInvoicesOrderId = invoiceMap.values().stream()
                .filter(invoice -> invoice.getAmount().compareTo(new BigDecimal("500.00")) < 0)
                .map(Invoice::getOrderId)
                .collect(Collectors.toList());
        List<Long> filteredCustomerId = orderSet.stream()
                .filter(order -> filteredInvoicesOrderId.contains(order.getId()))
                .map(Order::getCustomerId)
                .collect(Collectors.toList());

        customerList.stream()
                .filter(customer -> filteredCustomerId.contains(customer.getId()))
                .forEach(customer -> System.out.println(customer.getFullName()));
    }
}
