package lk.ijse.cmjd113.AirTicketCollector.controller;

import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.util.IDGenerator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;


@RestController
@RequestMapping("/api/v1/airports")
public class AirportController {
    // Save an airport
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> saveAirport(
            @RequestBody AirportDTO airportDTO){
        airportDTO.setAirportId(IDGenerator.airportId());
        return new ResponseEntity<>(airportDTO, HttpStatus.CREATED);
    }

    //Get Selected Airport
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> getSelectedAirport(@PathVariable ("id") String airportId){
        var airportDTO = new AirportDTO(
                airportId,
                "CMB",
                "Bandaranayake International Airport",
                "Katunayaka",
                "SL"
        );
        return new ResponseEntity<>(airportDTO,HttpStatus.OK);
    }
}
