package lk.ijse.cmjd113.AirTicketCollector.Service.impl;

import lk.ijse.cmjd113.AirTicketCollector.Service.AirportService;
import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.entities.AirportEntity;
import lk.ijse.cmjd113.AirTicketCollector.repository.AirportRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// ✅ NEW FILE: Service Implementation — the missing link between controller and DB
@Service
public class AirportServiceIMPL implements AirportService {

    @Autowired
    private AirportRepository airportRepository; // Talks to the DB

    @Autowired
    private ModelMapper modelMapper; // Converts DTO <-> Entity

    @Override
    public AirportDTO saveAirport(AirportDTO airportDTO) {
        // Convert DTO → Entity, save to DB, convert back to DTO and return
        AirportEntity entity = modelMapper.map(airportDTO, AirportEntity.class);
        AirportEntity saved = airportRepository.save(entity);
        return modelMapper.map(saved, AirportDTO.class);
    }

    @Override
    public AirportDTO getSelectedAirport(String airportId) {
        Optional<AirportEntity> entity = airportRepository.findById(airportId);
        if (entity.isPresent()) {
            return modelMapper.map(entity.get(), AirportDTO.class);
        }
        // You can throw a custom exception here later
        throw new RuntimeException("Airport not found with ID: " + airportId);
    }

    @Override
    public List<AirportDTO> getAllAirports() {
        List<AirportEntity> allEntities = airportRepository.findAll();
        // Convert List<Entity> → List<DTO>
        return modelMapper.map(allEntities, new TypeToken<List<AirportDTO>>() {
        }.getType());
    }

    @Override
    public void deleteAirport(String airportId) {
        if (!airportRepository.existsById(airportId)) {
            throw new RuntimeException("Airport not found with ID: " + airportId);
        }
        airportRepository.deleteById(airportId);
    }

    @Override
    public void updateAirport(String airportId, AirportDTO updatedAirport) {
        if (!airportRepository.existsById(airportId)) {
            throw new RuntimeException("Airport not found with ID: " + airportId);
        }
        updatedAirport.setAirportId(airportId); // Ensure the ID stays the same
        AirportEntity entity = modelMapper.map(updatedAirport, AirportEntity.class);
        airportRepository.save(entity);
    }
}
