package pl.kazmierski.app.apartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.kazmierski.app.apartment.model.Apartment;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {


    @Query(value = "select * from userdb.apartment where apartment.building=:id", nativeQuery = true)
    List<Apartment> getAllByBuildingId(@Param("id") Long id);
}
