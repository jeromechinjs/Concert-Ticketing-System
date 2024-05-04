package model;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class VIPTicket extends Ticket{

    private int seatNo;

    public VIPTicket(int seatNo) {
        this.seatNo = seatNo;
    }
    
    public VIPTicket(int seatNo, int price, TicketInfo ticketInfo, int availableTicket) {
        super(price, ticketInfo, availableTicket);
        this.seatNo = seatNo;
        setDistFromStage("Moderate");
    }
    
    public VIPTicket(int price, TicketInfo ticketInfo, int availableTicket) {
        super(price, ticketInfo, availableTicket);
        setDistFromStage("Moderate");
    }

    @Override
    public String toString() {
        return "2. --- VIP Zone Area(Sitting Zone) ---"
                + "\nAvailable Seat: " + getAvailableTicket()
                +"\nPrice of this area: " + getPrice()
                + "\nDistance from stage: "+ getDistFromStage()+"\n";
    }
    
    
    @Override
    public void DisplayTicket(int option){
        if (super.getTotalQuantity() !=0) {
            
            for (int i = 0; i < super.getTotalQuantity(); i++) {
                System.out.println("\n===============================");
                System.out.println(super.getTicketInfo().getArtist()+ " Concert");
                System.out.println("------VIP ZONE---------");
                System.out.println("SEAT NO: "+ seatNo);
                System.out.println("RM"+super.getPrice());
                System.out.println(super.getTicketInfo().getDate()+ "   "+super.getTicketInfo().getVenue());
                System.out.println("===============================");
                
                seatNo++;
            }
        }
    }

}
