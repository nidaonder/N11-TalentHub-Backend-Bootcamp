package com.nidaonder;

import com.nidaonder.entity.Customer;
import com.nidaonder.entity.Invoice;
import com.nidaonder.entity.Order;

import java.math.BigDecimal;
import java.time.LocalDate;
public class App 
{
    public static void main( String[] args ) {

        CommerceManager manager = new CommerceManager();

        Customer customer1 = new Customer(
                1L, "Nida Onder", LocalDate.of(2020, 1, 3)
        );
        Customer customer2 = new Customer(
                2L, "Batuhan Diril", LocalDate.of(2023, 6, 10)
        );
        Customer customer3 = new Customer(
                3L, "Tugba Gultekin", LocalDate.of(2022,6,1)
        );
        Customer customer4 = new Customer(
                4L, "Ali Gultekin", LocalDate.of(2022, 5, 4)
        );

        Customer customer5 = new Customer(
                5L, "Ceyda Aydin", LocalDate.of(2024,1,16)
        );

        Customer customer6 = new Customer(
                6L, "Cansu Yildiz", LocalDate.of(2023,11,4)
        );

        manager.addCustomer(customer1);
        manager.addCustomer(customer2);
        manager.addCustomer(customer3);
        manager.addCustomer(customer4);
        manager.addCustomer(customer5);
        manager.addCustomer(customer6);

        Order order1 = new Order(1L, 2L, LocalDate.of(2023,7,4));
        Order order2 = new Order(2L, 4L, LocalDate.of(2022, 6, 5));
        Order order3 = new Order(3L, 3L, LocalDate.of(2023, 5, 5));
        Order order4 = new Order(4L, 2L, LocalDate.of(2023,6,11));
        Order order5 = new Order(5L, 1L, LocalDate.of(2020, 6, 11));
        Order order6 = new Order(6L, 4L, LocalDate.of(2023,6,12));

        manager.addOrder(order1);
        manager.addOrder(order2);
        manager.addOrder(order3);
        manager.addOrder(order4);
        manager.addOrder(order5);
        manager.addOrder(order6);

        Invoice invoice1 = new Invoice(1L, new BigDecimal("99.90"), 1L);
        Invoice invoice2 = new Invoice(2L, new BigDecimal("109.99"), 2L);
        Invoice invoice3 = new Invoice(3L, new BigDecimal("1599.99"), 6L);
        Invoice invoice4 = new Invoice(4L, new BigDecimal("2099.00"), 5L);
        Invoice invoice5 = new Invoice(5L, new BigDecimal("5000.00"), 4L);
        Invoice invoice6 = new Invoice(6L, new BigDecimal("500.00"), 3L);
        Invoice invoice7 = new Invoice(7L, new BigDecimal("90.90"), 3L);


        manager.addInvoice(invoice1);
        manager.addInvoice(invoice2);
        manager.addInvoice(invoice3);
        manager.addInvoice(invoice4);
        manager.addInvoice(invoice5);
        manager.addInvoice(invoice6);
        manager.addInvoice(invoice7);

        System.out.println("\nCUSTOMERS;");
        manager.listAllCustomers();

        System.out.println("\nORDERS;");
        manager.listAllOrders();

        System.out.println("\nINVOICES;");
        manager.listAllInvoices();

        System.out.println("\nCustomers containing the letter C;");
        manager.listCustomerWithC();

        System.out.println("\nTotal invoices of customers registered in June;");
        manager.sumJuneCustomerInvoices();

        System.out.println("\nInvoices over 1500 TL registered in the system;");
        manager.listInvoicesOver1500();

        System.out.println("\nAverage of invoices over 1500 TL");
        manager.averageOfInvoicesOver1500();

        System.out.println("\nNames of customers with invoices under 500 TL registered in the system;");
        manager.customerOfInvoiceUnder500();
    }
}
