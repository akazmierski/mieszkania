package pl.kazmierski.app.apartment.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ApartmentRequest {
    public Integer surface;
    public Integer number_of_rooms;
    public Integer floor;
    public Long buildings_number;

    public Integer getFloor() {
        return floor;
    }

    public Long getBuildings_number() {
        return buildings_number;
    }

    public void setBuildings_number(Long buildings_number) {
        this.buildings_number = buildings_number;
    }
}
