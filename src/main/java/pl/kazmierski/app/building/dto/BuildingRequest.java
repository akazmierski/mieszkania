package pl.kazmierski.app.building.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;


@Data
@Getter
@Setter
public class BuildingRequest {
    public long id;
    public String name;
    public int apartmentsNumber;
    public int surface;

}
