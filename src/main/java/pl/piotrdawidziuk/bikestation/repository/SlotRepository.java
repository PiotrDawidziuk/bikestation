package pl.piotrdawidziuk.bikestation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotrdawidziuk.bikestation.model.Slot;

public interface SlotRepository extends JpaRepository<Slot, Long> {
}
