package pl.kazmierski.app.building.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kazmierski.app.building.model.Building;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}