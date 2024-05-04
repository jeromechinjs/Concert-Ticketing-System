/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class RockZoneTicket extends Ticket {

    public RockZoneTicket() {
    }

    public RockZoneTicket(int price, TicketInfo ticketInfo, int availableTicket) {
        super(price, ticketInfo, availableTicket);
        setDistFromStage("Close");
    }

    @Override
    public String toString() {
        return "1. --- Rock Zone Area(Standing Zone) ---" +
                "\nAvailable Seat: " + super.getAvailableTicket() +
                "\nPrice of this area: " + super.getPrice() +
                "\nDistance from stage: " + super.getDistFromStage() + "\n";
    }

    @Override
    public void DisplayTicket(int option) {
        if (super.getTotalQuantity() != 0) {
            for (int i = 0; i < super.getTotalQuantity(); i++) {
                System.out.println("\n===============================");
                System.out.println(super.getTicketInfo().getArtist() + " Concert");
                System.out.println("-------ROCK ZONE--------");
                System.out.println("SEAT NO: " + "-");
                System.out.println("RM" + getPrice());
                System.out.println(super.getTicketInfo().getDate() + "   " + super.getTicketInfo().getVenue());
                System.out.println("===============================");
            }
        }
    }

}
