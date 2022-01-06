package pl.kazmierski.app.apartment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.kazmierski.app.apartment.dto.ApartmentRequest;
import pl.kazmierski.app.apartment.model.Apartment;
import pl.kazmierski.app.apartment.model.ApartmentValidator;
import pl.kazmierski.app.apartment.repository.ApartmentRepository;
import pl.kazmierski.app.apartment.service.ApartmentService;
import pl.kazmierski.app.building.repository.BuildingRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ApartmentController {

    @Autowired
    ApartmentRepository apartmentRepository;

    @Autowired
    ApartmentService apartmentService;

    @Autowired
    BuildingRepository buildingRepository;

    @PostMapping("/add-apartment")
    public String addApartment(ApartmentRequest apartmentRequest){
        // validation
        ApartmentValidator apartmentValidator = apartmentService.validateRequest(apartmentRequest);
        System.out.println(apartmentRequest.number_of_rooms +
                apartmentRequest.floor + apartmentRequest.surface +
                apartmentRequest.buildings_number);
        if(apartmentValidator != null){
            return ResponseEntity.status(400).body(apartmentValidator).toString();
        }
        apartmentRepository.save(
                new Apartment(apartmentRequest.surface,
                        apartmentRequest.number_of_rooms,
                        apartmentRequest.floor,
                        buildingRepository.getById(apartmentRequest.buildings_number)));
        return "redirect:/";
    }




}
