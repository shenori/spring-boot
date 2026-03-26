package lk.ijse.cmjd113.AirTicketCollector.controller;

import lk.ijse.cmjd113.AirTicketCollector.Service.AirportService;
import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.util.IDGenerator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/airports")
@CrossOrigin(origins = "http://localhost:4200") // Allow Angular dev server
public class AirportController {

    @Autowired
    private AirportService airportService; // ✅ FIX: Inject the service

    // Save an airport
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> saveAirport(@RequestBody AirportDTO airportDTO) {
        airportDTO.setAirportId(IDGenerator.airportId()); // Generate ID before saving
        AirportDTO saved = airportService.saveAirport(airportDTO); // ✅ FIX: Use service
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Get Selected Airport
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> getSelectedAirport(@PathVariable("id") String airportId) {
        AirportDTO airportDTO = airportService.getSelectedAirport(airportId); // ✅ FIX: Use service
        return new ResponseEntity<>(airportDTO, HttpStatus.OK);
    }

    // Get All Airports
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AirportDTO>> getAllAirports() {
        List<AirportDTO> allAirports = airportService.getAllAirports(); // ✅ FIX: Use service
        return new ResponseEntity<>(allAirports, HttpStatus.OK);
    }

    // Delete Airport
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable("id") String airportId) {
        airportService.deleteAirport(airportId); // ✅ FIX: Use service
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Update Airport
    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAirport(
            @PathVariable("id") String airportId,
            @RequestBody AirportDTO updatedAirport) {
        airportService.updateAirport(airportId, updatedAirport); // ✅ FIX: Use service
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
