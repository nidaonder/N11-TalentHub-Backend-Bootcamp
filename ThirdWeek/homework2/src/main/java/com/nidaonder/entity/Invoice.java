package com.nidaonder.entity;

import java.math.BigDecimal;

public class Invoice extends BaseEntity {
    private BigDecimal amount;
    private Long orderId;

    public Invoice(Long id, BigDecimal amount, Long orderId) {
        super(id);
        this.amount = amount;
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                super.toString() +
                "amount=" + amount +
                ", orderId=" + orderId +
                '}';
    }
}
