package model;

import java.util.Scanner;

/**
 * Represents a payment made by a customer for a ticket.
 * 
 * @author User
 */
public class Payment {
    private double amount;
    private Customer customer;
    private double totalPayment;
    private Ticket ticket;

    // Getters and setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * Calculates the payment amount based on the ticket price, quantity, and customer discount rate.
     * 
     * @param customer the customer making the payment
     * @param ticket the ticket being purchased
     * @throws IllegalArgumentException if the customer or ticket is null
     */
    public void calculatePayment(Customer customer, Ticket ticket) {
        if (customer == null || ticket == null) {
            throw new IllegalArgumentException("Customer and ticket cannot be null.");
        }
        double discountRate = getDiscountRate(customer);
        if (discountRate < 0.0) {
            throw new IllegalArgumentException("Discount rate cannot be negative.");
        }
        if (ticket.getPrice() < 0.0 || ticket.getQuantity() < 0) {
            throw new IllegalArgumentException("Ticket price and quantity cannot be negative.");
        }
        amount = ticket.getPrice() * ticket.getQuantity() * discountRate;
        totalPayment += amount;
        if (ticket.getAvailableTicket() < 0.0 || ticket.getTotalQuantity() < 0) {
            throw new IllegalArgumentException("Ticket availability and total quantity cannot be negative.");
        }
        ticket.setAvailableTicket(ticket.getAvailableTicket() - ticket.getQuantity());
        ticket.setTotalQuantity(ticket.getTotalQuantity() + ticket.getQuantity());
    }

    /**
     * Gets the discount rate for the given customer.
     * 
     * @param customer the customer
     * @return the discount rate (100.0 for non-VIP customers)
     */
    private double getDiscountRate(Customer customer) {
        return customer instanceof VIPCustomer? ((VIPCustomer) customer).getDiscountRate() : 100.0;
    }

    /**
     * Deducts the payment amount from the customer's wallet balance.
     * 
     * @param customer the customer
     * @throws IllegalArgumentException if the customer is null
     */
    public void deductWalletBalance(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        Scanner scanner = new Scanner(System.in);
        while (customer.getWalletBalance() < totalPayment) {
            System.out.println("Customer wallet balance is insufficient. Please re-enter the wallet balance:");
            customer.setWalletBalance(scanner.nextDouble());
        }
        customer.setWalletBalance(customer.getWalletBalance() - totalPayment);
    }

}