package pl.kazmierski.app.bookings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

import pl.kazmierski.app.bookings.model.Bookings;
import pl.kazmierski.app.bookings.repository.BookingsRepository;

@Service
public class BookingsService {

    @Autowired
    BookingsRepository bookingsRepository;

    public void deleteAllBookingForApartment(Long id){
        List<Bookings> bookingsList = bookingsRepository.getAllByApartmentId(id);
        Iterator<Bookings> itBooking = bookingsList.iterator();
        while(itBooking.hasNext()) {
            Bookings bookings = itBooking.next();
            bookingsRepository.delete(bookings);
        }
    }
    public void deleteBookings(Long id){
        bookingsRepository.deleteById(id);
    }
}
