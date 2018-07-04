package pl.piotrdawidziuk.bikestation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import pl.piotrdawidziuk.bikestation.model.Station;

public interface StationRepository extends JpaRepository<Station, Long> {

}
