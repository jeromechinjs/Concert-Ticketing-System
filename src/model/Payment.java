package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Payment {
    private double amount;
    private Customer customer; 
    private double totalPayment;
    private Ticket ticket;
    
    
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
    
    public void calculatePayment(Customer c, Ticket t){
        double discountRate;
        if (c instanceof VIPCustomer) {
            discountRate = ((VIPCustomer) c).getDiscountRate();
        }
        else{
            discountRate = 100.0;
        }
        amount = t.getPrice()*t.getQuantity()*discountRate;
        totalPayment += amount;
        t.setAvailableTicket(t.getAvailableTicket()-t.getQuantity());
        t.setTotalQuantity(t.getTotalQuantity()+t.getQuantity());
    }
    
    
    public void deductWalletBalance(Customer c){
        c.setWalletBalance(c.getWalletBalance()- totalPayment);
    }
    
    public void displayPaymentBill(Customer c){
        
        System.out.println("-------------------------");
        System.out.println("       Payment Bill       ");
        System.out.println("-------------------------");
        System.out.println("Status: Successfull");
        System.out.println("Total Amount: " +totalPayment);
        System.out.println("Wallet Balance: "+ c.getWalletBalance());
        System.out.println("Buyer Name: "+ c.getName());
        System.out.println("Phone no: "+ c.getPhoneNo());
        System.out.println("-------------------------");
    }
    
}
