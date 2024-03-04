package com.nidaonder.manager;

import com.nidaonder.entity.Invoice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InvoiceManager {

    public OrderManager orderManager;

    private final Map<Long, Invoice> invoiceMap = new HashMap<>();

    public InvoiceManager(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public InvoiceManager() {
    }

    public Map<Long, Invoice> getInvoiceMap() {
        return invoiceMap;
    }

    public void addInvoice(Invoice invoice) {
        if (!invoiceMap.containsKey(invoice.getId())) {
            invoiceMap.put(invoice.getId(), invoice);
        } else {
            System.out.println("The invoice with this id already exists.");
        }
    }

    public void listAllInvoices(){
        invoiceMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }


    public void sumJuneCustomerInvoices() {
        BigDecimal totalAmount = invoiceMap.values().stream()
                .filter(invoice -> orderManager.orderIdForJuneCustomer().contains(invoice.getOrderId()))
                .map(Invoice::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(totalAmount);
    }

    public List<BigDecimal> getInvoicesOver1500() {
        return invoiceMap.values().stream()
                .map(Invoice::getAmount)
                .filter(amount -> amount.compareTo(new BigDecimal("1500.00")) > 0)
                .collect(Collectors.toList());
    }

    public void printInvoicesOver1500(){
        List<BigDecimal> filteredAmountList = getInvoicesOver1500();

        filteredAmountList.forEach(System.out::println);
    }

    public void printAverageOfInvoicesOver1500(){
        List<BigDecimal> filteredAmountList = getInvoicesOver1500();
        int size = filteredAmountList.size();
        BigDecimal totalAmount = filteredAmountList.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal averageOfAmount = totalAmount.divide(new BigDecimal(size), 2, RoundingMode.HALF_UP);
        System.out.println(averageOfAmount);
    }

    public List<Long> getOrderIdWhichInvoiceUnder500() {
        return invoiceMap.values().stream()
                .filter(invoice -> invoice.getAmount().compareTo(new BigDecimal("500.00")) < 0)
                .map(Invoice::getOrderId)
                .collect(Collectors.toList());
    }
}
