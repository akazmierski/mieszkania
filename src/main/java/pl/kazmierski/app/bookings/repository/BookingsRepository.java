package pl.kazmierski.app.bookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import pl.kazmierski.app.apartment.model.Apartment;
import pl.kazmierski.app.bookings.model.Bookings;

public interface BookingsRepository extends JpaRepository<Bookings, Long> {

    @Query(value = "select * from userdb.bookings where bookings.apartment=:id", nativeQuery = true)
    List<Bookings> getAllByApartmentId(@Param("id") Long id);

}
