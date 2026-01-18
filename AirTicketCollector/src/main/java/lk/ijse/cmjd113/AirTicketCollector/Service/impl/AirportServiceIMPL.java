package lk.ijse.cmjd113.AirTicketCollector.Service.impl;

import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.Service.AirportService;
import lk.ijse.cmjd113.AirTicketCollector.util.IDGenerator;

import java.util.List;

public class AirportServiceIMPL implements AirportService {
    @Override
    public AirportDTO saveAirport(AirportDTO airport) {
        airport.setAirportId(IDGenerator.airportId());
        return airport;
    }

    @Override
    public AirportDTO getSelectedAirport(String airportId) {
        return null;
    }

    @Override
    public List<AirportDTO> getAllAirports() {
        return List.of();
    }

    @Override
    public void deleteAirport(String airportId) {

    }

    @Override
    public void updateAirport(String airportId, AirportDTO updatedAirport) {

    }
}