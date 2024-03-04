package com.nidaonder;

import com.nidaonder.entity.CommercialCustomer;
import com.nidaonder.entity.Customer;
import com.nidaonder.entity.Invoice;
import com.nidaonder.entity.Order;
import com.nidaonder.manager.CustomerManager;
import com.nidaonder.manager.InvoiceManager;
import com.nidaonder.manager.OrderManager;

import java.math.BigDecimal;
import java.time.LocalDate;
public class App 
{
    public static void main( String[] args ) {

        OrderManager orderManager = new OrderManager();
        CustomerManager customerManager = new CustomerManager();
        InvoiceManager invoiceManager = new InvoiceManager();

        invoiceManager.orderManager = orderManager;
        orderManager.invoiceManager = invoiceManager;
        orderManager.customerManager = customerManager;
        customerManager.orderManager = orderManager;

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
        Customer customer7 = new CommercialCustomer(
                81L, "Enterprice Edition", LocalDate.of(2023,11,4), "movie"
        );

        customerManager.addCustomer(customer1);
        customerManager.addCustomer(customer2);
        customerManager.addCustomer(customer3);
        customerManager.addCustomer(customer4);
        customerManager.addCustomer(customer5);
        customerManager.addCustomer(customer6);
        customerManager.addCustomer(customer7);

        Order order1 = new Order(1L, 2L, LocalDate.of(2023,7,4), 1L);
        Order order2 = new Order(2L, 4L, LocalDate.of(2022, 6, 5), 2L);
        Order order3 = new Order(3L, 3L, LocalDate.of(2023, 5, 5), 3L);
        Order order4 = new Order(4L, 2L, LocalDate.of(2023,6,11), 4L);
        Order order5 = new Order(5L, 1L, LocalDate.of(2020, 6, 11), 5L);
        Order order6 = new Order(6L, 4L, LocalDate.of(2023,6,12), 6L);
        Order order7 = new Order(79L, 81L, LocalDate.of(2023,6,12), 7L);

        orderManager.addOrder(order1);
        orderManager.addOrder(order2);
        orderManager.addOrder(order3);
        orderManager.addOrder(order4);
        orderManager.addOrder(order5);
        orderManager.addOrder(order6);
        orderManager.addOrder(order7);

        Invoice invoice1 = new Invoice(1L, new BigDecimal("99.90"), 1L, 2L);
        Invoice invoice2 = new Invoice(2L, new BigDecimal("109.99"), 2L, 2L);
        Invoice invoice3 = new Invoice(3L, new BigDecimal("1599.99"), 6L, 4L);
        Invoice invoice4 = new Invoice(4L, new BigDecimal("2099.00"), 5L, 1L);
        Invoice invoice5 = new Invoice(5L, new BigDecimal("5000.00"), 4L, 2L);
        Invoice invoice6 = new Invoice(6L, new BigDecimal("500.00"), 3L, 3L);
        Invoice invoice7 = new Invoice(8L, new BigDecimal("749.00"), 79L, 81L);


        invoiceManager.addInvoice(invoice1);
        invoiceManager.addInvoice(invoice2);
        invoiceManager.addInvoice(invoice3);
        invoiceManager.addInvoice(invoice4);
        invoiceManager.addInvoice(invoice5);
        invoiceManager.addInvoice(invoice6);
        invoiceManager.addInvoice(invoice7);

        System.out.println("\nCUSTOMERS;");
        customerManager.listAllCustomers();

        System.out.println("\nORDERS;");
        orderManager.listAllOrders();

        System.out.println("\nINVOICES;");
        invoiceManager.listAllInvoices();

        System.out.println("\nCustomers containing the letter C;");
        customerManager.listCustomerWithC();

        System.out.println("\nTotal invoices of customers registered in June;");
        invoiceManager.sumJuneCustomerInvoices();

        System.out.println("\nInvoices over 1500 TL registered in the system;");
        invoiceManager.printInvoicesOver1500();

        System.out.println("\nAverage of invoices over 1500 TL");
        invoiceManager.printAverageOfInvoicesOver1500();

        System.out.println("\nNames of customers with invoices under 500 TL registered in the system;");
        customerManager.printCustomerWhichInvoiceUnder500();
    }
}
