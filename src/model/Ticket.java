package model;/*
              * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
              * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
              */

/**
 *
 * @author User
 */
public abstract class Ticket {
    private int price;
    private int quantity;
    private int TotalQuantity = 0;
    private TicketInfo ticketInfo;
    private int availableTicket;
    private String distFromStage;

    public Ticket() {
    }

    public Ticket(int price, TicketInfo ticketInfo, int availableTicket) {
        this.price = price;
        this.ticketInfo = ticketInfo;
        this.availableTicket = availableTicket;
    }

    public int getTotalQuantity() {
        return TotalQuantity;
    }

    public void setTotalQuantity(int TotalQuantity) {
        this.TotalQuantity = TotalQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDistFromStage() {
        return distFromStage;
    }

    public void setDistFromStage(String distFromStage) {
        this.distFromStage = distFromStage;
    }

    public Ticket(TicketInfo ticketInfo) {
        this.ticketInfo = ticketInfo;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TicketInfo getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(TicketInfo ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public int getAvailableTicket() {
        return availableTicket;
    }

    public void setAvailableTicket(int availableTicket) {
        this.availableTicket = availableTicket;
    }

    @Override
    public abstract String toString();

    public abstract void DisplayTicket(int option);

}
