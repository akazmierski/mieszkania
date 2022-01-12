package pl.kazmierski.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kazmierski.app.apartment.dto.ApartmentRequest;
import pl.kazmierski.app.apartment.repository.ApartmentRepository;
import pl.kazmierski.app.bookings.dto.BookingsRequest;
import pl.kazmierski.app.bookings.repository.BookingsRepository;
import pl.kazmierski.app.building.dto.BuildingRequest;
import pl.kazmierski.app.building.repository.BuildingRepository;


@Controller
public class GetController {

    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    ApartmentRepository apartmentRepository;
    @Autowired
    BookingsRepository bookingsRepository;

    @GetMapping("/")
    public String homePage(){
        return "mainPage";
    }

    @GetMapping("/showAddBuilidngForm")
    public String showAddBuilidingForm(Model model){
        System.out.println("KOTTT");
        model.addAttribute("buildingRequest",new BuildingRequest());
        return "add_building";
    }
    @GetMapping("/showAddApartmentForm")
    public String showAddApartmentForm(Model model){
        model.addAttribute("apartmentRequest", new ApartmentRequest());
        model.addAttribute("buildingList", buildingRepository.findAll());
        return "add_apartment";
    }
    @GetMapping("/showBuilidingsForm")
    public String showBuilidingsForm(Model model){
        model.addAttribute("buildingList", buildingRepository.findAll());
        return "display_buildings";
    }
    @GetMapping("/showAddBookingsForm")
    public String showAddBookingsForm(Model model){
        model.addAttribute("bookingsRequest", new BookingsRequest());
        return "add_bookings";
    }
    @GetMapping("/showApartmentForm")
    public String showApartmentForm(Model model){
        model.addAttribute("apartmentList", apartmentRepository.findAll());
        return "display_apartments";
    }
    @GetMapping("showBookingsForm")
    public String showBookingsForm(Model model){
        model.addAttribute("bookingList",bookingsRepository.findAll());
        return "display_bookings";
    }

}
