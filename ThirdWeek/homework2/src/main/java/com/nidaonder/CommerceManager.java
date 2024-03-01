package com.nidaonder;

import com.nidaonder.entity.Customer;
import com.nidaonder.entity.Invoice;
import com.nidaonder.entity.Order;

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
        customerList.add(customer);
    }

    public void addOrder(Order order) {
        orderSet.add(order);
    }

    public void addInvoice(Invoice invoice) {
        invoiceMap.put(invoice.getId(), invoice);
    }

    public void listAllCustomers(){
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }
}