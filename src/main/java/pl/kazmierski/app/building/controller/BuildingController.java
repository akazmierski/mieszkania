package pl.kazmierski.app.building.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.kazmierski.app.building.dto.BuildingRequest;
import pl.kazmierski.app.building.model.Building;
import pl.kazmierski.app.building.repository.BuildingRepository;
import pl.kazmierski.app.building.service.BuildingService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

@Controller
public class BuildingController {

    @Value("${filesPath}")
    private String filesPath;

    @Autowired
    BuildingService buildingService;

    @Autowired
    BuildingRepository buildingRepository;

    @RequestMapping(value = "/add-building", method = RequestMethod.POST,
        headers = "Content-Type=multipart/form-data")
    public String addBuilding(@RequestParam("file") MultipartFile file,
                              @RequestParam("name") String  name,
                              @RequestParam("apartmentsNumber") int apartmentsNumber,
                              @RequestParam("surface") int surface) throws IOException {
        buildingService.saveBuilding(file,name,apartmentsNumber,surface);
        return "redirect:/";
    }

    @GetMapping(value = "/photo/{file_name}")
    public ResponseEntity<Object> getImage (@PathVariable String file_name) throws IOException {
        InputStream in = new FileInputStream(filesPath +file_name);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(MediaType.IMAGE_JPEG_VALUE));
        return new ResponseEntity<Object>(IOUtils.toByteArray(in),headers, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public String deleteBuilding(@PathVariable("id") Long id){
        buildingService.deleteBuilding(id);
        return "redirect:/";
    }



}
