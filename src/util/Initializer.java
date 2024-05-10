package util;
//import java.lang.reflect.Array;

import java.util.ArrayList;
import model.Person;
import model.Customer;
import model.VIPCustomer;
import model.Staff;
import model.TicketInfo;
import model.RockZoneTicket;
import model.VIPTicket;
import model.NormalZoneTicket;

public class Initializer {
    // declare initial value here, summon at main

    public ArrayList<Person> personInit() {
        ArrayList<Person> person = new ArrayList<Person>();

        // Some default users
        person.add(new Customer(10000, "Wong Xiao Hei", "0177784557", "abcd1234"));
        person.add(new VIPCustomer(15000, "Lee Ai Kun", "0177789557", "iamikun"));
        person.add(new Staff("Kok", "0199447000", "kok123"));
        person.add(new Staff("", "", ""));
        person.add(new Customer(15000, "v", "123", ""));
        return person;
    }

    public ArrayList<TicketInfo> ticketInit() {
        ArrayList<TicketInfo> ticketInfo = new ArrayList<TicketInfo>();
        ticketInfo.add(
                new TicketInfo("CaiXuKun", "25 JUN 2023", "Arena of Stars"));
        ticketInfo.add(
                new TicketInfo("Twice", "31 JUL 2023", "Axiata Arena"));
        ticketInfo.add(
                new TicketInfo("Jay Chou", "15 JAN 2023", "Stadium Bukit Jalil"));

        return ticketInfo;
    }

    public ArrayList<RockZoneTicket> rockZoneTicketsInit() {
        ArrayList<TicketInfo> ticketInfo = ticketInit();
        // create new obj
        ArrayList<RockZoneTicket> rockZoneTickets = new ArrayList<RockZoneTicket>();

        // CaiXuKun Concert
        rockZoneTickets.add(new RockZoneTicket(758, ticketInfo.get(0), 200));

        // Twice Concert
        rockZoneTickets.add(new RockZoneTicket(888, ticketInfo.get(1), 300));

        // JayChou Ticket
        rockZoneTickets.add(new RockZoneTicket(998, ticketInfo.get(2), 400));

        return rockZoneTickets;
    }

    public ArrayList<VIPTicket> vipTicketsInit() {
        ArrayList<TicketInfo> ticketInfo = ticketInit();
        // create new obj
        ArrayList<VIPTicket> vipTickets = new ArrayList<VIPTicket>();

        // CaiXuKun Concert
        vipTickets.add(new VIPTicket(200, 658, ticketInfo.get(0), 200));

        // Twice Concert
        vipTickets.add(new VIPTicket(300, 788, ticketInfo.get(1), 300));

        // JayChou Ticket
        vipTickets.add(new VIPTicket(400, 898, ticketInfo.get(2), 400));

        return vipTickets;
    }

    public ArrayList<NormalZoneTicket> normalZoneTicketsInit() {
        ArrayList<TicketInfo> ticketInfo = ticketInit();
        // create new obj
        ArrayList<NormalZoneTicket> normalZoneTickets = new ArrayList<NormalZoneTicket>();

        // CaiXuKun Concert
        normalZoneTickets.add(new NormalZoneTicket(400, 558, ticketInfo.get(0), 300));

        // Twice Concert
        normalZoneTickets.add(new NormalZoneTicket(600, 688, ticketInfo.get(1), 400));

        // JayChou Ticket
        normalZoneTickets.add(new NormalZoneTicket(800, 798, ticketInfo.get(2), 500));

        return normalZoneTickets;
    }
}