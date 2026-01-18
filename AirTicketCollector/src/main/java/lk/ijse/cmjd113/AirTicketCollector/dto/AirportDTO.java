package lk.ijse.cmjd113.AirTicketCollector.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class AirportDTO {
    private String airportId;
    private String airportCode;
    private String name;
    private String city;
    private String country;


}
