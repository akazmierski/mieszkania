package pl.kazmierski.app.bookings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.kazmierski.app.apartment.repository.ApartmentRepository;
import pl.kazmierski.app.bookings.dto.BookingsRequest;
import pl.kazmierski.app.bookings.model.Bookings;
import pl.kazmierski.app.bookings.repository.BookingsRepository;
import pl.kazmierski.app.bookings.service.BookingsService;

@Controller
public class BookingsController {
    @Autowired
    BookingsService bookingsService;
    @Autowired
    BookingsRepository bookingsRepository;
    @Autowired
    ApartmentRepository apartmentRepository;

    @PostMapping("/add-booking")
    public String addBooking( BookingsRequest bookingsRequest){
        bookingsRepository.save(new Bookings(bookingsRequest.name,
                bookingsRequest.surname,
                bookingsRequest.pesel_number,
                bookingsRequest.email,
                apartmentRepository.getById(bookingsRequest.number_of_apartment)));
        return "redirect:/";

    }
    @PostMapping("/delete_bookings/{id}")
    public String deleteBookings(@PathVariable("id") Long id) {
        bookingsService.deleteBookings(id);
        return "redirect:/";
    }
}
