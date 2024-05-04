
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
                            exit = true;
                            return;
                        case "Customer":
                            println("\nWelcome Customer " + person.get(i).getName());
                            c = (Customer) person.get(i);
                            loggedIn = true;
                            exit = true;
                            return;
                        case "Staff":
                            println("\nWelcome Staff " + person.get(i).getName());
                            s = (Staff) person.get(i);
                            loggedIn = true;
                            exit = true;
                            return;
                    }
                }
            }
            println("Login failed! Please try again");
        }
    }

    public static void main(String[] args) {
        // establish ui and initiator
        Initializer init = new Initializer();
        // UI ui = new UI();

        // Initializing initial data
        ArrayList<Person> person = init.personInit();// Account detail
        ArrayList<TicketInfo> ticketInfo = init.ticketInit();
        ArrayList<RockZoneTicket> rockZoneTickets = init.rockZoneTicketsInit();
        ArrayList<VIPTicket> vipTickets = init.vipTicketsInit();
        ArrayList<NormalZoneTicket> normalZoneTickets = init.normalZoneTicketsInit();

        Scanner sc = new Scanner(System.in);

        // Start of the program
        boolean flag = true;
        MainLoop: while (flag) {
            Customer c = new Customer();
            Staff s = new Staff();
            Boolean exit = false;

            Welcome: while (!exit) {
                int selection = Welcome(sc);

                if (selection == 1) {
                    Register(selection, sc, person, exit);
                    if (exit)
                        continue Welcome;
                } else if (selection == 2) {
                    Login(selection, sc, person, c, s, exit);
                    if (exit)
                        continue Welcome;
                    else
                        break Welcome;
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
                    rockZoneTickets.add(r);

                    println("\nEnter details of VIP Zone Ticket");
                    println("Price: ");
                    price = sc.nextInt();
                    println("Available Ticket: ");
                    availableTicket = sc.nextInt();
                    println("Seat No: ");
                    int seatNo = sc.nextInt();
                    VIPTicket v = new VIPTicket(seatNo, price, ticketInfo.get(ticketInfo.size() - 1), availableTicket);
                    vipTickets.add(v);

                    println("\nEnter details of Normal Zone Ticket");
                    println("Price: ");
                    price = sc.nextInt();
                    println("Available Ticket: ");
                    availableTicket = sc.nextInt();
                    println("Seat No: ");
                    seatNo = sc.nextInt();
                    NormalZoneTicket n = new NormalZoneTicket(seatNo, price, ticketInfo.get(ticketInfo.size() - 1),
                            availableTicket);
                    normalZoneTickets.add(n);
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
                    println(rockZoneTickets.get(optionConcert).toString());
                    println(vipTickets.get(optionConcert).toString());
                    println(normalZoneTickets.get(optionConcert).toString());
                    println("Your selection area: ");
                    int optionArea = sc.nextInt();

                    // User input quantity
                    println("Ticket Quantity: ");
                    int quantity = sc.nextInt();

                    if (optionArea == 1) {
                        rockZoneTickets.get(optionConcert).setQuantity(quantity);
                        payment.calculatePayment(c, rockZoneTickets.get(optionConcert));
                    } else if (optionArea == 2) {
                        vipTickets.get(optionConcert).setQuantity(quantity);
                        payment.calculatePayment(c, vipTickets.get(optionConcert));
                    } else if (optionArea == 3) {
                        normalZoneTickets.get(optionConcert).setQuantity(quantity);
                        payment.calculatePayment(c, normalZoneTickets.get(optionConcert));
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
                        rockZoneTickets.get(optionConcert).DisplayTicket(optionConcert);
                        vipTickets.get(optionConcert).DisplayTicket(optionConcert);
                        normalZoneTickets.get(optionConcert).DisplayTicket(optionConcert);
                    }
                } else {
                    println("Return to Home Page....");

                }
            }

        }

    }

}
