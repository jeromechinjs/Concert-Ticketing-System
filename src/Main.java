
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void print(String s) {
        System.out.print(s);
    }

    private static void println(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // establish ui and initiator
        Initializer init = new Initializer();
        UI ui = new UI();

        // example of calling UI
        ui.mainMenuDisplay();

        // Sample of initiating object
        // Person[] person = init.personInit();
        Person[] person = new Person[3];
        person[0] = new Customer(10000, "Wong Xiao Hei", "0177784557", "abcd1234");
        person[1] = new VIPCustomer(15000, "Lee Ai Kun", "0177789557", "iamikun");
        person[2] = new Staff("Kok", "0199447000", "kok123");

        ArrayList<TicketInfo> ticketInfo = new ArrayList<TicketInfo>();
        TicketInfo CaiXuKunTicketinfo = new TicketInfo("CaiXuKun", "25 JUN 2023", "Arena of Stars");
        TicketInfo TwiceTicketinfo = new TicketInfo("Twice", "31 JUL 2023", "Axiata Arena");
        TicketInfo JayChouTicketinfo = new TicketInfo("Jay Chou", "15 JAN 2023", "Stadium Bukit Jalil");

        ticketInfo.add(CaiXuKunTicketinfo);
        ticketInfo.add(TwiceTicketinfo);
        ticketInfo.add(JayChouTicketinfo);

        ArrayList<RockZoneTicket> RockZoneTicket = new ArrayList<RockZoneTicket>();
        ArrayList<VIPTicket> VIPTicket = new ArrayList<VIPTicket>();
        ArrayList<NormalZoneTicket> NormalZoneTicket = new ArrayList<NormalZoneTicket>();

        // CaiXuKun Concert
        RockZoneTicket CaiXuKunRockZoneTicket = new RockZoneTicket(758, ticketInfo.get(0), 200);
        VIPTicket CaiXuKunVIPTicket = new VIPTicket(200, 658, ticketInfo.get(0), 200);
        NormalZoneTicket CaiXuKunNormalZoneTicket = new NormalZoneTicket(400, 558, ticketInfo.get(0), 300);
        // add to array of each area
        RockZoneTicket.add(CaiXuKunRockZoneTicket);
        VIPTicket.add(CaiXuKunVIPTicket);
        NormalZoneTicket.add(CaiXuKunNormalZoneTicket);

        // Twice Concert
        RockZoneTicket TwiceRockZoneTicket = new RockZoneTicket(888, ticketInfo.get(1), 300);
        VIPTicket TwiceVIPTicket = new VIPTicket(300, 788, ticketInfo.get(1), 300);
        NormalZoneTicket TwiceNormalZoneTicket = new NormalZoneTicket(600, 688, ticketInfo.get(1), 400);
        // add to array of each area
        RockZoneTicket.add(TwiceRockZoneTicket);
        VIPTicket.add(TwiceVIPTicket);
        NormalZoneTicket.add(TwiceNormalZoneTicket);

        // JayChou Ticket
        RockZoneTicket JayChouRockZoneTicket = new RockZoneTicket(998, ticketInfo.get(2), 400);
        VIPTicket JayChouVIPTicket = new VIPTicket(400, 898, ticketInfo.get(2), 400);
        NormalZoneTicket JayChouNormalZoneTicket = new NormalZoneTicket(800, 798, ticketInfo.get(2), 500);
        // add to array of each area
        RockZoneTicket.add(JayChouRockZoneTicket);
        VIPTicket.add(JayChouVIPTicket);
        NormalZoneTicket.add(JayChouNormalZoneTicket);

        // Start of the program
        boolean flag = true;
        while (flag) {
            println("\nWelcome to Our Ticket System");

            Customer c = new Customer();
            Staff s = new Staff();
            int logInStatus = 0;

            LogInLoop: while (logInStatus != 1) {
                println("Please enter your username and password.");
                print("Username: ");
                String username = sc.nextLine();

                print("Password: ");
                String password = sc.nextLine();

                for (int i = 0; i < person.length; i++) {
                    logInStatus = person[i].checkUsernameAndPassword(username, password);
                    if (logInStatus == 1) {
                        println("Login Successfully!");
                        if (person[i] instanceof VIPCustomer) {
                            println("\nWelcome VIP Customer " + person[i].getName());
                            c = (VIPCustomer) person[i];
                        } else if (person[i] instanceof Customer) {
                            println("\nWelcome Customer" + person[i].getName());
                            c = (Customer) person[i];
                        } else {
                            println("\nWelcome Staff " + person[i].getName());
                            s = (Staff) person[i];
                        }

                        break LogInLoop;
                    }
                }
                println("Login Failed! \nPls try again.");

            }

            // if staff login
            if (s.getName() != null) {
                println("Menu");
                println("1.Add concert.");
                println("2.Display concert");
                println("Your selection: ");
                int option = sc.nextInt();
                sc.nextLine();
                if (option == 1) {

                    println("---Add Concert---");

                    println("Concert Artist: ");
                    String artist = sc.nextLine();

                    println("Concert Date: ");
                    String date = sc.nextLine();

                    println("Concert Venue:");
                    String venue = sc.nextLine();

                    TicketInfo tinfo = new TicketInfo(artist, date, venue);
                    ticketInfo.add(tinfo);

                    println("\nEnter details of Rock Zone Ticket");
                    println("Price: ");
                    int price = sc.nextInt();
                    println("Available Ticket: ");
                    int availableTicket = sc.nextInt();
                    RockZoneTicket r = new RockZoneTicket(price, ticketInfo.get(ticketInfo.size() - 1),
                            availableTicket);
                    RockZoneTicket.add(r);

                    println("\nEnter details of VIP Zone Ticket");
                    println("Price: ");
                    price = sc.nextInt();
                    println("Available Ticket: ");
                    availableTicket = sc.nextInt();
                    println("Seat No: ");
                    int seatNo = sc.nextInt();
                    VIPTicket v = new VIPTicket(seatNo, price, ticketInfo.get(ticketInfo.size() - 1), availableTicket);
                    VIPTicket.add(v);

                    println("\nEnter details of Normal Zone Ticket");
                    println("Price: ");
                    price = sc.nextInt();
                    println("Available Ticket: ");
                    availableTicket = sc.nextInt();
                    println("Seat No: ");
                    seatNo = sc.nextInt();
                    NormalZoneTicket n = new NormalZoneTicket(seatNo, price, ticketInfo.get(ticketInfo.size() - 1),
                            availableTicket);
                    NormalZoneTicket.add(n);
                }
            }

            // if user login
            else {
                // Display Concert Event
                // Prompt user to select concert they willing to go
                println("\nPlease Select Your Ticket");
                System.out.format("%-16s %-13s %-5s", "Artist", "Date", "Venue");
                for (int i = 0; i < ticketInfo.size(); i++) {
                    println("\n" + (i + 1) + ". " + ticketInfo.get(i).toString());
                }
                println("Your selection: ");
                int optionConcert = sc.nextInt() - 1;

                // select area of concert
                // display area selection
                println(
                        "\nYou have choosen " + ticketInfo.get(optionConcert).getArtist() + " concert ticket!\n\n "
                                + "Area available: ");

                // Payment
                char contBuyTicket = 'Y';
                Payment payment = new Payment();
                while (contBuyTicket == 'Y') {
                    // Prompt User select area
                    println(RockZoneTicket.get(optionConcert).toString());
                    println(VIPTicket.get(optionConcert).toString());
                    println(NormalZoneTicket.get(optionConcert).toString());
                    println("Your selection area: ");
                    int optionArea = sc.nextInt();

                    // User input quantity
                    println("Ticket Quantity: ");
                    int quantity = sc.nextInt();

                    if (optionArea == 1) {
                        RockZoneTicket.get(optionConcert).setQuantity(quantity);
                        payment.calculatePayment(c, RockZoneTicket.get(optionConcert));
                    } else if (optionArea == 2) {
                        VIPTicket.get(optionConcert).setQuantity(quantity);
                        payment.calculatePayment(c, VIPTicket.get(optionConcert));
                    } else if (optionArea == 3) {
                        NormalZoneTicket.get(optionConcert).setQuantity(quantity);
                        payment.calculatePayment(c, NormalZoneTicket.get(optionConcert));
                    }

                    println("Total payment: " + payment.getTotalPayment());
                    println("Do you want to buy more ticket(Y/N): ");
                    contBuyTicket = sc.next().charAt(0);

                }

                // Payment Confirmation

                println("\nTotal Ticket Payment: " + payment.getTotalPayment());
                println("Confirm Payment (Y/N)? ");
                char confPayment = sc.next().charAt(0);

                if (confPayment == 'Y') {
                    // condition wallet balance not enough
                    if (payment.getTotalPayment() > c.getWalletBalance()) {
                        println("Payment Unsuccessful!\n"
                                + "Your wallet balance is not enough.");
                        println("Return to Home Page....");
                    }
                    // condition wallet balance is enough
                    else {
                        payment.deductWalletBalance(c);
                        payment.displayPaymentBill(c);
                        // Print Ticket
                        RockZoneTicket.get(optionConcert).DisplayTicket(optionConcert);
                        VIPTicket.get(optionConcert).DisplayTicket(optionConcert);
                        NormalZoneTicket.get(optionConcert).DisplayTicket(optionConcert);
                    }
                } else {
                    println("Return to Home Page....");

                }
            }

        }

    }

}
