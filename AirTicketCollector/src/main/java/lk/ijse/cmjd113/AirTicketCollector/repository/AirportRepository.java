package lk.ijse.cmjd113.AirTicketCollector.repository;

import lk.ijse.cmjd113.AirTicketCollector.entities.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ✅ NEW FILE: JPA Repository — this is what connects your app to the database
@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, String> {
    // JpaRepository gives you: save(), findById(), findAll(), deleteById() for free
}
