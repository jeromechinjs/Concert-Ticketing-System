/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class NormalZoneTicket extends Ticket{
    private int seatNo ;

    public NormalZoneTicket(int seatNo) {
        this.seatNo = seatNo;
    }

    public NormalZoneTicket(int seatNo, int price, TicketInfo ticketInfo, int availableTicket) {
        super(price, ticketInfo, availableTicket);
        this.seatNo = seatNo;
        setDistFromStage("Far");
    }


    @Override
    public String toString() {
        return "3. --- Normal Zone Area(Sitting Zone) ---"
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
                System.out.println("------NORMAL ZONE---------");
                System.out.println("SEAT NO: "+ seatNo);
                System.out.println("RM"+super.getPrice());
                System.out.println(super.getTicketInfo().getDate()+ "   "+super.getTicketInfo().getVenue());
                System.out.println("===============================");
                seatNo++;
            }
        }
    }
    
}
