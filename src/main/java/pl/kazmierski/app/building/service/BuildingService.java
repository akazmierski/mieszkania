package pl.kazmierski.app.building.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pl.kazmierski.app.apartment.model.Apartment;
import pl.kazmierski.app.apartment.repository.ApartmentRepository;
import pl.kazmierski.app.bookings.model.Bookings;
import pl.kazmierski.app.bookings.repository.BookingsRepository;
import pl.kazmierski.app.bookings.service.BookingsService;
import pl.kazmierski.app.building.model.Building;
import pl.kazmierski.app.building.repository.BuildingRepository;
import org.apache.commons.io.IOUtils;

@Service
public class BuildingService {

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    ApartmentRepository apartmentRepository;

    @Autowired
    BookingsService bookingsService;

    @Value("${filesPath}")
    private String filesPath;



    public void saveBuilding(MultipartFile file, String  name, int apartmentsNumber,
                             int surface){
        Building building = buildingRepository.save(new Building(name,
            apartmentsNumber,surface));

        String fileName = file.getOriginalFilename();
        Path path = Paths.get(filesPath, fileName.trim());
        String extension = getFileExtension(file);
        building.setFilePath(fileName);
        buildingRepository.saveAndFlush(building);
        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public String getFileExtension(MultipartFile file){
        String extension = "";

        int i = file.getOriginalFilename().lastIndexOf('.');
        if (i > 0) {
            extension = file.getOriginalFilename().substring(i+1);
        }
        return ("." + extension);
    }

    public void deleteBuilding(Long id){
        // check if building has apartaments
        List<Apartment> list = apartmentRepository.getAllByBuildingId(id);
        Iterator<Apartment> it = list.iterator();
        while(it.hasNext()){
            Apartment apartment = it.next();
            // check if has bookings
            bookingsService.deleteAllBookingForApartment(apartment.getId());
            apartmentRepository.delete(apartment);
        }
        buildingRepository.deleteById(id);
    }
}
