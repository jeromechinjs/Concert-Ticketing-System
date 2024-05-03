import java.lang.reflect.Array;
import java.util.ArrayList;

public class Initializer {
    // declare initial value here, summon at main

    public Person[] personInit() {
        Person[] person = new Person[3];

        person[0] = new Customer(10000, "Wong Xiao Hei", "0177784557", "abcd1234");
        person[1] = new VIPCustomer(15000, "Lee Ai Kun", "0177789557", "iamikun");
        person[2] = new Staff("Kok", "0199447000", "kok123");

        return person;
    }

    public ArrayList ticketInit() {
        ArrayList<TicketInfo> ticketInfo = new ArrayList<TicketInfo>();
        TicketInfo CaiXuKunTicketinfo = new TicketInfo("CaiXuKun", "25 JUN 2023", "Arena of Stars");
        TicketInfo TwiceTicketinfo = new TicketInfo("Twice", "31 JUL 2023", "Axiata Arena");
        TicketInfo JayChouTicketinfo = new TicketInfo("Jay Chou", "15 JAN 2023", "Stadium Bukit Jalil");

        ticketInfo.add(CaiXuKunTicketinfo);
        ticketInfo.add(TwiceTicketinfo);
        ticketInfo.add(JayChouTicketinfo);

        return ticketInfo;
    }
}
