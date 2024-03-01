package com.nidaonder;

import com.nidaonder.entity.Customer;
import com.nidaonder.entity.Order;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Customer customer1 = new Customer(
                1L, "Nida Onder", LocalDate.of(2020, 1, 3
        ));
        Customer customer2 = new Customer(
                2L, "Batuhan Diril", LocalDate.of(2023, 6, 10
        ));
        Customer customer3 = new Customer(
                3L, "Tugba Gultekin", LocalDate.of(2022,6,1
        ));
        Customer customer4 = new Customer(
                4L, "Ali Gultekin", LocalDate.of(2022, 5, 4
        ));

        Order order1 = new Order(1L, 2L, LocalDate.of(2023,7,4));
        Order order2 = new Order(2L, 4L, LocalDate.of(2022, 6, 5));
        Order order3 = new Order(3L, 3L, LocalDate.of(2023, 5, 5));
        Order order4 = new Order(4L, 2L, LocalDate.of(2023,6,11));
    }
}
