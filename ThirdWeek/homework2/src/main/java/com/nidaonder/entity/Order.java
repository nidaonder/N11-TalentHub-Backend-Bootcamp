package com.nidaonder.entity;

import java.time.LocalDate;

public class Order extends BaseEntity {
    private LocalDate orderDate;
    private Long customerId;
    private Long invoiceId;

    public Order(Long id, Long customerId, LocalDate orderDate,Long invoiceId ) {
        super(id);
        this.customerId = customerId;
        this.invoiceId = invoiceId;
        this.orderDate = orderDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public String toString() {
        return "Order{" +
                super.toString() +
                "orderDate=" + orderDate +
                ", customerId=" + customerId +
                '}';
    }
}
