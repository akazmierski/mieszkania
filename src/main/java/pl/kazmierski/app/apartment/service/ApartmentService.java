package pl.kazmierski.app.apartment.service;

import org.springframework.stereotype.Service;
import pl.kazmierski.app.apartment.dto.ApartmentRequest;
import pl.kazmierski.app.apartment.model.ApartmentValidator;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentService {

    public ApartmentValidator validateRequest(ApartmentRequest apartmentRequest){
        List<String> errorList = new ArrayList<>();
        String reason = null;
        if(apartmentRequest.getFloor()==null){
            errorList.add("floor");
            reason ="null";
            return new ApartmentValidator(errorList,reason);
        }
        return null;
    }
}
