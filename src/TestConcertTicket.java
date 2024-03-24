/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Scanner;

public class TestConcertTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Person[] person = new Person[3];
        
        person[0] = new Customer(10000,"Wong Xiao Hei", "0177784557","abcd1234");
        person[1] = new VIPCustomer(15000,"Lee Ai Kun", "0177789557","iamikun");
        person[2] = new Staff("Kok","0199447000","kok123");

        ArrayList<ticketInfo> ticketInfo = new ArrayList<ticketInfo>();
        ticketInfo CaiXuKunTicketinfo = new ticketInfo("CaiXuKun","25 JUN 2023", "Arena of Stars");
        ticketInfo TwiceTicketinfo = new ticketInfo("Twice","31 JUL 2023", "Axiata Arena");
        ticketInfo JayChouTicketinfo = new ticketInfo("Jay Chou","15 JAN 2023", "Stadium Bukit Jalil");
        
        ticketInfo.add(CaiXuKunTicketinfo);
        ticketInfo.add(TwiceTicketinfo);
        ticketInfo.add(JayChouTicketinfo);

        ArrayList<RockZoneTicket> RockZoneTicket = new ArrayList<RockZoneTicket>();
        ArrayList<VIPTicket> VIPTicket = new ArrayList<VIPTicket>();
        ArrayList<NormalZoneTicket> NormalZoneTicket = new ArrayList<NormalZoneTicket>();    
       
        //CaiXuKun Concert
        RockZoneTicket CaiXuKunRockZoneTicket = new RockZoneTicket(758, ticketInfo.get(0),200);
        VIPTicket CaiXuKunVIPTicket = new VIPTicket(200,658, ticketInfo.get(0),200);
        NormalZoneTicket CaiXuKunNormalZoneTicket = new NormalZoneTicket(400,558, ticketInfo.get(0),300);
        // add to array of each area
        RockZoneTicket.add(CaiXuKunRockZoneTicket);
        VIPTicket.add(CaiXuKunVIPTicket);
        NormalZoneTicket.add(CaiXuKunNormalZoneTicket);
        
        //Twice Concert
        RockZoneTicket TwiceRockZoneTicket = new RockZoneTicket(888, ticketInfo.get(1),300);
        VIPTicket TwiceVIPTicket = new VIPTicket(300,788, ticketInfo.get(1),300);
        NormalZoneTicket TwiceNormalZoneTicket = new NormalZoneTicket(600,688, ticketInfo.get(1),400);
        // add to array of each area
        RockZoneTicket.add(TwiceRockZoneTicket);
        VIPTicket.add(TwiceVIPTicket);
        NormalZoneTicket.add(TwiceNormalZoneTicket);
        
        //JayChou Ticket
        RockZoneTicket JayChouRockZoneTicket = new RockZoneTicket(998, ticketInfo.get(2),400);
        VIPTicket JayChouVIPTicket = new VIPTicket(400,898, ticketInfo.get(2),400);
        NormalZoneTicket JayChouNormalZoneTicket = new NormalZoneTicket(800,798, ticketInfo.get(2),500);
        // add to array of each area
        RockZoneTicket.add(JayChouRockZoneTicket);
        VIPTicket.add(JayChouVIPTicket);
        NormalZoneTicket.add(JayChouNormalZoneTicket);    
        
        
        //Start of the program
        boolean flag = true;
        while(flag){
            System.out.println("\nWelcome to Our Ticket System");
        
            Customer c = new Customer();
            Staff s = new Staff();
            int logInStatus=0;

            LogInLoop:
            while(logInStatus !=1){
                System.out.println("Please enter your username and password.");
                sc.nextLine();
                System.out.println("Username: ");
                String username = sc.nextLine();

                System.out.println("Password: ");
                String password = sc.nextLine();

                for (int i = 0; i < person.length; i++) { 
                logInStatus=person[i].checkUsernameAndPassword(username,password);
                if (logInStatus==1){ 
                    System.out.println("Login Successfully!");
                    if (person[i] instanceof VIPCustomer) {
                        System.out.println("\nWelcome VIP Customer "+person[i].getName());
                        c = (VIPCustomer) person[i];
                    }
                    else if (person[i] instanceof Customer) {
                        System.out.println("\nWelcome Customer"+person[i].getName());
                        c = (Customer) person[i];
                    }
                    else {
                        System.out.println("\nWelcome Staff "+person[i].getName());
                        s = (Staff) person[i];
                    }
                    

                    break LogInLoop;
                    }
                } 
                System.out.println("Login Failed! \nPls try again."); 

            }
            
            //if staff login 
            if (s.getName() != null) {
                System.out.println("Menu");
                System.out.println("1.Add concert.");
                System.out.println("2.Display concert");
                System.out.println("Your selection: ");
                int option = sc.nextInt();
                sc.nextLine();
                if (option ==1) {
                    
                    System.out.println("---Add Concert---");
                    
                    System.out.println("Concert Artist: ");
                    String artist = sc.nextLine();
                    
                    System.out.println("Concert Date: ");
                    String date = sc.nextLine();
                    
                    System.out.println("Concert Venue:");
                    String venue = sc.nextLine();
                    
                    ticketInfo tinfo = new ticketInfo(artist,date,venue);
                    ticketInfo.add(tinfo);
                    
                    System.out.println("\nEnter details of Rock Zone Ticket");
                    System.out.println("Price: " );
                    int price = sc.nextInt();
                    System.out.println("Available Ticket: " );
                    int availableTicket = sc.nextInt();
                    RockZoneTicket r = new RockZoneTicket(price, ticketInfo.get(ticketInfo.size()-1),availableTicket);
                    RockZoneTicket.add(r);
                    
                    System.out.println("\nEnter details of VIP Zone Ticket");
                    System.out.println("Price: " );
                    price = sc.nextInt();
                    System.out.println("Available Ticket: " );
                    availableTicket = sc.nextInt();
                    System.out.println("Seat No: " );
                    int seatNo = sc.nextInt();
                    VIPTicket v = new VIPTicket(seatNo,price, ticketInfo.get(ticketInfo.size()-1),availableTicket);
                    VIPTicket.add(v);
                    
                    System.out.println("\nEnter details of Normal Zone Ticket");
                    System.out.println("Price: " );
                    price = sc.nextInt();
                    System.out.println("Available Ticket: " );
                    availableTicket = sc.nextInt();
                    System.out.println("Seat No: " );
                    seatNo = sc.nextInt();
                    NormalZoneTicket n = new NormalZoneTicket(seatNo,price, ticketInfo.get(ticketInfo.size()-1),availableTicket);
                    NormalZoneTicket.add(n);
                }
            }
            
            //if user login
            else{
                //Display Concert Event
                //Prompt user to select concert they willing to go
                System.out.println("\nPlease Select Your Ticket");
                System.out.format("%-16s %-13s %-5s", "Artist", "Date", "Venue"); 
                for (int i = 0; i < ticketInfo.size(); i++) {
                    System.out.println( "\n"+(i+1) + ". "+ ticketInfo.get(i).toString());
                }
                System.out.println("Your selection: ");
                int optionConcert = sc.nextInt()-1;

                //select area of concert
                //display area selection
                System.out.println("\nYou have choosen "+ ticketInfo.get(optionConcert).getArtist() + " concert ticket!\n\n "
                            + "Area available: ");



                // Payment
                char contBuyTicket = 'Y';
                Payment payment = new Payment(); 
                while(contBuyTicket=='Y'){
                    //Prompt User select area 
                    System.out.println(RockZoneTicket.get(optionConcert).toString());
                    System.out.println(VIPTicket.get(optionConcert).toString());
                    System.out.println(NormalZoneTicket.get(optionConcert).toString());
                    System.out.println("Your selection area: ");
                    int optionArea = sc.nextInt();

                    //User input quantity
                    System.out.println("Ticket Quantity: ");
                    int quantity = sc.nextInt();  

                    if (optionArea==1){
                        RockZoneTicket.get(optionConcert).setQuantity(quantity);
                        payment.calculatePayment(c,RockZoneTicket.get(optionConcert));
                    }
                    else if(optionArea==2){
                        VIPTicket.get(optionConcert).setQuantity(quantity);
                        payment.calculatePayment(c,VIPTicket.get(optionConcert));
                    }
                    else if(optionArea == 3){
                        NormalZoneTicket.get(optionConcert).setQuantity(quantity);
                        payment.calculatePayment(c,NormalZoneTicket.get(optionConcert));
                    }

                    System.out.println("Total payment: "+payment.getTotalPayment());
                    System.out.println("Do you want to buy more ticket(Y/N): ");
                    contBuyTicket = sc.next().charAt(0);

                }

                // Payment Confirmation

                System.out.println("\nTotal Ticket Payment: " +payment.getTotalPayment());
                System.out.println("Confirm Payment (Y/N)? ");
                char confPayment = sc.next().charAt(0);

                if(confPayment == 'Y'){
                    //condition wallet balance not enough
                    if (payment.getTotalPayment()> c.getWalletBalance()) {
                        System.out.println("Payment Unsuccessful!\n"
                                + "Your wallet balance is not enough.");
                        System.out.println("Return to Home Page....");
                    }
                    //condition wallet balance is enough
                    else{
                       payment.deductWalletBalance(c);
                       payment.displayPaymentBill(c);
                       //Print Ticket
                        RockZoneTicket.get(optionConcert).DisplayTicket(optionConcert);
                        VIPTicket.get(optionConcert).DisplayTicket(optionConcert);
                        NormalZoneTicket.get(optionConcert).DisplayTicket(optionConcert);
                    }
                }
                else{
                     System.out.println("Return to Home Page....");

                }
            }
                

            
        }
        
        
    }
    
    
 
    
}
