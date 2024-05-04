
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Scanner;

// lets's add more comments

public class Main {
    private static void print(String s) {
        System.out.print(s);
    }

    private static void println(String s) {
        System.out.println(s);
    }

    private static int Welcome(Scanner sc) {
        println("\nWelcome to Our Ticket System");
        println("Register or Login?\n");
        println("1. Register");
        println("2. Login\n");
        print("Your selection: ");
        int selection = sc.nextInt();
        return selection;
    }

    private static void Register(int selection, Scanner sc, ArrayList<Person> person, Boolean exit) {
        println("\nRegister");
        println("------------");
        println("Please enter your username and password. (type -1 to exit)");
        print("Username: ");
        String username = sc.next();
        if (username.equals("-1")) {
            exit = true;
            return;
        }

        print("Phone Number: ");
        String phone = sc.next();
        if (phone.equals("-1")) {
            exit = true;
            return;
        }

        print("Password: ");
        String password = sc.next();
        if (password.equals("-1")) {
            exit = true;
            return;
        }

        double walletBalance = 0;

        Customer newCustomer = new Customer(walletBalance, username, phone, password);
        person.add(newCustomer);
        println("Registered Successfully!\n");
        println("You may login now...");
    }

    private static void Login(int selection,
            Scanner sc,
            ArrayList<Person> person,
            Customer c,
            Staff s,
            Boolean exit) {
        Boolean loggedIn = false;

        while (!loggedIn) {
            println("\nLogin");
            println("---------");
            println("Please enter your username and password. (type -1 to exit)");
            print("Username: ");
            String username = sc.next();
            if (username == "-1" || username.equals("-1")) {
                exit = true;
                return;
            }

            print("Password: ");
            String password = sc.next();
            if (password.equals("-1")) {
                exit = true;
                return;
            }

            for (int i = 0; i < person.size(); i++) {
                loggedIn = person.get(i).checkUsernameAndPassword(username, password);
                if (loggedIn) {
                    println("Login Successfully!");
                    String customerType = person.get(i) instanceof VIPCustomer ? "VIP Customer"
                            : person.get(i) instanceof Customer ? "Customer" : "Staff";

                    switch (customerType) {
                        case "VIP Customer":
                            println("\nWelcome VIP Customer " + person.get(i).getName());
                            c = (VIPCustomer) person.get(i);
                            loggedIn = true;
                        return;
                        case "Customer":
                            println("\nWelcome Customer " + person.get(i).getName());
                            c = (Customer) person.get(i);
                            loggedIn = true;
                        return;
                        case "Staff":
                            println("\nWelcome Staff " + person.get(i).getName());
                            s = (Staff) person.get(i);
                            loggedIn = true;
                        return;
                    }
                }
            }
            println("Login failed! Please try again");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Person> person = new ArrayList<Person>();
        // Some default users
        person.add(new Customer(10000, "Wong Xiao Hei", "0177784557", "abcd1234"));
        person.add(new VIPCustomer(15000, "Lee Ai Kun", "0177789557", "iamikun"));
        person.add(new Staff("Kok", "0199447000", "kok123"));

        ArrayList<TicketInfo> ticketInfo = new ArrayList<TicketInfo>();
        ticketInfo.add(
            new TicketInfo("CaiXuKun", "25 JUN 2023", "Arena of Stars")
        );
        ticketInfo.add(
            new TicketInfo("Twice", "31 JUL 2023", "Axiata Arena")
        );
        ticketInfo.add(
            new TicketInfo("Jay Chou", "15 JAN 2023", "Stadium Bukit Jalil")
        );

        ArrayList<RockZoneTicket> rockZoneTickets = new ArrayList<RockZoneTicket>();
        ArrayList<VIPTicket> vipTickets = new ArrayList<VIPTicket>();
        ArrayList<NormalZoneTicket> normalZoneTickets = new ArrayList<NormalZoneTicket>();

        // CaiXuKun Concert
        rockZoneTickets.add(new RockZoneTicket(758, ticketInfo.get(0), 200));
        vipTickets.add(new VIPTicket(200, 658, ticketInfo.get(0), 200));
        normalZoneTickets.add(new NormalZoneTicket(400, 558, ticketInfo.get(0), 300));

        // Twice Concert
        rockZoneTickets.add(new RockZoneTicket(888, ticketInfo.get(1), 300));
        vipTickets.add(new VIPTicket(300, 788, ticketInfo.get(1), 300));
        normalZoneTickets.add(new NormalZoneTicket(600, 688, ticketInfo.get(1), 400));

        // JayChou Ticket
        rockZoneTickets.add(new RockZoneTicket(998, ticketInfo.get(2), 400));
        vipTickets.add(new VIPTicket(400, 898, ticketInfo.get(2), 400));
        normalZoneTickets.add(new NormalZoneTicket(800, 798, ticketInfo.get(2), 500));

        // Added a new directoring to store UI, input validation so on.
        UI ui = new UI();

        // example of calling UI
        ui.mainMenuDisplay();

        // Start of the program
        boolean flag = true;
        MainLoop: while (flag) {
            Customer c = new Customer();
            Staff s = new Staff();
            Boolean loggedIn = false, exit = false;

            Welcome: while(!exit) {
                int selection = Welcome(sc);

                if (selection == 1) {
                    Register(selection, sc, person, exit);
                    if (exit) continue Welcome;
                }
                else if (selection == 2) {
                    Login(selection, sc, person, c, s, exit);
                    if (exit) continue Welcome;
                }
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
                if (c.getWalletBalance() == 0) {
                    print("We noticed that you have not top up your wallet yet. Do you want to top up now? (Y/N)");
                    char topUp = sc.next().charAt(0);
                    if (topUp == 'Y' || topUp == 'y') {
                        print("Enter amount to top up: ");
                        double amount = sc.nextDouble();
                        c.setWalletBalance(amount);
                        println("Top up successful! Your current wallet balance is: " + c.getWalletBalance());
                    }
                }

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
