package pl.piotrdawidziuk.bikestation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import pl.piotrdawidziuk.bikestation.model.BikeStation;

public interface BikeStationRepository extends JpaRepository<BikeStation, Long> {

}
