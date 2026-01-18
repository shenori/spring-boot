package lk.ijse.cmjd113.AirTicketCollector.util;

import java.util.UUID;

public class IDGenerator {
    public static String airportId(){
        return "APT-"+ UUID.randomUUID();
    }
}
